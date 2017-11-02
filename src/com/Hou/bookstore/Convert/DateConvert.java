package com.Hou.bookstore.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * S source 要转换的数据对象
 * T target 装换成什么对象类型
 * 
 * 把字符串日期 装换成date 对象
 * @author Administrator
 *
 */
public class DateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
	
		//日期格式转换SimpleDateFormat类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
