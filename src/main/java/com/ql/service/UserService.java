package com.ql.service;

import java.util.ArrayList;
import java.util.Locale;

import com.ql.form.UserForm;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description ��`���`Id�ȥѥ���`�ɤ���å����^�ΙC�ܤ��x���륤�󥿥ե��`��
 */
public interface UserService {
	//UserForm�Υ�`���`Id�ȥѥ���`�ɤ���å����^����
	public ArrayList<String> getResult(UserForm userForm, Locale locale);
}
