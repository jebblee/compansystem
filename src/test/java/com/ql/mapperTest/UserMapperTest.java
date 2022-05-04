package com.ql.mapperTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ql.CompanysystemApplicationTests;
import com.ql.bean.LoginUser;
import com.ql.mapper.UserMapper;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description UserMapperクラスの機能を検証する
 */
public class UserMapperTest extends CompanysystemApplicationTests {

		@Autowired
		private UserMapper userMapper;
		
		//ユーザーIDが存在する
		@Test
		public void testQueryUser1() {
			LoginUser user = userMapper.find("111@elife.com");
			assertEquals("111@elife.com", user.getAccountId());
			assertEquals("000001", user.getPassword());
		}
		
		//ユーザーIDが存在しない
		@Test
		public void testQueryUser2() {
			LoginUser user = userMapper.find("1@abc.com");
			assertEquals(null, user);
		}
	}

