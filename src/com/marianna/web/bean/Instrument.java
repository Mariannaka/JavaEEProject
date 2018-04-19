package com.marianna.web.bean;

/** 
 * @author marianna
 * A bean class to create new objects of "instrument" type
 * which represent the instruments used in the orchestra
 * OR the new instruments that are coming to be added with new players. 
 *
 */
public class Instrument {

	private int id;
	private String name;
	private String size ;
	private String type ;
	
	
	public Instrument(int id, String name, String size, String type) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.type = type;
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


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	//toString() method for debugging/logging issues
	@Override
	public String toString() {
		return "Instrument [id=" + id + ", name=" + name + ", size=" + size + ", type=" + type + "]";
	}
	
}


