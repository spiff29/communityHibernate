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
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@Column(name = "roadway")
	private String roadway;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="namekey")
	private Name name;

	public Address() {
	}

	public Address(String roadway, String state, String zipCode, Name name) {
		this.roadway = roadway;
		this.state = state;
		this.zipCode = zipCode;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoadway() {
		return roadway;
	}

	public void setRoadway(String roadway) {
		this.roadway = roadway;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "Address: " + roadway + ", " + state + ", " + zipCode + ", ";
	}
	
	
	

}
