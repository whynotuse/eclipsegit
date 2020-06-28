package com.chanpter3.preweb;
/**
 * 
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月19日 下午6:30:05
 */
public class Person {
	
	private String personid;
	private String name;
	private String address;
	private String tel;
	private String fax;
	private String email;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", tel=" + tel + ", fax=" + fax + ", email=" + email
				+ ", personid=" + personid + "]";
	}
	
}
