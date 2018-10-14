package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface InStoreMapper {

    //创建收货通知单
    public void createCheckreach(Map<String,Object> map);

    //获取所有的入库类型
    public List<Map<String,Object>> getInStoreTypes();

    //获取所有的仓库
    public List<Map<String,Object>> getStorelist();

    //获取所有的仓库区域
    public List<Map<String,Object>> getStoreRegion();

    //获取所有的仓位
    public List<Map<String,Object>> getStorePosition();

    //查询所有未确认的订单
    public List<Map<String,Object>> checkStore();

    //查询所有未制定计划的订单
    public List<Map<String,Object>> checkPlan();

    //确认到货，更改订单表的状态为已到货
    public void editorder(@Param("orderid") String orderid);

    //通过收货通知单编号获取信息，传值到创建计划单页面
    public Map<String,Object> getGoodinfo(@Param("gid") String gid);

    //创建入库计划单
    public void createPlanorder(Map<String,Object> map);

    //将最初始的订单状态更改为已制定计划
    public void editOrderPlan(@Param("orderid") String orderid);

    //货物盘点验收单
    public void createCheckGood(Map<String,Object> map);

    //创建收货单
    public void createGoodAccept(Map<String,Object> map);

    //查询仓库的信息
    public List<Map<String,Object>> showStores();

    //查询所有未入库的收货单
    public List<Map<String,Object>> showGoodAccept();

    //确认已到货并且已完成入库计划单的制定,将订单信息更改为已到货
    public void checkStoretrue(@Param("orderid") String orderid);

    //查询所有已到货的未入库订单
    public List<Map<String,Object>> showAllcheckOrder();

    //查询出即将入库订单的信息
    public List<Map<String,Object>> getOrderinfo(@Param("orderid") String orderid);

    //通过即将入库的订单货物代码查询在库货品中是否存在
    public Map<String,Object> findByGoodcode(@Param("goodcode") String goodcode);

    //将订单入库
    public void goodInstore(Map<String,Object> map);

    //将新的货品信息添加到在库货品中
    public void goodAdd(Map<String,Object> map);

    //通过货品代码查询出新增的在库货品信息
    public Map<String,Object> findGoodBycode(@Param("goodcode") String goodcode);

    //若入库货品已经在库修改它的数量
    public void updateGood(Map<String,Object> map);

    //订单入库之后,修改订单的状态为质检完成
    public void checkOrderInstore(@Param("orderid") String orderid);

    //验收货物前通过订单号查询订单信息中的订单状态
    public Map<String,Object> findOrderByid(@Param("orderid") String orderid);

    //将订单状态更改为验收中
    public void editOrderCheck(@Param("orderid") String orderid);

    //将订单状态更改为已验收
    public void checkOrdertrue(@Param("orderid") String orderid);

    //显示所有订单的验收记录
    public List<Map<String,Object>> showGoodCheck();

    //通过goodcheckID查询出对应的验收记录信息
    public Map<String,Object> findCheckgoodByid(@Param("goodcheckid") String goodcheckid);

    //当验收失败时,将订单状态更改为已到货
    public void editOrderFail(@Param("orderid") String orderid);

    //将验收失败对应的记录删除
    public void delGoodcheck(@Param("goodcheckid") String goodcheckid);

    //扫码枪扫描订单id查询出对应的信息,通过json回显到页面
    public Map<String,Object> searchOrderinfo(@Param("orderid") String orderid);

    //创建验收单之前查询出对应订单的收货通知单信息
    public Map<String,Object> getgoodreachinfo(@Param("orderid") String orderid);

    //查询所有已到货的订单信息
    public List<Map<String,Object>> showArriveGood();

    //查询所有已验收的订单信息
    public List<Map<String,Object>> showGoodChecked();

    //创建收货单之前查询出对应订单的验收单信息
    public List<Map<String,Object>> acceptGood(@Param("orderid") String orderid);

    //查询当前人员是否已经验收过当前订单
    public Map<String,Object> IsChecked(Map<String,Object> map);

    //收货后将订单的状态更改为已收货
    public void editOrderAccept(@Param("orderid") String orderid);
}
