package br.com.reflector.domain;

import java.util.List;

public class User {
	private Integer id;
	private String name;
	private List<Integer> entitlements;

	public User(Integer id, String name, List<Integer> entitlements) {
		super();
		this.id = id;
		this.name = name;
		this.entitlements = entitlements;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Integer> getEntitlements() {
		return entitlements;
	}

}
