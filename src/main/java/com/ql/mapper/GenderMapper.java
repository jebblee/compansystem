package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.Gender;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description Mybatis��GenderMapper.xml�ե�����ˌ����륤�󥿥ե��`��
 */
@Mapper
public interface GenderMapper {
	//�Ԅe���һ�E
	public List<Gender> getGenderList();
}
