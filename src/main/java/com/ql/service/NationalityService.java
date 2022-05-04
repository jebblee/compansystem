package com.ql.service;

import java.util.List;
//import org.springframework.stereotype.Service;
import com.ql.bean.Nationality;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 国籍リストを取得機能を定義するインタフェース
 */
public interface  NationalityService {
	//国籍リストを取得
	public List<Nationality> getNationalityList();	
}
