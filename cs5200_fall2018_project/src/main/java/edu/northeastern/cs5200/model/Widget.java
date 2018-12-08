package edu.northeastern.cs5200.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Widget {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int width;
	private int height;
	protected Type Type;
	private String cssclass;
	private String cssstyle;
	private String text;
	private int ordernum;
	@ManyToOne()
	@JsonIgnore
	private Page page;
    public enum Type {youtube, image, heading, html}

	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		if(!page.getContainWidget().contains(this))
			page.getContainWidget().add(this);
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssclass() {
		return cssclass;
	}
	public void setCssclass(String cssclass) {
		this.cssclass = cssclass;
	}
	public String getCssstyle() {
		return cssstyle;
	}
	public void setCssstyle(String cssstyle) {
		this.cssstyle = cssstyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int order) {
		this.ordernum = order;
	}
	
	public Type getDtype() {
		return Type;
	}
	public void setDtype(Type dtype) {
		Type = dtype;
	}
	public Widget(int id, String name, int width, int height, String cssclass, String cssstyle,
			String text, int ordernum, Page page)
	{
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssclass = cssclass;
		this.cssstyle = cssstyle;
		this.text = text;
		this.ordernum = ordernum;
		this.page = page;
	}
		
		 
}
