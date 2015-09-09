package jvm;

import java.util.ArrayList;
import java.util.List;

public class TraceStudents {

	static List<WebPage> webpages = new ArrayList<WebPage>();
	public static void createWebPages(){
		for(int i = 0; i < 100; i++){
			WebPage wp = new WebPage();
			wp.setUrl("http://www." + Integer.toString(i) + ".com");
			wp.setContent(Integer.toString(i));
			webpages.add(wp);
		}
	}
	
	public static void main(String[] args){
		createWebPages();
		Student st3 = new Student(3, "billy");
		Student st5 = new Student(5, "alice");
		Student st7 = new Student(7, "taotao");
		for(int i = 0; i < webpages.size(); i++){
			if(i % st3.getId() == 0) st3.vist(webpages.get(i));
			
			if(i % st5.getId() == 0) st5.vist(webpages.get(i));
			
			if(i % st7.getId() == 0) st7.vist(webpages.get(i));
		}
		webpages.clear();
		System.gc();
	}
}
