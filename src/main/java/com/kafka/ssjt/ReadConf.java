package com.kafka.ssjt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: shy
 * @Date: 2018/11/9 17:03
 * @Description:
 */
public class ReadConf {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		// 使用InPutStream流读取properties文件
		BufferedReader bufferedReader = new BufferedReader(new FileReader("conf/conf.properties"));
		properties.load(bufferedReader);
		// 获取key对应的value值
		System.out.println(properties.getProperty("URL"));
		System.out.println(properties.getProperty("USER"));
		System.out.println(properties.getProperty("PASSWORD"));
	}
}
