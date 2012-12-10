package com.shomun.fish.core.service;

public enum UserModule {

	GROUP("group"),ROLE("role"),USER("user");
	
	private String moduleType;
	UserModule(String moduleType){
		this.moduleType = moduleType;
	}
	public String getModuleType() {
		return moduleType;
	}
	
	public String toString(){
		return this.moduleType;
	}
	
};
