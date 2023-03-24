
package com.store.flower.entity;

public class Flower {
	private int id;
	private String name;
	private int price;
	private String link_image;
	private String description;
	private int flowerstyle_id;
	private String flowerstyle_name;
	
	public Flower() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLink_image() {
		return link_image;
	}

	public void setLink_image(String link_image) {
		this.link_image = link_image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlowerstyle_id() {
		return flowerstyle_id;
	}

	public void setFlowerstyle_id(int flowerstyle_id) {
		this.flowerstyle_id = flowerstyle_id;
	}

	public String getFlowerstyle_name() {
		return flowerstyle_name;
	}

	public void setFlowerstyle_name(String flowerstyle_name) {
		this.flowerstyle_name = flowerstyle_name;
	}

	public Flower(int id, String name, int price, String link_image, String description, int flowerstyle_id,
			String flowerstyle_name) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.link_image = link_image;
		this.description = description;
		this.flowerstyle_id = flowerstyle_id;
		this.flowerstyle_name = flowerstyle_name;
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", price=" + price + ", link_image=" + link_image
				+ ", description=" + description + ", flowerstyle_id=" + flowerstyle_id + ", flowerstyle_name="
				+ flowerstyle_name + "]";
	}
	
	
}
