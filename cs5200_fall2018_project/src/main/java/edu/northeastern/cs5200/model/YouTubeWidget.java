package edu.northeastern.cs5200.model;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name ="YouTubeWidget")
public class YouTubeWidget extends Widget{
	public YouTubeWidget(int id, String name, int width, int height, int order, String url, 
			boolean sharable, boolean expendable,Team page) {
		this(id, name, width, height, "", "", "", order, url, sharable, expendable, page);
	}
    
	public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, 
    		String text, int order, String url, boolean sharable, boolean expendable, Team page){
        super(id, name, width, height, cssClass, cssStyle, text, order, page);
        super.Type = Type.youtube;
        this.url = url;
        this.sharable = sharable;
        this.expandable = expendable;
    }
	private String url;
	private boolean sharable;
	private boolean expandable;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isSharable() {
		return sharable;
	}
	public void setSharable(boolean sharable) {
		this.sharable = sharable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	
}
