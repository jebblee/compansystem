package com.ql.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description フロントエンド検証にはformテーブルに対する実体クラス
 */
@Getter
@Setter
public class EmpForm {
	/*
	 * formテーブルの変数に対するメンバープロパティ
	 */
	@NotEmpty(message = "{empCode.notEmpty}")
	private String empCd;
	
	@NotEmpty(message = "{empName.notEmpty}")
	@Pattern(regexp = "^[一-龥 ア-ン あ-ん a-z A-Z]*$", message = "{empName.error}")
	private String name;

	@NotEmpty(message = "{empBirthday.notEmpty}")
	private String birthday;
	
	@NotEmpty(message = "{nationality.notEmpty}")
	private String nationalityCd;
	
	@NotEmpty(message = "{empGender.notEmpty}")
	private String genderCd;

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNationalityCd() {
		return nationalityCd;
	}

	public void setNationalityCd(String nationalityCd) {
		this.nationalityCd = nationalityCd;
	}

	public String getGenderCd() {
		return genderCd;
	}

	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}
	
	
}
