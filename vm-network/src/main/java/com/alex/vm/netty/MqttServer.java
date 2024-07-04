package com.alex.vm.netty;

import com.alex.vm.BusController;
import com.alex.vm.config.BrokerConfig;
import com.alex.vm.config.NettyConfig;
import com.alex.vm.listener.MqttEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class MqttServer {

    private BusController busController;
    private BrokerConfig brokerConfig;
    private NettyConfig nettyConfig;

    private MqttRemotingServer mqttRemotingServer;
    private MqttEventListener mqttEventListener;

    public MqttServer(BrokerConfig brokerConfig, NettyConfig nettyConfig, BusController busController, MqttEventListener mqttEventListener, MqttRemotingServer mqttRemotingServer) {
        this.brokerConfig = brokerConfig;
        this.nettyConfig = nettyConfig;
        this.busController = busController;
        this.mqttRemotingServer = mqttRemotingServer;
        this.mqttEventListener = mqttEventListener;
    }

    public void start() {

        //new ReentrantLock()
    }
}
