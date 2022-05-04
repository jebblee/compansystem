
package com.ql.bean;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description •«©`•ø•Ÿ©`•π§Œnationality•∆©`•÷•Î§Àåù§π§ÎågÃÂ•Ø•È•π
 */
@Getter
@Setter
public class Nationality {
	/*
	 * nationality•∆©`•÷•Îcolumn§Àåù§π§Î•·•Û•–©`•◊•Ì•—•∆•£
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
