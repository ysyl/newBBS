package bbs.shop.entity;

import java.io.Serializable;

public class Keyword implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String content;
	
	private String partOfSpeech;

	public Keyword() {
		super();
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Keyword(String content, String partOfSpeech) {
		super();
		this.content = content;
		this.partOfSpeech = partOfSpeech;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return content;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.content.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
