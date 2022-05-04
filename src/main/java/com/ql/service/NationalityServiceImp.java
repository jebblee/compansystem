package com.ql.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ql.bean.Nationality;
import com.ql.mapper.NationalityMapper;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description NationalityServiceを実装する
 */
@Service
public class NationalityServiceImp implements NationalityService{
	//NationalityMapper を注入する
	@Autowired
	private NationalityMapper  nationalityMapper;
	
	//国籍リストを取得
	public List<Nationality> getNationalityList(){
		//NationalityMapper.getNationalityLisを呼出し、国籍一覧を取得する
		return nationalityMapper.getNationalityList();
	}
}
