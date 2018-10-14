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

    @Override
    public List<Map<String, Object>> loadContacts(Map<String, Object> map) {
        return cusMapper.loadContacts(map);
    }

    @Override
    public void delContact(Map<String, Object> map) {
        cusMapper.delContact(map);
    }

    @Override
    public void addContact(Map<String, Object> map) {
        cusMapper.addContact(map);
    }

    @Override
    public void editContact(Map<String, Object> map) {
        cusMapper.editContact(map);
    }

    @Override
    public void  delContactsByCusId(String id){
        cusMapper.delContactsByCusId(id);
    }

    @Override
    public Integer findOrdById(String id) {
        return cusMapper.findOrdById(id);
    }
}
