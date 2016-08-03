package com.beisert.onlinecv.gwt.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class GenericContainer {
	
	I18Text title;
	I18Text value;
	
	List<GenericContainer> children = new ArrayList<GenericContainer>();
	
	

	public GenericContainer(I18Text title, I18Text value) {
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

	public I18Text getValue() {
		return value;
	}

	public void setValue(I18Text value) {
		this.value = value;
	}

	public List<GenericContainer> getChildren() {
		return children;
	}

	public void setChildren(List<GenericContainer> children) {
		this.children = children;
	}
	
}
