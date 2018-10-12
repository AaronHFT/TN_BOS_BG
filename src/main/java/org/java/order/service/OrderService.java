package org.java.order.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName olderService
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/07 10:11
 * @Version 1.0
 **/
public interface OrderService {
    //显示所有订单
    List<Map<String,Object>> showAllOrder();
    //更改订单状态为处理订单
    void updOrderState(Map<String,Object> map);
    //加载仓库位置
    List<Map<String,Object>> store_load(Map<String,Object> map);
    //保存仓库
    void saveStore(Map<String,Object> map);
}
