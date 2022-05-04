package com.ql.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
/**
 * 
 * @author LQ
 * @date 04/19/2022
 * @version 1.0
 * @description 国際化と入力検証の配置ファイル
 */
@Configuration
public class MessageConfig {
	    //MessageSourceを注入する
		@Autowired
		private MessageSource messageSource;
		
		@Bean
		//入力検証のエラーメッセージソースとメッセージソースは同一MessageSourceに指定する
		public LocalValidatorFactoryBean validator() {			
			LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
			//入力検証のエラーメッセージソースとメッセージソースは同一MessageSourceに指定する
			localValidatorFactoryBean.setValidationMessageSource(messageSource);			
			return localValidatorFactoryBean;
		}
}
