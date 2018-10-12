package org.java.order.service.impl;

import org.java.order.dao.OrderMapper;
import org.java.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName OlderServiceImpl
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/07 10:13
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> showAllOrder() {
        return orderMapper.showAllOrder();
    }

    @Override
    public void updOrderState(Map<String, Object> map) {
        orderMapper.updOrderState(map);
    }

    @Override
    public List<Map<String, Object>> store_load(Map<String, Object> map) {
        return orderMapper.store_load(map);
    }

    @Override
    public void saveStore(Map<String, Object> map) {
      orderMapper.saveStore(map);
    }

}
