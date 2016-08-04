package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class GenericContainer {
	
	I18Text title;
	Object value;
	
	List<GenericContainer> children = new ArrayList<GenericContainer>();
	
	

	public GenericContainer(I18Text title, Object value) {
		super();
		this.title = title;
		this.value = value;
	}

	public I18Text getTitle() {
		return title;
	}

	public void setTitle(I18Text title) {
		this.title = title;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public List<GenericContainer> getChildren() {
		return children;
	}

	public void setChildren(List<GenericContainer> children) {
		this.children = children;
	}
	
	
	
	

}
