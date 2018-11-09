package com.kafka.ssjt;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @Author: shy
 * @Date: 2018/11/9 14:57
 * @Description:
 */
public class KafkaConsumerUtil {
	// 创建kafkaProducer的配置文件
	private static final Properties props = new Properties();
	private KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

	static {
		props.put("bootstrap.servers", "hadoop03:9092,hadoop04:9092,hadoop05:9092");
		props.put("group.id", "0");
		props.put("enable.auto.commit", "true");
		props.put("auto.offset.reset", "earliest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	}

	public void getMessage(String topic) {
		consumer.subscribe(Collections.singletonList(topic));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1000);
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(record.key() + "----------" + record.value());
			}
		}
	}


	public static void main(String[] args) {
		KafkaConsumerUtil consumer = new KafkaConsumerUtil();
		consumer.getMessage("ssjt_test");
	}


}