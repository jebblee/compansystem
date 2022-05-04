package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.Gender;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description MybatisのGenderMapper.xmlファイルに��するインタフェ�`ス
 */
@Mapper
public interface GenderMapper {
	//來�e秤�麭屍E
	public List<Gender> getGenderList();
}
