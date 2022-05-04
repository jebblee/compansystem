package com.ql.serviceTest;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import com.ql.CompanysystemApplicationTests;
import com.ql.form.UserForm;
import com.ql.service.UserService;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description UserServiceクラスの機能を検証する
 */
public class UserServiceTest extends CompanysystemApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messageSource;
	private Locale locale = Locale.getDefault();
	
	//ユーザーIDとパスワードが正しい
	@Test
	public void testGetResult1() throws Exception {
		UserForm loginForm = new UserForm();
		loginForm.setAccountId("111@elife.com");
		loginForm.setPassword("000001");
		ArrayList<String> errors = null;
		errors = userService.getResult(loginForm, locale);
		Assertions.assertEquals(0, errors.size());
	}
	
	//ユーザーIDが存在しない
	@Test
	public void testGetResult2() throws Exception {
		UserForm loginForm = new UserForm();
		//ユーザーIDが存在しない
		loginForm.setAccountId("111@aaa.com");
		//パスワードが正しい
		loginForm.setPassword("000001");
		ArrayList<String> errors = null;
		errors = userService.getResult(loginForm, locale);
		//期待の結果はエラーメッセージのキーが"login.message.accountId.error"
		Assertions.assertEquals(messageSource.getMessage("login.message.accountId.error", null, locale), 
				errors.get(0));
	}
	
	@Test
	public void testGetResult3() throws Exception {
		UserForm loginForm = new UserForm();
		//ユーザーIDが正しい
		loginForm.setAccountId("111@elife.com");
		//パスワードが正しくない
		loginForm.setPassword("000002");
		ArrayList<String> errors = null;
		
		errors = userService.getResult(loginForm,  locale);
		//期待の結果はエラーメッセージのキーが"login.message.password.error"
		Assertions.assertEquals(messageSource.getMessage("login.message.password.error", null, locale), 
				errors.get(0));
	}
}