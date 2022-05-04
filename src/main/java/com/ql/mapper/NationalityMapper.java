package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.Nationality;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description Mybatis¤ÎNationalityMapper.xml¥Õ¥¡¥¤¥ë¤ËŒ¤¹¤ë¥¤¥ó¥¿¥Õ¥§©`¥¹
 */
@Mapper
public interface NationalityMapper {
	//¹ú¼®ÇéˆóÒ»ÓE
	public List<Nationality> getNationalityList();
}
