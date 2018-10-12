package org.java.server.impl;

import org.java.dao.TransportMapper;
import org.java.server.TransportServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName TransportServerImpl
 * @Description  运输的实现
 * @Author boos
 * @Date 2018/9/25 10:06
 * @Version 1.0
 **/
@Service
public class TransportServerImpl  implements TransportServer {

    @Autowired
    private TransportMapper transportMapper;

    /**
     * @Author boos
     * @Description //查看所有驾驶员
     * @Date 15:02 2018/9/25
     * @Param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @Override
    public List<Map<String, Object>> drivershow() {
        return  transportMapper.drivershow();

    }

    @Override
    public void driverManage_del( String pilot_id) {
        transportMapper.driverManage_del(pilot_id);
    }

    @Override
    public void driverManage_add(Map<String, Object> m) {
        transportMapper.driverManage_add(m);
        List<Map<String, Object>> driver=transportMapper.driverManage_sel();
        System.out.println(driver);
        transportMapper.driverManage_add1(driver.get(0).get("pilot_id").toString());
    }
}
