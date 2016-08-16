package com.beisert.onlinecv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@XmlType( propOrder={"title","value","children"})
public class GenericContainer {
	
	I18NText title;
	I18NText value;
	
	List<GenericContainer> children = new ArrayList<GenericContainer>();
	
	
	public GenericContainer(){}
	
	public GenericContainer(I18NText title, I18NText value) {
		super();
		this.title = title;
		this.value = value;
	}

	@ApiModelProperty
	public I18NText getTitle() {
		return title;
	}

	public void setTitle(I18NText title) {
		this.title = title;
	}

	@ApiModelProperty
	public I18NText getValue() {
		return value;
	}

	public void setValue(I18NText value) {
		this.value = value;
	}
	
	//Added this as hidden to swagger because it is recursive and caused problems
	@ApiModelProperty(hidden=true)
	public List<GenericContainer> getChildren() {
		return children;
	}

	public void setChildren(List<GenericContainer> children) {
		this.children = children;
	}
	
}
