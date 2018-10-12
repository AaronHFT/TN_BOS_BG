package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName CarManageMapper
 * @Description TODO
 * @Author boos
 * @Date 2018/9/27 15:34
 * @Version 1.0
 **/
@Mapper
public interface CarManageMapper {
//查询所有车辆
    List<Map<String, Object>> carManage_show();

    //条件查询车辆
    List<Map<String, Object>> carManage_sel(String truck_type);

    //车牌查询车辆
    List<Map<String, Object>> carManage_sel1(String plate_number);

    //状态查询
    List<Map<String, Object>> carManage_sel2(String truckState);

    //删除车辆信息
    void carManage_del(String truck_id);

    //车辆信息
    List<Map<String, Object>> carManage_sel3(String truck_id) ;

    //添加车辆信息
    void carManage_add2(Map<String, Object> m);
}
