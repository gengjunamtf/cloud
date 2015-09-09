package jvm;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int id;
	private String name;
	private List<WebPage> history = new ArrayList<WebPage>();
	
	public Student(int id, String name){
		super();
		this.id = id;
		this.name = name;
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
	public void vist(WebPage webPage){
		history.add(webPage);
	}
}
