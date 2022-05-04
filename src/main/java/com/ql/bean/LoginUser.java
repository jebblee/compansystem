package com.ql.bean;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description •«©`•ø•Ÿ©`•π§Œloginuser•∆©`•÷•Î§Àåù§π§ÎågÃÂ•Ø•È•π
 */
@Getter
@Setter
public class LoginUser {
	/*
	 * loginuser•∆©`•÷•Îcolumn§Àåù§π§Î•·•Û•–©`•◊•Ì•—•∆•£
	 */
	private String accountId;
	private String password;
	
	
	public LoginUser() {
		super();
	}


	public LoginUser(String accountId, String password) {
		super();
		this.accountId = accountId;
		this.password = password;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
