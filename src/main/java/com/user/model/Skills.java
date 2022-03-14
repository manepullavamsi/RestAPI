package com.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user_skills")
public class Skills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7101091096464566040L;

	@Column(name = "ProgramingLanguage")
	@NonNull
	String ProgramingLanguage;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skills_id")
	Integer skills_id;

	@Column(name = "userName")
	@NonNull
	@Email
	private String userName;
	
	
//	 @ManyToOne(fetch = FetchType.LAZY) 
//	 @JoinColumn(name = "user_id") 
//	 User user;

	public String getProgramingLanguage() {
		return ProgramingLanguage;
	}

	public void setProgramingLanguage(String programingLanguage) {
		ProgramingLanguage = programingLanguage;
	}

	public Integer getSkills_id() {
		return skills_id;
	}

	public void setSkills_id(Integer skills_id) {
		this.skills_id = skills_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Skills(String programingLanguage, Integer skills_id, String userName) {
		super();
		ProgramingLanguage = programingLanguage;
		this.skills_id = skills_id;
		this.userName = userName;
	}

	public Skills() {
		super();
	}

}
