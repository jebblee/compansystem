package com.ql.service;

import java.util.List;
//import org.springframework.stereotype.Service;
import com.ql.bean.Gender;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 性別情報一覧機能を定義するインタフェース
 */
public interface GenderService {	
	    //性別情報一覧
		public List<Gender> getGenderList();
}
