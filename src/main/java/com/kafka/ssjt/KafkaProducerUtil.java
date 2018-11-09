package com.kafka.ssjt;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 注意：一定要根据自己的需要修改文件
 */
public class KafkaProducerUtil {
	// 创建kafkaProducer的配置文件
	private static final Properties props = new Properties();
	private Producer<String, String> producer = new KafkaProducer<>(props);

	// 填写配置文件
	static {
		props.put("bootstrap.servers", "hadoop03:9092,hadoop04:9092,hadoop05:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	}

	/**
	 * 向指定主题发送消息，可根据需要修改发送指定格式的消息。
	 *
	 * @param topic 主题
	 * @param key   key值
	 * @param value value值
	 */
	public void sendMesage(String topic, String key, String value) {
		ProducerRecord<String, String> message = new ProducerRecord<>(topic, key, value);
		producer.send(message);
	}

	/**
	 * 关闭生产者
	 */
	public void close() {
		if (null != producer) {
			producer.close();
		}
	}

}
