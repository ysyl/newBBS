package bbs.shop.entity;

import java.io.Serializable;
import java.util.List;

public class CommodyClassification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String logoFileName;
	
	private List<SubClass> subClasses;

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

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public List<SubClass> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(List<SubClass> subClasses) {
		this.subClasses = subClasses;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//前台需要传递classification，转换的string需要包含subClasses
		return "{"
				+ "id:"
				+ this.id
				+ ", name:"
				+ "\""+this.name + "\""
				+ ", subClasses:"
				+ this.subClasses
				+ "}";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return ((Integer)this.id).hashCode() + this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj.hashCode() == this.hashCode();
	}


	
}
