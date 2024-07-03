package com.alex.vm.consummer;

import com.alex.vm.annoation.MqttTopic;
import com.alex.vm.handler.MqttTopicHandler;
import io.netty.handler.codec.mqtt.MqttMessage;

@MqttTopic(value = {"test/topic1","test/topic2"}, qos = 1)
public class TestConsummer implements MqttTopicHandler {
    @Override
    public void handle(String topic, MqttMessage message) {

    }
}
