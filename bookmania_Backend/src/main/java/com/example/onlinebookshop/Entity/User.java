package com.example.onlinebookshop.Entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="users")
public class User extends BaseEntity {

	@NotBlank
	@Email
	@Column(nullable=false,unique=true,length=40)
	private String email;
	
	@NotBlank
	@Column(nullable=false)
	@Length(min = 3, max = 15, message = "Invalid length of FirstName")
	private String firstName;
	
	@NotBlank
	@Column(nullable=false)
	@Length(min = 3, max = 15, message = "Invalid length of LastName")
	private String lastName;
	
	//@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password")
	@Column(nullable=false,length=20)
	private String password;
	
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="address_id")
	private Address address;
	
	@NotNull
	@Column(nullable=false,length=15,unique=true)
	private String contactNo;
	
	@Enumerated(EnumType.STRING)
	@Column(length=15)
	private Role role;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	public User() {
		super();
	}



	public User(@NotBlank @Email String email,
			@NotBlank @Length(min = 3, max = 15, message = "Invalid length of FirstName") String firstName,
			@NotBlank @Length(min = 3, max = 15, message = "Invalid length of LastName") String lastName,
			//@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password") 
			String password,
		 @NotNull String contactNo, Role role) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactNo = contactNo;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" +getId()+" email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", contactNo=" + contactNo + ", role=" + role + "]";
	}
	
    

	
}
	
	
	
	
	

