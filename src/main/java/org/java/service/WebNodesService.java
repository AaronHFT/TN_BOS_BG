package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName WebNodesService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 15:43
 * @Version 1.0
 **/
public interface WebNodesService {
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
