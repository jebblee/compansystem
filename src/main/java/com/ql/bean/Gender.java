package com.ql.bean;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description �ǩ`���٩`����gender�Ʃ`�֥�ˌ�����g�奯�饹
 */
@Getter
@Setter
public class Gender {
	/*
	 * gender�Ʃ`�֥�column�ˌ�������Щ`�ץ�ѥƥ�
	 */
	private String genderName;
	private String genderCd;
	
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}
	
	
}
