package com.ql.bean;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description ¥Ç©`¥¿¥Ù©`¥¹¤Îgender¥Æ©`¥Ö¥ë¤ËŒ¤¹¤ëŒgÌå¥¯¥é¥¹
 */
@Getter
@Setter
public class Gender {
	/*
	 * gender¥Æ©`¥Ö¥ëcolumn¤ËŒ¤¹¤ë¥á¥ó¥Ğ©`¥×¥í¥Ñ¥Æ¥£
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
