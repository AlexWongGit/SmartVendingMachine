package com.alex.vm.annoation;

import java.lang.annotation.*;

/**
 * @author wangzifeng
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MqttTopic {

    String[] value();

    int qos() default 0;
}
