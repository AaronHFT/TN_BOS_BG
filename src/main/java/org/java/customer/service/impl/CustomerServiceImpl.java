package org.java.customer.service.impl;

import org.java.customer.dao.CustomerMapper;
import org.java.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName CustomerServiceImpl
 * @Description TODO
 * @Author Trouble
 * @Date 2018/09/27 10:22
 * @Version 1.0
 **/
@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    private CustomerMapper cusMapper;

    @Override
    public List<Map<String, Object>> showAllCustomer() {
        return cusMapper.showAllCustomer();
    }

    @Override
    public void delCustomerById(String delId) {
        cusMapper.delCustomerById(delId);
    }

    @Override
    public void addCustomer(Map<String, Object> map) {
        cusMapper.addCustomer(map);
    }

    @Override
    public Map<String, Object> showCustomerById(Map<String, Object> id) {
        return cusMapper.showCustomerById(id);
    }

    @Override
    public void saveCustomer(Map<String, Object> m) {
        cusMapper.saveCustomer(m);
    }
}