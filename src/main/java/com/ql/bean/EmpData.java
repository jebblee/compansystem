package com.ql.bean;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description ¥Ç©`¥¿¥Ù©`¥¹¤Îempdata¥Æ©`¥Ö¥ë¤ËŒ¤¹¤ëŒgÌå¥¯¥é¥¹
 */
@Getter
@Setter
public class EmpData {
	/*
	 * empdata¥Æ©`¥Ö¥ëcolumn¤ËŒ¤¹¤ë¥á¥ó¥Ğ©`¥×¥í¥Ñ¥Æ¥£
	 */
	private String empCd;
	private String name;
	private Date birthday;
	private Nationality nationality;
	private Gender gender;
	
	public String getEmpCd() {
		return empCd;
	}
	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
