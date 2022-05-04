package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.Gender;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description Mybatis¤ÎGenderMapper.xml¥Õ¥¡¥¤¥ë¤ËŒ¤¹¤ë¥¤¥ó¥¿¥Õ¥§©`¥¹
 */
@Mapper
public interface GenderMapper {
	//ĞÔ„eÇéˆóÒ»ÓE
	public List<Gender> getGenderList();
}
