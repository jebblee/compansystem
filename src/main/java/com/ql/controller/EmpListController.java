package com.ql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.ql.bean.EmpData;
import com.ql.service.EmpService;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 一覧画面に設定、keywordで情報検索、社員情報詳細画面表示、社員情報削除
 */
@Controller
@ComponentScan({"service"})
public class EmpListController {
	//EmpServiceを注入する
	@Autowired
	private EmpService empService;

	//社員情報一覧
	@GetMapping("/empList")
	public String listEmp(Model model) {
		//全ての社員情報検索
		List<EmpData> empList = empService.listEmp();
		//検索結果empListをModelに追加
		model.addAttribute("empList",empList);
		//社員情報一覧画面に遷移する
		return "empList";
	}
	
	//keyWordで社員情報検索
	@GetMapping("/searchEmp")	
	//画面から入力するkeyWordをリクエストパラメータとして受け取る
	public String searchEmp(@RequestParam(value="keyWord") String keyWord,Model model) {
		//keyWordで社員情報検索
		List<EmpData> empList = empService.searchEmp(keyWord);
		//検索結果empListをModelに追加
		model.addAttribute("empList",empList);	
		//社員情報一覧画面に遷移する
		return "empList";
	}
	
	//社員詳細情報を表示
	@GetMapping("/showDetails")
	public String showDetails(@RequestParam(value="empCd")String empCd,Model model) {
		//社員番号で社員情報を取得
		EmpData empData = empService.getEmpData(empCd);
		//取得結果を詳細画面にModelに追加
		model.addAttribute("empData",empData);
		//社員情報一覧画面に遷移する
		return "empDetails";
	}
	
	//社員情報を削除
	@RequestMapping("/deleteEmp")
	public String deleteEmp(@RequestParam(value="empCd")String empCd) {		
		empService.deleteEmp(empCd);				
		return "redirect:/empList";
	}
	
}
