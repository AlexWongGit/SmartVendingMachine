package com.alex.vm.handler;

import io.netty.handler.codec.mqtt.MqttMessage;

public interface MqttTopicHandler {

    void handle(String topic, MqttMessage message);
}
