package org.java.customer.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName CustomerMapper
 * @Description TODO
 * @Author Trouble
 * @Date 2018/09/27 9:48
 * @Version 1.0
 **/
@Mapper
public interface CustomerMapper {

    //显示所有客户
    List<Map<String,Object>> showAllCustomer();

    //根据id删除客户
    void delCustomerById(String delId);

    //增加新客户
    void addCustomer(Map<String,Object> map);

    //根据id显示客户信息
    Map<String,Object> showCustomerById(Map<String,Object> id);

    //保存客户信息
    void saveCustomer(Map<String,Object> m);
}
