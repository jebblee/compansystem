package com.ql.controller;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ql.bean.EmpData;
import com.ql.bean.Gender;
import com.ql.bean.Nationality;
import com.ql.form.EmpForm;
import com.ql.service.EmpService;
import com.ql.service.GenderService;
import com.ql.service.NationalityService;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 社員番号で社員情報検索、社員情報の初期値を取得、社員情報の初期値をSessionに追加、新規登録画面へ遷移
 * ,社員情報登録を検証、社員情報フォームの検証結果から全てのエラーを取得、エラーメッセージのリストをModelに入れる
 * ,社員情報登録画面へ遷移；この社員番号が既に登録した場合、エラーメッセージのリストをModelに入れる、社員情報登録画面へ遷移
 */
@Controller
@ComponentScan({"service"})
public class AddController {
	//NationalityServiceを注入する
	@Autowired
	private NationalityService nationalityService;
	//GenderServiceを注入する
	@Autowired
	private GenderService genderService;
	//EmpServiceを注入する
	@Autowired
	private EmpService empService;	
	//MessageSourceを注入する
	@Autowired
	private MessageSource messageSource;
	//HttpSessionを注入する
	@Autowired
	private HttpSession session; 

	// 新規登録画面へ遷移
	@GetMapping(value = "/toAddEmp")
	public String toAddEmp(@ModelAttribute("form") EmpForm empForm, Model model) {
		// 国籍一覧を取得
		List<Nationality> nationalityList = nationalityService.getNationalityList();
		// 国籍一覧をSessionに追加
		session.setAttribute("nationalityList", nationalityList);
		// 性別一覧を取得
		List<Gender> genderList = genderService.getGenderList();
		// 性別一覧をSessionに追加
		session.setAttribute("genderList", genderList);
		// 新規登録画面へ遷移
		return ("addEmp");
	}

	// 社員情報登録
	@PostMapping( "/addEmp")
	public String addEmp(@ModelAttribute("form") @Valid EmpForm empForm, BindingResult result, 
				Model model, Locale locale) {		
		//社員情報登録フォームの検証結果にはエラーがある場合
		if (result.hasErrors()) {
			//社員情報フォームの検証結果から全てのエラーを取得
			List<ObjectError> errorList = result.getAllErrors();
			// エラーメッセージのリストをModelに入れる
			model.addAttribute("errorList", errorList);
			return ("addEmp");			
		} else {
            //社員情報登録フォームの検証結果にはエラーがない場合、社員番号より社員情報を取得
			EmpData empData = empService.getEmpData(empForm.getEmpCd());
			//この社員番号が既に登録した場合
			if (empData != null) {
				//エラーメッセージをModelに入れる
				model.addAttribute("message", messageSource.getMessage("addEmp.error", null, locale));
				// 社員情報登録画面へ遷移
				return ("addEmp");
			} else {
				// 社員情報をデータベースに登録
				empService.insertEmp(empForm);
				// 社員情報一覧画面へ遷移
				return ("redirect:/empList");
			}
		}
	}
}
