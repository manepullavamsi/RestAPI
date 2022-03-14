package com.user.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModelProperty;

//one to many skills 
@Entity
@Table(name = "UserDetails")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -433014171839287916L;

	@ApiModelProperty(notes = "This is primary key and it is an auto generation")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	Integer userid;

	@ApiModelProperty(notes = "This is List of skills for current user")
	@OneToMany(cascade = CascadeType.ALL)
//	 @OneToMany(mappedBy = "user")
	@JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
	List<Skills> skills;

	@ApiModelProperty(example = "Venkat1998@gmail.com", notes = "This is username Give emailID it should be unique", allowEmptyValue = false)
	@Column(name = "userName")
	@Email
	@NotBlank
	private String userName;

	@ApiModelProperty(example = "9505935287", notes = "This is an mobile Number ensure it should be valid")
	@Column(name = "mobileNumber")
//	@NotBlank
//	@Size(min = 10,max = 11)
	private BigInteger mobileNumber;

	@ApiModelProperty(example = "Venkat", notes = "This feild is firstname of user")
	@Column(name = "firstName")
	@NotBlank
	private String firstName;

	@ApiModelProperty(example = "Srinvas", notes = "This feild is Lastname of user")
	@Column(name = "lastName")
	@NotBlank
	private String lastName;

	@ApiModelProperty(example = "Venkat@1374", notes = "This feild represt password create strong password minumum 8 characters", required = true)
	@Column(name = "Password")
	@NotBlank
	@Size(min = 8, max = 19)
	private String password;

	public User() {

	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
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

//	
	public User(Integer userid, List<Skills> skills, String userName, BigInteger mobileNumber, String firstName,
			String lastName, String password) {
		super();
		this.userid = userid;
		this.skills = skills;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

}
