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
 * @description IDとpasswordを入力して、一覧画面へ遷移
 */
@Controller 
@ComponentScan({ "service" })
public class LoginController {
	@Resource// サービスクラスのインターフェースに対する依存性の注入
	private UserServiceImp userServiceImp;
	
	// URL「http://localhost:8080/login」へgetメソッドでリクエスト時に実行されるHandlerメソッド
	@GetMapping("/login")
	public String login(@ModelAttribute("form")UserForm userForm,
			Model model) {
		//Login画面へ遷移
		return ("/login");
	}
	
	//Login検証
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String auth(@ModelAttribute("form") @Valid UserForm userForm,BindingResult result,
			Model model, Locale locale) {
		String url = null;
		//Loginフォームの検証結果にはエラーがある場合
		if (result.hasErrors()) {
			//Loginフォームの検証結果から全てのエラーを取得
			List<ObjectError> errorList = result.getAllErrors();
			//System.out.println(errorList);
			//エラーメッセージのリストをModelに入れる
			model.addAttribute("errorList", errorList);
			//Login画面へ遷移
			url = "/login";
			return url;
		}
		//Loginフォームの検証結果にはエラーがない場合、userFormより社員情報を取得
		List<String> errorList = userServiceImp.getResult(userForm, locale);
		//System.out.println(errorList);
		if (!(errorList.size() == 0)) {
			//エラーメッセージをModelに入れる
			model.addAttribute("errorList", errorList.get(0));
			//Login画面へ遷移
			url = "login";
			return url;
		} else {
			//社員情報一覧画面へ遷移
			url = "redirect:/empList";
			return url;
		}	
	}	
		
}
