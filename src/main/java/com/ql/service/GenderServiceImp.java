package com.ql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ql.bean.Gender;
import com.ql.mapper.GenderMapper;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description GenderServiceを実装する
 */
@Service
public class GenderServiceImp implements GenderService{	
	//GenderMapper を注入する
	@Autowired
	private GenderMapper genderMapper;	
	//性別一覧を取得する
	public List<Gender> getGenderList(){
		//GenderMapper.getGenderList()を呼出し、性別一覧を取得する
		return genderMapper.getGenderList();
	}
}
