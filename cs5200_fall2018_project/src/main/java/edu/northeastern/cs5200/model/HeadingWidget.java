package edu.northeastern.cs5200.model;

import javax.persistence.*;

@Entity
@Table(name ="heading")
public class HeadingWidget extends Widget{
	public HeadingWidget(int id, String name, int width, int height, String cssclass, String cssstyle, String text,
			int ordernum, Page page, int size) {
		super(id, name, width, height, cssclass, cssstyle, text, ordernum, page);
		// TODO Auto-generated constructor stub
		this.Type = Type.heading;
		this.size = size;
	}

	@Column(name = "size", nullable = false)
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
