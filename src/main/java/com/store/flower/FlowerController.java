package com.store.flower;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.flower.entity.Flower;


@Controller
public class FlowerController {
	

	@Autowired
    private FlowerDAO flowerDAO;
	
	@RequestMapping("/")
    public String home(ModelMap map, HttpServletRequest request,
    		@RequestParam(value = "deleteSuccess", required = false) String deleteSuccess,
    		@RequestParam(value = "editSuccess", required = false) String editSuccess) {
		List<Flower> listFlower = flowerDAO.getAllFlower();
		Collections.shuffle(listFlower);
		map.addAttribute("listFlower", listFlower);
		map.addAttribute("deleteSuccess", deleteSuccess);
		map.addAttribute("editSuccess", editSuccess);
		
		HttpSession session = request.getSession();
        String usernameFlowerStore = (String) session.getAttribute("usernameFlowerStore");
        map.addAttribute("usernameFlowerStore", usernameFlowerStore);
		
		return isLoginToAdminPage(request, "index");
    }
    
    @RequestMapping("/flower_chucmung")
    public String hoachucmung(ModelMap map) {
    	String sttm = "SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id where fst.name like '%Hoa chúc mừng%';";
		List<Flower> listFlower = flowerDAO.getKindOfFlower(sttm);
		Collections.shuffle(listFlower);
		map.addAttribute("listFlower", listFlower);
		
    	return "flower_chucmung";
    }
    
    @RequestMapping("/flower_nhagiao")
    public String hoanhagiao(ModelMap map) {
    	String sttm = "SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id where fst.name like '%Ngày nhà giáo Việt Nam%';";
		List<Flower> listFlower = flowerDAO.getKindOfFlower(sttm);
		Collections.shuffle(listFlower);
		map.addAttribute("listFlower", listFlower);
		
    	return "flower_nhagiao";
    }
    
    @RequestMapping("/flower_cuame")
    public String hoacuame(ModelMap map) {
    	String sttm = "SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id where fst.name like '%Hoa của mẹ%';";
		List<Flower> listFlower = flowerDAO.getKindOfFlower(sttm);
		Collections.shuffle(listFlower);
		map.addAttribute("listFlower", listFlower);
		
    	return "flower_cuame";
    }
    
    @RequestMapping("/flower_tinhyeu")
    public String hoatinhyeu(ModelMap map) {
    	String sttm = "SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id where fst.name like '%Hoa tình yêu%';";
		List<Flower> listFlower = flowerDAO.getKindOfFlower(sttm);
		Collections.shuffle(listFlower);
		map.addAttribute("listFlower", listFlower);
		
    	return "flower_tinhyeu";
    }
    
    @RequestMapping("/add_flower")
    public String add_itemfood(ModelMap map) {
    	return "flower_add";
    }
    
    @RequestMapping(value = "/add_flower", method=RequestMethod.POST)
    public String add_itemfoodPost(ModelMap map,
    		@RequestParam("flower_name") String flower_name,
    		@RequestParam("name") String name,
    		@RequestParam("price") int price,
    		@RequestParam("link_image") String link_image,
    		@RequestParam("description") String description) {
    	
    	int flowerId = 0;
    	if(flower_name.contains("chucmung")) {
    		flowerId = 1;
    	} else if (flower_name.contains("nhagiao")) {
    		flowerId = 2;
    	} else if (flower_name.contains("cuame")) {
    		flowerId = 3;
    	} else if (flower_name.contains("tinhyeu")) {
    		flowerId = 4;
    	}
    	
    	flowerDAO.saveFlower(name, price, link_image, description, flowerId);
    	map.addAttribute("addingSuccess", "Thêm loại hoa thành công");
    	return "flower_add";
    }
    
    @RequestMapping(value = "/search_flower", method = RequestMethod.POST, params = "searchingFlower")
    public String search_flower(ModelMap map,
    		@RequestParam("searchingFlower") String searchingFlower) {
        
    	map.addAttribute("searchingFlower", searchingFlower);
    	String sttm = "SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id where LOWER(flw.name) like LOWER(\'%"+ searchingFlower +"%\')";
    	List<Flower> listFlower = flowerDAO.getSearchFlower(sttm);
    	map.addAttribute("listFlower", listFlower);
    	
    	return "flower_search";
    }
	
    @RequestMapping("/flower_detail")
    public String flower_detail(ModelMap map,
    		@RequestParam("id") String id) {
    	Flower flower = flowerDAO.getFlower(id);
    	map.addAttribute("flower", flower);

    	return "detail_flower";
    }
    
    @RequestMapping("/flower_delete")
    public String flower_delete(ModelMap map,
    		@RequestParam("id") String id) {
    	Flower flower = flowerDAO.getFlower(id);
    	map.addAttribute("flower", flower);

    	return "flower_delete";
    }
    
    @RequestMapping("/flower_delete_confirm")
    public String flower_delete_confirm(ModelMap map,
    		@RequestParam("id") String id) {
    	flowerDAO.deleteFlower(id);
    	map.addAttribute("deleteSuccess", "Xóa thành công loại hoa có id: " + id);
    	return "redirect:/";
    }
    
    @RequestMapping("/flower_edit")
    public String itemfood_edit(ModelMap map,
    		@RequestParam("id") String id) {
    	Flower flower = flowerDAO.getFlower(id);
    	map.addAttribute("flower", flower);

    	return "flower_edit";
    }
    
    @RequestMapping(value = "/flower_edit", method=RequestMethod.POST)
    public String itemfood_editPost(ModelMap map,
    		@RequestParam("id") String id,
    		@RequestParam("flower_name") String flower_name,
    		@RequestParam("name") String name,
    		@RequestParam("price") int price,
    		@RequestParam("link_image") String link_image,
    		@RequestParam("description") String description) {
    	
    	int flowerId = 0;
    	if(flower_name.contains("chucmung")) {
    		flowerId = 1;
    	} else if (flower_name.contains("nhagiao")) {
    		flowerId = 2;
    	} else if (flower_name.contains("cuame")) {
    		flowerId = 3;
    	} else if (flower_name.contains("tinhyeu")) {
    		flowerId = 4;
    	}
    	
    	flowerDAO.updateFlower(name, price, link_image, description, flowerId, id);
    	map.addAttribute("editSuccess", "Chỉnh sửa loại hoa thành công");
    	return "redirect:/";
    }
    
    
    public String isLoginToAdminPage(HttpServletRequest request, String returnPage) {
    	
    	HttpSession session = request.getSession();
        String isLogin = (String) session.getAttribute("isLogin");
    	if(isLogin != null) {
    		if(isLogin.equals("True")) {
        		return returnPage;
        	} else {
        		return "redirect:/login";
        	}
    	} else {
    		return "redirect:/login";
    	}
    }
    
}
