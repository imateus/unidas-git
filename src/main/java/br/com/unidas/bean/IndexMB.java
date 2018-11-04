package br.com.unidas.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexMB {
    private List<String> images;

	@PostConstruct
	public void init() {
		images = new ArrayList<String>();

		images.add("https://i.imgur.com/RkeSgco.jpg");
		images.add("https://i.imgur.com/ifu4FC0.png");
	}
 
    public List<String> getImages() {
        return images;
    }
}
