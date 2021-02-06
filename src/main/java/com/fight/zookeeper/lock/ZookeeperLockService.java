package com.fight.zookeeper.lock;

/**
 * @Author Calpis
 * @Description zookeeper分布式锁
 * @Date 2021/2/6 1:34
 */
public interface ZookeeperLockService {

    void lock(String key);
}
