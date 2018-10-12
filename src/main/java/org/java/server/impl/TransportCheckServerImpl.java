package org.java.server.impl;

import org.java.dao.TransportCheckMapper;
import org.java.server.TransportCheckServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName TransportCheckServerImpl
 * @Description TODO
 * @Author boos
 * @Date 2018/10/6 10:23
 * @Version 1.0
 **/
@Service
public class TransportCheckServerImpl implements TransportCheckServer {
    @Autowired
    private TransportCheckMapper transportCheckMapper;

    @Override
    public List<Map<String, Object>> transportcheck_show() {
        return transportCheckMapper.transportcheck_show();
    }

    @Override
    public void transportcheck_del(String check_id) {
        transportCheckMapper.transportcheck_del(check_id);
    }

    @Override
    public List<Map<String, Object>> transportcheck_sel(String check_id) {
        return transportCheckMapper.transportcheck_sel(check_id);
    }

    @Override
    public void transportcheck_up1(Map<String, Object> m) {
        transportCheckMapper.transportcheck_up1(m);
    }

    @Override
    public List<Map<String, Object>> transportcheck_sel2() {
        return  transportCheckMapper.transportcheck_sel2();
    }

    @Override
    public void transportcheck_add1(Map<String, Object> m) {
        transportCheckMapper.transportcheck_add1(m);
    }
}
