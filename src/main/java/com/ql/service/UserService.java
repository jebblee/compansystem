package com.ql.service;

import java.util.ArrayList;
import java.util.Locale;

import com.ql.form.UserForm;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description ¥æ©`¥¶©`Id¤È¥Ñ¥¹¥ï©`¥É¤ò¥í¥¸¥Ã¥¯—ÊÔ^¤Î™CÄÜ¤ò¶¨Áx¤¹¤ë¥¤¥ó¥¿¥Õ¥§©`¥¹
 */
public interface UserService {
	//UserForm¤Î¥æ©`¥¶©`Id¤È¥Ñ¥¹¥ï©`¥É¤ò¥í¥¸¥Ã¥¯—ÊÔ^¤¹¤ë
	public ArrayList<String> getResult(UserForm userForm, Locale locale);
}
