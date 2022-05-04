package com.ql.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ql.form.UserForm;
import com.ql.service.UserServiceImp;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description ID��password���������ơ�һ�E������w��
 */
@Controller 
@ComponentScan({ "service" })
public class LoginController {
	@Resource// ���`�ӥ����饹�Υ��󥿩`�ե��`���ˌ����������Ԥ�ע��
	private UserServiceImp userServiceImp;
	
	// URL��http://localhost:8080/login����get�᥽�åɤǥꥯ�����ȕr�ˌg�Ф����Handler�᥽�å�
	@GetMapping("/login")
	public String login(@ModelAttribute("form")UserForm userForm,
			Model model) {
		//Login������w��
		return ("/login");
	}
	
	//Login���^
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String auth(@ModelAttribute("form") @Valid UserForm userForm,BindingResult result,
			Model model, Locale locale) {
		String url = null;
		//Login�ե��`��Η��^�Y���ˤϥ���`���������
		if (result.hasErrors()) {
			//Login�ե��`��Η��^�Y������ȫ�ƤΥ���`��ȡ��
			List<ObjectError> errorList = result.getAllErrors();
			//System.out.println(errorList);
			//����`��å��`���Υꥹ�Ȥ�Model������
			model.addAttribute("errorList", errorList);
			//Login������w��
			url = "/login";
			return url;
		}
		//Login�ե��`��Η��^�Y���ˤϥ���`���ʤ����ϡ�userForm�����T����ȡ��
		List<String> errorList = userServiceImp.getResult(userForm, locale);
		//System.out.println(errorList);
		if (!(errorList.size() == 0)) {
			//����`��å��`����Model������
			model.addAttribute("errorList", errorList.get(0));
			//Login������w��
			url = "login";
			return url;
		} else {
			//��T���һ�E������w��
			url = "redirect:/empList";
			return url;
		}	
	}	
		
}
