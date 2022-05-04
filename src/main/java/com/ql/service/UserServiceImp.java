package com.ql.service;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.ql.bean.LoginUser;
import com.ql.form.UserForm;
import com.ql.mapper.UserMapper;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description UserService��gװ����
 */
@Service("userService")
public class UserServiceImp implements UserService{
	//UserMapper ��ע�뤹��
	@Resource
	private UserMapper userMapper;
	//��å��`���꥽�`����ע�뤹��
	@Autowired
	private MessageSource messageSource;
	
	//UserForm�Υ�`���`Id�ȥѥ���`�ɤ���å����^����
	@Override
	public ArrayList<String> getResult(UserForm userForm, Locale locale) {
		//Mapper���󥿩`�ե��`���Ƕ��x�����᥽�åɤ���ӳ���SQL��g�Ф���
		LoginUser user = userMapper.find(userForm.getAccountId());
		//����`��å��`���������Хꥹ�Ȥ���Ҏ����
		ArrayList<String> errorlist = new ArrayList<String>();
		//ȡ�åǩ`�����̥�Έ���
		if (user == null) { 
			//��`���`Id�������Υ���`��å��`���򥨥�`�ꥹ�Ȥ�׷��
			errorlist.add(messageSource.getMessage("login.message.accountId.error", null, locale));
			//�������`���`��null�Ǥψ��ϡ�ȡ�äΥ�`���`�Υѥ���`�ɤ������Υѥ���`�ɤ�һ�¤��뤫���ж�����
		} else if(!user.getPassword().equals(userForm.getPassword())) {
			errorlist.add(messageSource.getMessage("login.message.password.error", null, locale));
		}
		//���^�Y���Υ���`��å��`���������Хꥹ�Ȥ���귵��
		return errorlist;
	}
	
}
