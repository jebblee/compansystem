
package com.ql.bean;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description �ǩ`���٩`����nationality�Ʃ`�֥�ˌ�����g�奯�饹
 */
@Getter
@Setter
public class Nationality {
	/*
	 * nationality�Ʃ`�֥�column�ˌ�������Щ`�ץ�ѥƥ�
	 */
	private String nationalityCd;
	private String nationalityName;
	
	public String getNationalityCd() {
		return nationalityCd;
	}
	public void setNationalityCd(String nationalityCd) {
		this.nationalityCd = nationalityCd;
	}
	public String getNationalityName() {
		return nationalityName;
	}
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	
	
}
