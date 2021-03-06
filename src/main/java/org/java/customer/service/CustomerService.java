package org.java.customer.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName CustomerService
 * @Description TODO
 * @Author Trouble
 * @Date 2018/09/27 9:48
 * @Version 1.0
 **/
public interface CustomerService {

    List<Map<String,Object>> showAllCustomer();

    void delCustomerById(String delId);

    void addCustomer(Map<String,Object> map);

    Map<String,Object> showCustomerById(Map<String,Object> id);

    void saveCustomer(Map<String,Object> m);

    List<Map<String,Object>> loadContacts(Map<String,Object> map);

    void delContact(Map<String,Object> map);

    void addContact(Map<String,Object> map);

    void editContact(Map<String,Object> map);

    void delContactsByCusId(String id);

    Integer findOrdById(String id);
}
