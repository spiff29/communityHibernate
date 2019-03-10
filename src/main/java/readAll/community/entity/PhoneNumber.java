package readAll.community.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="phonenumber")
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private int id;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="namekey")
	private Name name;

	public PhoneNumber() {
	}

	public PhoneNumber(String phoneNumber, Name name) {
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  "Phone Number: " + phoneNumber;
	}
	
	
	

}
