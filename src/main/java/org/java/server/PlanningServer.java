package org.java.server;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName PlanningServer
 * @Description TODO
 * @Author boos
 * @Date 2018/10/1 10:12
 * @Version 1.0
 **/
public interface PlanningServer {
    //查看每一订单的配送计划，通过计算出发地点到到达地点最省时最省钱的计划
    List<Map<String, Object>> distrbution_show();

    //删除配送计划
    void planning_del(String tspt_id);

    //查询出库订单
    List<Map<String, Object>> planning_sel();

    //获取地址
    List<Map<String, Object>> planning(String order_id);

    //分配
    List<Map<String, Object>> allocation();

    //查找合适的车辆
    List<Map<String, Object>> planning_truck();

    //查找合适的驾驶员
    List<Map<String, Object>> planning_pilot();

    //修改运输
    void allocation_up(Map<String, Object> m);

    //添加运输计划
    void planning_add2(Map<String, Object> m);

    //查看运输的详情
    List<Map<String, Object>> distrbution_gps();

    //查看运输的详情的出发地点到达地点
    List<Map<String, Object>> planning_GPSsel(String order_id);


    List<Map<String, Object>> planning_sel5();
}
