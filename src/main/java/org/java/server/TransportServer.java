package org.java.server;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName TransportServer
 * @Description 运输Server接口
 * @Author boos
 * @Date 2018/9/25 10:04
 * @Version 1.0
 **/
public interface TransportServer {
    //显示驾驶员信息
    List<Map<String, Object>> drivershow();

    //删除驾驶员信息
    void driverManage_del(String pilot_id );

    //添加驾驶员信息
    void driverManage_add(Map<String, Object> m);
}
