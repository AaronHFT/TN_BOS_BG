package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName TransportMapper
 * @Description 驾驶员
 * @Author boos
 * @Date 2018/9/25 12:33
 * @Version 1.0
 **/
@Mapper
public interface TransportMapper {

     //查看所有驾驶员及附属信息
     List<Map<String, Object>> drivershow();

     //删除驾驶员
     void driverManage_del(String pilot_id);

     //添加驾驶员
     void driverManage_add(Map<String, Object> m);

     //查看驾驶员
     List<Map<String, Object>> driverManage_sel();

     //添加驾驶员业务
     void driverManage_add1(String pilot_id);
}
