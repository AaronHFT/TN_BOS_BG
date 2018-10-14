package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName UserMapper
 * @Description 用户登录
 * @Author Administrator
 * @Date 2018/10/14 0014 9:06
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {
    public Map<String,Object> checkLogin(Map<String,Object> user);
}
