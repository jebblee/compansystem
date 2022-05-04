package com.ql.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.LoginUser;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description MybatisのUserMapper.xmlファイルに対するインタフェース
 */
@Mapper
public interface UserMapper {
	//ログインユーザー検索メソッドを定義する
	public LoginUser find(String accountId);
}
