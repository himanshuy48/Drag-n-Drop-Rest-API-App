package com.uibuilder.model;

public class ProjectBean {
	
	private Integer id;
	private String name;
	private Integer clientId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "projectBean [id=" + id + ", name=" + name + ", clientId=" + clientId + "]";
	}
	
}
