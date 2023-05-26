package com.example.onlinebookshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="address")

public class Address extends BaseEntity{
	
	
	
	@Column(length=50,name="plot_number")
	private String plotNumber;
	@Column(length=50)
	private String landmark;
	@Column(length=20,nullable=false)
	@NotBlank
	private String city;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private String pincode;
	
	public Address(String plotNumber, String landmark, @NotBlank String city, String state, String pincode) {
		super();
		this.plotNumber = plotNumber;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	
	public String getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [plotNumber=" + plotNumber + ", landmark=" + landmark + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	

}
