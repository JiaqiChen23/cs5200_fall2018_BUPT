package edu.northeastern.cs5200.model;
import javax.persistence.*;

@Entity
@Table(name ="HTML")
public class HtmlWidget extends Widget {
	public HtmlWidget(int id, String name, int width, int height, String text, int order, String html,Page page){
		this(id, name, width, height, "", "", text, order, html, page);
	}
    
	public HtmlWidget(int id, String name, int width, int height, String cssClass, 
    		String cssStyle, String text, int order, String html, Page page){
        super(id, name, width, height, cssClass, cssStyle, text, order,page);
        super.Type = Type.html;
        this.html = html;
    }

	@Column(name = "html", nullable = false)
	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
