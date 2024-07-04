package com.alex.vm.netty.service;


/**
 * @description 模拟远程启动
 * @author wangzf
 * @date 2024/7/4
 */
public interface RemotingService {


    /**
     * remoting start
     */
    void start();

    /**
     * remoting shutdown
     */
    void shutdown();
}
