package com.gary.algorithms;

public class User {
	private final String firstName;
	private final String laststName;
	private int age;
	private String phone;
	private String address;
	
	private User(UserBuilder ub) {
		this.firstName = ub.firstName;
		this.laststName = ub.laststName;
		this.age = ub.age;
		this.phone = ub.phone;
		this.address = ub.address;
	}
	
	public static class UserBuilder {
		private final String firstName;
		private final String laststName;
		private int age = 0;
		private String phone = "";
		private String address;
		
		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		public int getAge() {
			return age;
		}
		
		public UserBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		public String getPhone() {
			return phone;
		}
		
		public UserBuilder setAddress(String address) {
			this.address = address;
			return this;
		}
		public String getAddress() {
			return address;
		}
		
		public UserBuilder(String firsName, String lastName) {
			this.firstName = firsName;
			this.laststName = lastName;
		}
		
		public User build() {
			return new User(this);
		}
	}
}
