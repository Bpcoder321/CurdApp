package com.nt.command;

public class Student {
	private Integer id;
	private String name;
	private String address;
	private String qlfy;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQlfy() {
		return qlfy;
	}

	public void setQlfy(String qlfy) {
		this.qlfy = qlfy;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", address=" + address + ", qlfy=" + qlfy + "]";
	}

}
