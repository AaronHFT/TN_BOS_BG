package org.java.server;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName CarManageServer
 * @Description 车辆管理
 * @Author boos
 * @Date 2018/9/27 15:32
 * @Version 1.0
 **/

public interface CarManageServer {
    //查询所有的车辆
    List<Map<String, Object>> carManage_show();

    //条件查询
    List<Map<String, Object>> carManage_sel(String truck_type);

    //车牌查询车量
    List<Map<String, Object>> carManage_sel1(String plate_number);

    //状态查询车辆
    List<Map<String, Object>> carManage_sel2(String truckState);

    //删除车辆信息
    void carManage_del(String truck_id);

    //单个车辆信息
    List<Map<String, Object>> carManage_sel3(String truck_id);

    //添加车辆信息
    void carManage_add2(Map<String, Object> m);
}
