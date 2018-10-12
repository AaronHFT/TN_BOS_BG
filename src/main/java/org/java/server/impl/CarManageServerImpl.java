package org.java.server.impl;

import org.java.dao.CarManageMapper;
import org.java.server.CarManageServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName CarManageServerImpl
 * @Description TODO
 * @Author boos
 * @Date 2018/9/27 15:33
 * @Version 1.0
 **/
@Service
public class CarManageServerImpl implements CarManageServer {
    @Autowired
    private CarManageMapper carManageMapper;

    @Override
    public List<Map<String, Object>> carManage_show() {
        return carManageMapper.carManage_show();
    }

    @Override
    public List<Map<String, Object>> carManage_sel(String truck_type) {
        return carManageMapper.carManage_sel(truck_type);
    }

    @Override
    public List<Map<String, Object>> carManage_sel1(String plate_number) {
        return carManageMapper.carManage_sel1(plate_number);
    }

    @Override
    public List<Map<String, Object>> carManage_sel2(String truckState) {
        return carManageMapper.carManage_sel2(truckState);
    }

    @Override
    public void carManage_del(String truck_id) {
        carManageMapper. carManage_del( truck_id);
    }

    @Override
    public List<Map<String, Object>> carManage_sel3(String truck_id) {
        return carManageMapper.carManage_sel3(truck_id);
    }

    @Override
    public void carManage_add2(Map<String, Object> m) {
        carManageMapper. carManage_add2( m);
    }
}
