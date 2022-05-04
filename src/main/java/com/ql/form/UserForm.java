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
 * @description �������^�ˤϥե��ȥ���ɤ�form�Ʃ`�֥�ˌ�����g�奯�饹
 */
@Getter
@Setter
public class UserForm {
	/*
	 * form�Ʃ`�֥�Ή����ˌ�������Щ`�ץ�ѥƥ�
	 */
	@NotEmpty(message="{login.error.accountId.notEmpty}")//�û�id�ǿ���֤
	@Email(message="{login.error.accountId.isEmail}") //Email��ʽ��֤
	private String accountId;
	
	@NotEmpty(message="{login.error.password.notEmpty}")//�û�����ǿ���֤
	@Size(min=6,max=6,message="{login.error.password.length}")//�����ʽ��֤
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
