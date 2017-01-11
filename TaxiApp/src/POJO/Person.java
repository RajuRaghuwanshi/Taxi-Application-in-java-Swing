package POJO;

public class Person {
	
	private String first_name;
	private String middle_name;
	private String last_name;
	private String address;
	private String email_ID;
	
	
	
	public Person() {
		super();
	}
	public Person(String first_name, String middle_name, String last_name, String address, String email_ID) {
		super();
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.address = address;
		this.email_ID = email_ID;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail_ID() {
		return email_ID;
	}
	public void setEmail_ID(String email_ID) {
		this.email_ID = email_ID;
	}
	
	@Override
	public String toString() {
		return "Person [first_name=" + first_name + ", middle_name=" + middle_name + ", last_name=" + last_name
				+ ", address=" + address + ", email_ID=" + email_ID + "]";
	}
	
	
}
