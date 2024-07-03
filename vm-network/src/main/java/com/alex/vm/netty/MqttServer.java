package com.alex.vm.netty;

import com.alex.vm.BusController;
import com.alex.vm.config.BrokerConfig;
import com.alex.vm.config.NettyConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MqttServer {

    private BusController busController;
    private BrokerConfig brokerConfig;
    private NettyConfig nettyConfig;

}
