package com.ql.service;
import java.util.List;

//import org.springframework.stereotype.Service;

import com.ql.bean.EmpData;
import com.ql.form.EmpForm;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 社員情報の一覧、検索、登録、変更、削除等機能を定義するインタフェース
 */
public interface EmpService {
	//社員情報一覧
	public List<EmpData> listEmp();
	
	//キーワードで社員情報を検索
	public List<EmpData> searchEmp(String keyWord);
	
	//社員番号で社員の詳細情報を取得
	public EmpData getEmpData(String empCd);
	
	//社員情報をデータベースに登録
	public void insertEmp(EmpForm empForm);
	
	//社員情報を変更
	public void changeEmp(EmpForm empForm);
	
	//社員情報を削除
	public void deleteEmp(String empCd);
}


