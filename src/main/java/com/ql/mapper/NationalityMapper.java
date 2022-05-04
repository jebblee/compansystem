package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.Nationality;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description MybatisのNationalityMapper.xmlファイルに��するインタフェ�`ス
 */
@Mapper
public interface NationalityMapper {
	//忽汐秤�麭屍E
	public List<Nationality> getNationalityList();
}
