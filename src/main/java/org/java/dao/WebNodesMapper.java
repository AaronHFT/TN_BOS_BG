package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName WebNodesMapper
 * @Description 网点管理dao类
 * @Author Administrator
 * @Date 2018/9/25 0025 15:22
 * @Version 1.0
 **/
@Mapper
public interface WebNodesMapper {

    //添加网点
    void addWebNode(Map<String,Object> map);

    //删除网点
    void delWebNode(Map<String,Object> map);

    //修改网点
    void editWebNode(Map<String,Object> map);

    //查询所有网点信息
    List<Map<String,Object>> queryWebNodes();

    //查询单个网点信息
    Map<String,Object> queryWebNode(Integer id);
}
