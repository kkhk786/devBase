package test.member;

import java.sql.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private String zipcode;
	private String address1;
	private String address2;
	private String phone;
	private String email;
	private Date inputdate;
	public Member() {
		super();
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name
				+ ", zipcode=" + zipcode + ", address1=" + address1
				+ ", address2=" + address2 + ", phone=" + phone + ", email="
				+ email + ", inputdate=" + inputdate + "]";
	}
}
