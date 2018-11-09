package com.kafka.ssjt;

/**
 * @Author: shy
 * @Date: 2018/11/9 14:50
 * @Description:
 */
public class Demo {
	public static void main(String[] args) {
		KafkaProducerUtil producer = new KafkaProducerUtil();
		for (int i = 0; i < 1000; i++) {
			producer.sendMesage("ssjt_test", "key" + i, "value" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
