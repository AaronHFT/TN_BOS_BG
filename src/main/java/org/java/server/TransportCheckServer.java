package org.java.server;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS_BG
 * @ClassName TransportCheckServer
 * @Description TODO
 * @Author boos
 * @Date 2018/10/6 10:22
 * @Version 1.0
 **/
public interface TransportCheckServer {
    //查看所有的车辆考勤
    List<Map<String, Object>> transportcheck_show();

    //删除车辆考勤
    void transportcheck_del(String check_id);

    //查询单个考勤
    List<Map<String, Object>> transportcheck_sel(String check_id);

    //修改考勤
    void transportcheck_up1(Map<String, Object> m);

    //考勤
    List<Map<String, Object>> transportcheck_sel2();

    //添加
    void transportcheck_add1(Map<String, Object> m);
}
