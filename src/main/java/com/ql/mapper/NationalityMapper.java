package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.Nationality;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description Mybatis��NationalityMapper.xml�ե�����ˌ����륤�󥿥ե��`��
 */
@Mapper
public interface NationalityMapper {
	//�������һ�E
	public List<Nationality> getNationalityList();
}
