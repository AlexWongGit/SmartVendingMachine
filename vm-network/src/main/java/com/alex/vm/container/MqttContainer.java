package com.alex.vm.container;

import com.alex.vm.annoation.MqttTopic;
import com.alex.vm.handler.MqttTopicHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MqttContainer implements InitializingBean {

    @Resource
    private ApplicationContext applicationContext;

    private ConcurrentHashMap<String, MqttTopicHandler> topicHandlerMap = new ConcurrentHashMap<>();

    public MqttTopicHandler getTopicHandler(String topic) {
        return topicHandlerMap.get(topic);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, MqttTopicHandler> beansOfType = applicationContext.getBeansOfType(MqttTopicHandler.class);
        Collection<MqttTopicHandler> values = beansOfType.values();
        if (values.size() > 0) {
            values.forEach(mqttTopicHandler -> {
                if (mqttTopicHandler.getClass().isAnnotationPresent(MqttTopic.class)) {
                    MqttTopic topic = mqttTopicHandler.getClass().getAnnotation(MqttTopic.class);
                    for (String s : topic.value()) {
                        if (!topicHandlerMap.containsKey(s)) {
                            topicHandlerMap.put(s,mqttTopicHandler);
                        }
                    }
                }
            });
        }
    }
}
