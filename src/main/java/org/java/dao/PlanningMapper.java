package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName PlanningMapper
 * @Description TODO
 * @Author boos
 * @Date 2018/10/1 10:14
 * @Version 1.0
 **/
@Mapper
public interface PlanningMapper {
    //查看所有计划
    List<Map<String, Object>> distrbution_show();

    //删除计划
    void planning_del(String tspt_id);

    //查询出库订单
    List<Map<String, Object>> planning_sel();

  //查询地址
    List<Map<String, Object>> planning(String order_id);

    //分配
    List<Map<String, Object>> allocation();

    //分配车辆
    List<Map<String, Object>> planning_truck();

    //分配驾驶员
    List<Map<String, Object>> planning_pilot();

    //修改驾驶员
    void allocation_up1(Map<String, Object> m);

    //修改车辆状态
    void allocation_up2(Map<String, Object> m);

    //修改运输
    void allocation_up3(Map<String, Object> m);

    //添加运输计划
    void planning_add2(Map<String, Object> m);

    //查看运输的详情
    List<Map<String, Object>> distrbution_gps();

    //查看运输的详情的出发地点到达地点
    List<Map<String, Object>> planning_GPSsel(String order_id);

    //修改运输状态
    void planning_up(Map<String, Object> m);

    List<Map<String, Object>> planning_sel5();
}
