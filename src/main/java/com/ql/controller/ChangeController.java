package com.ql.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
 * @description 変更ボタンを押すと、社員基本情報変更画面へ遷移する;確定ボタンを押すと、社員情報を更新し、一覧画面へ遷移する
 */
@Controller
public class ChangeController {
	//NationalityServiceを注入する
	@Autowired
	private NationalityService nationalityService;
	//GenderServiceを注入する
	@Autowired
	private GenderService genderService;
	//EmpServiceを注入する
	@Autowired
	private EmpService empService;
	//HttpSessionを注入する
	@Autowired
	HttpSession session;
	
	//社員番号で社員情報検索、社員情報変更画面へ遷移する
	@PostMapping("/toChangeEmp")
	public String toChangeEmp(@RequestParam(value = "empCd") String empCd, @ModelAttribute("form") EmpForm empForm) {
		// 社員番号で社員情報を取得
		EmpData empData = empService.getEmpData(empCd);
		// 社員情報empDataより、empFormを設定する
		empForm.setEmpCd(empData.getEmpCd());
		empForm.setName(empData.getName());
		empForm.setBirthday(empData.getBirthday().toString());
		empForm.setNationalityCd(empData.getNationality().getNationalityCd());
		empForm.setGenderCd(empData.getGender().getGenderCd());
		// 国籍一覧を取得する
		List<Nationality> nationalityList = nationalityService.getNationalityList();
		// 国籍一覧をsessionに入れる
		session.setAttribute("nationalityList", nationalityList);
		
		// 性別一覧を取得する
		List<Gender> genderList = genderService.getGenderList();
		// 性別一覧をsessionに入れる
		session.setAttribute("genderList", genderList);
		//社員情報変更画面へ遷移
		return "empChange";		
	}
	
	//社員番号より、社員情報を変更し、社員一覧画面へ遷移する
	@PostMapping("/changeEmp")
	public String changeEmp(@ModelAttribute("form")  @Valid EmpForm empForm, BindingResult result,
	@RequestParam(value="empCd") String empCd, Model model) {		
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			model.addAttribute("errorList", errorList);
			//toChangeEmp(empCd, empForm);
			return "empChange";
		}else {		
			empService.changeEmp(empForm);
			return "redirect:/empList";
		}
}
}