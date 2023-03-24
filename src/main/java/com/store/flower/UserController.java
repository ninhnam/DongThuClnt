package com.store.flower;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.flower.entity.User;


@Controller
public class UserController {
	
	@Autowired
    private UserDAO userDAO;
	
	@RequestMapping("/login")
    public String login(ModelMap map) {
		
    	return "login";
    }
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
    public String loginPost(ModelMap map, HttpServletRequest request,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password) {
		User userLogin = userDAO.getUserFromDatabaseByUsername(username);

		if (userLogin == null) {
			map.addAttribute("loginFailed", "Đăng nhập thất bại, username hoặc password không chính xác!");
			return "login";
		}
		if (!userLogin.getPassword().equals(password)) {
			map.addAttribute("loginFailed", "Đăng nhập thất bại, username hoặc password không chính xác!");
			return "login";
		}
		HttpSession session = request.getSession();
	    session.setAttribute("isLogin", "True");
	    session.setAttribute("usernameFlowerStore", username);
		
		return "redirect:/";
    }

	@RequestMapping("/signin")
    public String signin(ModelMap map) {
		
    	return "signin";
    }

	@RequestMapping(value = "/signin", method=RequestMethod.POST)
    public String signinPost(ModelMap map, HttpServletRequest request,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password,
    		@RequestParam("password_confirm") String password_confirm) {
		
		User userSignin = userDAO.getUserFromDatabaseByUsername(username);

		if(userSignin != null) {
			map.addAttribute("signinStatus", "Đăng kí thất bại, tên đăng nhập đã được sử dụng!");
			return "signin";
		}
		
		if(userSignin == null) {
			if(password.equals(password_confirm)) {
				userDAO.saveUserManager(username, password, "user");
				map.addAttribute("signinStatus", "Đăng kí thành công, đăng nhập để truy cập trang chủ!");
				return "signin";
			}
			if(!password.equals(password_confirm)) {
				map.addAttribute("signinStatus", "Đăng kí thất bại, xác nhận mật khẩu không chính xác!");
				return "signin";
			}
		}
		return "signin";
    }
	
	@RequestMapping("/logout")
    public String logout(ModelMap map, HttpServletRequest request) {
		HttpSession session = request.getSession();
        String isLogin = (String) session.getAttribute("isLogin");
        if(isLogin != null) {
        	session.invalidate();
        }
        return "redirect:/login";
    }

	@RequestMapping("/flower_user")
    public String flower_user(ModelMap map, HttpServletRequest request,
    		@RequestParam(value = "deleteUserSuccess", required = false) String deleteUserSuccess
    		) {
		
		List<User> listUser = userDAO.getAllUser();
		map.addAttribute("listUser", listUser);
		
		HttpSession session = request.getSession();
		String usernameFlowerStore = (String) session.getAttribute("usernameFlowerStore");
        map.addAttribute("usernameFoodStore", usernameFlowerStore);
        
        if(deleteUserSuccess != null ) {
        	map.addAttribute("deleteUserSuccess", deleteUserSuccess);
        }
		
        return isLoginToAdminPage(request, "user_flower");
    }
	
	@RequestMapping("/user_flower_edit")
    public String food_user_edit(ModelMap map, HttpServletRequest request,
    		@RequestParam("id") String id) {
		
		User user = userDAO.getUser(id);
		
		map.addAttribute("userEdit", user);
		
        return "user_flower_edit";
    }
	
	@RequestMapping("/user_flower_delete")
    public String food_user_delete(ModelMap map, HttpServletRequest request,
    		@RequestParam("id") String id) {
		
		User user = userDAO.getUser(id);
		
		map.addAttribute("userDel", user);
		
        return "user_flower_delete";
    }
	
	
	@RequestMapping(value = "/user_flower_edit", method=RequestMethod.POST)
    public String food_user_edit_post(ModelMap map, HttpServletRequest request,
    		@RequestParam("id") String id,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password) {
    	
		System.out.println(username + " " + password + " " + id);
		
    	userDAO.updateUser(username, password);
    	map.addAttribute("editUserSuccess", "Chỉnh sửa User thành công");
    	
    	User user = userDAO.getUser(id);
		map.addAttribute("userEdit", user);
    	
    	return isLoginToAdminPage(request, "user_flower_edit");
    }
	
	
	@RequestMapping("/flower_user_delete_confirm")
    public String food_user_delete_confirm(ModelMap map, HttpServletRequest request, 
    		@RequestParam("id") String id) {
    	
    	userDAO.deleteUser(id);
    	map.addAttribute("deleteUserSuccess", "Xóa User thành công");
    	
    	return isLoginToAdminPage(request, "redirect:/flower_user");
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
