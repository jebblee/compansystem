package com.ql.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.ObjectError;

import com.ql.CompanysystemApplicationTests;
import com.ql.controller.LoginController;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description LoginControllerクラスの機能を検証する
 */
public class LoginControllerTest extends CompanysystemApplicationTests {
	//モックDI
	@Autowired
	@InjectMocks
	private LoginController loginController;	
	@Autowired
	private MessageSource messageSource;
	private Locale locale = Locale.getDefault();
	MockMvc mockMvc;
	//モックの設定
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}
	
	//ユーザーIDとパスワードが正しい、ログイン成功
	@Test
	public void testLoginSuccess() throws Exception {
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@elife.com")
				.param("password", "000001");
		ResultActions results = mockMvc.perform(getRequest);
		results.andDo(print());
		//期待の結果はsuccess画面に遷移
		results.andExpect(view().name("redirect:/empList"));
		//期待の結果はエラーなし
		results.andExpect(model().errorCount(0));
		}
			
	//ユーザーIDが空文字
	@Test
	public void testAccountIdIsEmpty() throws Exception {
		//postクエスト"/auth"をモックでビルド
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "")
				.param("password", "000001");
		//postクエスト"/auth"をモックで実行
		ResultActions results = mockMvc.perform(getRequest);
		//テスト実行時のログ出力などを有効化
		results.andDo(print());
		//	期待の結果はログイン画面に遷移
		results.andExpect(view().name("/login"));
		//期待の結果は一つエラー
		results.andExpect(model().errorCount(1));
		//エラーリストを取得
		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");
		//エラーメッセージを取得
		String message = errorList.get(0).getDefaultMessage();
		//期待の結果はエラーメッセージのキーがlogin.error.accountId.notEmpty
		assertTrue(message.contains("login.error.accountId.notEmpty"));
	}

	//ユーザーIDがメールアドレスではない
	@Test
	public void testAccountIdNotMail() throws Exception {
		//postクエスト"/auth"をモックでビルド
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111")
				.param("password", "000001");
		//postクエスト"/auth"をモックで実行
		ResultActions results = mockMvc.perform(getRequest);
		//テスト実行時のログ出力などを有効化
		results.andDo(print());
        //	期待の結果はログイン画面に遷移
		results.andExpect(view().name("/login"));
		//期待の結果は一つエラー
		results.andExpect(model().errorCount(1));
		//エラーリストを取得
		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");
		//エラーメッセージを取得
		String message = errorList.get(0).getDefaultMessage();
		//期待の結果はエラーメッセージのキーがlogin.error.accountId.isEmail
		assertTrue(message.contains("login.error.accountId.isEmail"));
	}	


	//パスワードが空文字
	@Test
	public void testPasswordIsEmpty() throws Exception {
		//postクエスト"/auth"をモックでビルド
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@elife.com")
				.param("password", "");
		//getRequest.locale(locale);
		//postクエスト"/auth"をモックで実行
		ResultActions results = mockMvc.perform(getRequest);
		//テスト実行時のログ出力などを有効化
		results.andDo(print()); 
        //期待の結果はログイン画面に遷移
		results.andExpect(view().name("/login"));
		//期待の結果は二つエラー
		results.andExpect(model().errorCount(2));
		//エラーリストを取得
		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");		
		List<String> messages = new ArrayList<>();
		//エラーメッセージを取得
		for(ObjectError error:errorList) {
			String message = error.getDefaultMessage();
			messages.add(message);
		}
		//エラーメッセージには"{login.error.password.notEmpty}"を含む
		assertTrue(messages.contains("{login.error.password.notEmpty}"));
	}	

	//パスワードが6桁半角英数字ではない
	@Test
	public void testPasswordLength() throws Exception {
		//postクエスト"/auth"をモックでビルド
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@elife.com")
				.param("password", "0000000");
		//postクエスト"/auth"をモックで実行
		ResultActions results = mockMvc.perform(getRequest);
		//テスト実行時のログ出力などを有効化
		results.andDo(print());
	       //期待の結果はログイン画面に遷移
		results.andExpect(view().name("/login"));
		//期待の結果は二つエラー
		results.andExpect(model().errorCount(1));
		//エラーリストを取得
		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");
		String message = errorList.get(0).getDefaultMessage();
		//エラーメッセージには"login.error.password.length"を含む
		assertTrue(message.contains("login.error.password.length"));
	}
	
	//ユーザーIDが存在しない
	@Test
	public void testLoginAccountError() throws Exception {
		//postクエスト"/auth"をモックでビルド
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@aaaa.com")
				.param("password", "000001");
		//postクエスト"/auth"をモックで実行
		ResultActions results = mockMvc.perform(getRequest);
		//テスト実行時のログ出力などを有効化
		results.andDo(print());
	    //期待の結果はログイン画面に遷移
		results.andExpect(view().name("login"));
		//フォーム検証エラーなし
		results.andExpect(model().errorCount(0));
		//ロジックのエラーメッセージを取得
		String message = (String) results.andReturn().getModelAndView().getModel().get("message");
		//エラーメッセージには"login.message.accountId.error"を含む
		assertEquals(messageSource.getMessage("login.message.accountId.error", null, locale), message);
	}	


	//パスワードが正しくない
	@Test
	public void testLoginPasswordError() throws Exception {
		//postクエスト"/auth"をモックでビルド
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@elife.com")
				.param("password", "000002");

		ResultActions results = mockMvc.perform(getRequest);
		//テスト実行時のログ出力などを有効化
		results.andDo(print());
	    //期待の結果はログイン画面に遷移
		results.andExpect(view().name("login"));
		//フォーム検証エラーなし
		results.andExpect(model().errorCount(0));
		//ロジックのエラーメッセージを取得
		String message = (String) results.andReturn().getModelAndView().getModel().get("message");
		//エラーメッセージには"login.message.password.error"を含む
		assertEquals(messageSource.getMessage("login.message.password.error", null, locale), message);
	}	
}
