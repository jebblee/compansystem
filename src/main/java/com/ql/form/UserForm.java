package com.ql.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 入力検証にはフロントエンドのformテーブルに対する実体クラス
 */
@Getter
@Setter
public class UserForm {
	/*
	 * formテーブルの変数に対するメンバープロパティ
	 */
	@NotEmpty(message="{login.error.accountId.notEmpty}")//用户id非空验证
	@Email(message="{login.error.accountId.isEmail}") //Email格式验证
	private String accountId;
	
	@NotEmpty(message="{login.error.password.notEmpty}")//用户密码非空验证
	@Size(min=6,max=6,message="{login.error.password.length}")//密码格式验证
	private String password;

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
