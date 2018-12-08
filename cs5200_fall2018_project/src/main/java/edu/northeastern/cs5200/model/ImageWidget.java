package edu.northeastern.cs5200.model;
import javax.persistence.*;

@Entity
@Table(name ="ImageWidget")
public class ImageWidget extends Widget {
	@Column(name = "source", nullable = false)
	private String source;
	
	public ImageWidget(int id, String name, int width, int height, String text, int order, String src, Page page){
		this(id, name, width, height, "", "", text, order, src,page);
	}
    
	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, 
    		String text, int order, String src, Page page){
        super(id, name, width, height, cssClass, cssStyle, text, order,page);
        super.Type = Type.image;
        this.source = source;
	}
	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}
