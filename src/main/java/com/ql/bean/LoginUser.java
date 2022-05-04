package com.ql.bean;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description �ǩ`���٩`����loginuser�Ʃ`�֥�ˌ�����g�奯�饹
 */
@Getter
@Setter
public class LoginUser {
	/*
	 * loginuser�Ʃ`�֥�column�ˌ�������Щ`�ץ�ѥƥ�
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
