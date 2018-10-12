package org.java.order.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName OlderMapper
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/07 10:12
 * @Version 1.0
 **/
@Mapper
public interface OrderMapper {

    //显示所有订单
    List<Map<String,Object>> showAllOrder();
    //更改订单状态为处理订单
    void updOrderState(Map<String,Object> map);
    //加载仓库位置
    List<Map<String,Object>> store_load(Map<String,Object> map);
    //保存仓库
    void saveStore(Map<String,Object> map);
}
