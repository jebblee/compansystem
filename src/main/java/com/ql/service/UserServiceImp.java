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
 * @description UserServiceを実装する
 */
@Service("userService")
public class UserServiceImp implements UserService{
	//UserMapper を注入する
	@Resource
	private UserMapper userMapper;
	//メッセージリソースを注入する
	@Autowired
	private MessageSource messageSource;
	
	//UserFormのユーザーIdとパスワードをロジック検証する
	@Override
	public ArrayList<String> getResult(UserForm userForm, Locale locale) {
		//Mapperインターフェースで定義したメソッドを呼び出しSQLを実行する
		LoginUser user = userMapper.find(userForm.getAccountId());
		//エラーメッセージの文字列リストを新規する
		ArrayList<String> errorlist = new ArrayList<String>();
		//取得データがヌルの場合
		if (user == null) { 
			//ユーザーIdが不正のエラーメッセージをエラーリストに追加
			errorlist.add(messageSource.getMessage("login.message.accountId.error", null, locale));
			//ログインユーザーがnullでは場合、取得のユーザーのパスワードと入力のパスワードが一致するかを判定する
		} else if(!user.getPassword().equals(userForm.getPassword())) {
			errorlist.add(messageSource.getMessage("login.message.password.error", null, locale));
		}
		//検証結果のエラーメッセージの文字列リストを戻り返す
		return errorlist;
	}
	
}
