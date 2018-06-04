package com.ribbon.custom.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义负载均衡方法，每个机器调用5次
 * User: KeyreneLu
 * Date: 2018-06-04
 * Time: 21:36
 */
public class Rule_Custom extends AbstractLoadBalancerRule {

    private int total=0; //每个机器调用的次数
    private int index = 0; //当前机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {

                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);
            if (total<5){
                server = upList.get(index);
                total++;
            }else {
                total = 0;
                index++;
                if (index>=upList.size()){
                    index = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

//    protected int chooseRandomInt(int serverCount) {
//        return ThreadLocalRandom.current().nextInt(serverCount);
//    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}