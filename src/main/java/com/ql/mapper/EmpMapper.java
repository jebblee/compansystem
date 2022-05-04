package com.ql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ql.bean.EmpData;
import com.ql.form.EmpForm;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description MybatisのEmpMapper.xmlファイルに対するインタフェース
 */
@Mapper
public interface EmpMapper {
	//社員情報一覧
	public List<EmpData> listEmp();
	
	//キーワードで社員情報を検索
	public List<EmpData> searchEmp(String keyWord);
	
	//社員番号で社員の詳細情報を取得
	public EmpData getEmpData(String empCd);
	
	//社員情報をデータベースに登録
	public void insertEmp(EmpForm empForm);
	
	//社員情報を変更
	public void changeEmp(EmpForm empForm);
	
	//社員情報を削除
	public void deleteEmp(String empCd);
}
