package com.ql.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ql.bean.EmpData;
import com.ql.form.EmpForm;
import com.ql.mapper.EmpMapper;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description EmpServiceを実装する
 */
@Service
public class EmpServiceImp implements EmpService{
	//EmpMapperを注入する
	@Autowired
	private EmpMapper empMapper;
	
	//社員情報一覧を取得する
	@Override
	public List<EmpData> listEmp(){
		//EmpMapper.listEmpメソッドを呼出し、すべての社員情報を取得する
		return empMapper.listEmp();
	}
	
	//keyWordより社員情報検索
	@Override
	public List<EmpData> searchEmp(String keyWord)	{
		//EmpMapper.searchEmpメソッドを呼出し、キーワードより社員情報を検索する
		return empMapper.searchEmp("%"+keyWord+"%");
	}
	
	//社員の詳細情報を取得
	@Override
	public EmpData getEmpData(String empCd) {
		//EmpMapper.getEmpDataを呼出し、社員番号より社員情報を取得する
		return empMapper.getEmpData(empCd);
	}
	
	//社員情報をデータベースに登録
	@Override
	public void insertEmp(EmpForm empForm) {
		//EmpMapper.insertEmpを呼出し、社員情報を登録する
		empMapper.insertEmp(empForm);
	}
	
	//社員情報を変更
	@Override
	public void changeEmp(EmpForm empForm) {
		//EmpMapper.changeEmpを呼出し、社員情報を変更する
		empMapper.changeEmp(empForm);
	}
	
	//社員情報を削除
	@Override
	public void  deleteEmp(String empCd) {
		//EmpMapper.deleteEmpを呼出し、社員情報を削除する
		empMapper.deleteEmp(empCd);
	}
}
