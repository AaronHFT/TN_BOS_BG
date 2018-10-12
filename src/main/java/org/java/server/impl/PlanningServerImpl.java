package org.java.server.impl;

import org.java.dao.PlanningMapper;
import org.java.server.PlanningServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName PlanningServerImpl
 * @Description 配送计划
 * @Author boos
 * @Date 2018/10/1 10:13
 * @Version 1.0
 **/
@Service
public class PlanningServerImpl implements PlanningServer {

    @Autowired
    private PlanningMapper planningMapper;

    @Override
    public List<Map<String, Object>> distrbution_show() {
        return planningMapper.distrbution_show();
    }

    @Override
    public void planning_del(String tspt_id) {
        planningMapper.planning_del( tspt_id);
    }

    @Override
    public List<Map<String, Object>> planning_sel() {
        return planningMapper.planning_sel();
    }

    @Override
    public List<Map<String, Object>> planning(String order_id) {
        return  planningMapper.planning(order_id);
    }

    @Override
    public List<Map<String, Object>> allocation() {
        return planningMapper.allocation();
    }

    @Override
    public List<Map<String, Object>> planning_truck() {
        return planningMapper.planning_truck();
    }

    @Override
    public List<Map<String, Object>> planning_pilot() {
        return planningMapper.planning_pilot();
    }

    @Override
    public void allocation_up(Map<String, Object> m) {
        planningMapper.allocation_up1(m);
        planningMapper.allocation_up2(m);
        planningMapper.allocation_up3(m);
    }

    @Override
    public void planning_add2(Map<String, Object> m) {

        planningMapper.planning_add2(m);
        planningMapper.planning_up(m);//提交时修改运输状态
    }

    @Override
    public List<Map<String, Object>> distrbution_gps() {
        return planningMapper.distrbution_gps();
    }

    @Override
    public List<Map<String, Object>> planning_GPSsel(String order_id) {
        return planningMapper.planning_GPSsel( order_id);
    }

    @Override
    public List<Map<String, Object>> planning_sel5() {
        return planningMapper.planning_sel5();
    }
}
