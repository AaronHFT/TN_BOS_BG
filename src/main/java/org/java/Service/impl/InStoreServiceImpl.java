package org.java.service.Impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.java.dao.InStoreMapper;
import org.java.service.InStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.java.util.*;
import org.activiti.engine.runtime.ProcessInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InStoreServiceImpl implements InStoreService {

    @Autowired
    private InStoreMapper inStoremapper;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * 创建收货通知单
     * @param map
     */
    @Override
    public void createCheckreach(Map<String, Object> map) {
        //获得要启动的流程定义的 key
        System.out.println("------------准备创建流程实例");
        String processDefinitionKey = ResourcesUtil.getValue("diagrams/process",
                "InstoreDefinitionProcessKey");
        //通过uuid,产生一个随机字符串，作为工作流的businessKey(业务字段)，用于与业务表关联。同时，它也是业务表的主键
        String businessKey = UuidUtil.getTimeBasedUuid().toString();
        //设置任务的发起人
        String userId = (String) map.get("userId");
        identityService.setAuthenticatedUserId(userId);
        //启动流程实列
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                processDefinitionKey, businessKey);
        // (#{id},#{name},#{price},#{content},#{createtime},#{status},#{userid},#{processinstanceid},#{endtime})
        /*************************** 向业务表中添加数据 **************************************************/
        // 向map中，存放需要的数据
        map.put("id",businessKey);
        map.put("processinstanceid", instance.getProcessInstanceId());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String createtime=sdf.format(new Date());
        map.put("creatime",createtime);
        inStoremapper.createCheckreach(map);
        System.out.println("创建成功!");
    }

    //获取所有的入库类型集合
    @Override
    public List<Map<String, Object>> getInStoreTypes() {
        return inStoremapper.getInStoreTypes();
    }

    //获取所有仓库的集合
    @Override
    public List<Map<String, Object>> getstorelist() {
        return inStoremapper.getStorelist();
    }

    //查询所有未确认的订单信息
    @Override
    public List<Map<String, Object>> checkStore() {
        return inStoremapper.checkStore();
    }

    //确认到货，更改订单表的状态为已到货
    @Override
    public void editorder(String orderid) {
        inStoremapper.editorder(orderid);
    }

    //通过收货通知单获取信息传值到创建入库计划页面
    @Override
    public Map<String, Object> getGoodinfo(String gid) {
        return inStoremapper.getGoodinfo(gid);
    }

    //创建入库计划单
    @Override
    public void createPlanorder(Map<String, Object> map) {
        inStoremapper.createPlanorder(map);
    }

    //货物盘点验收单
    @Override
    public void createCheckGood(Map<String, Object> map) {
        inStoremapper.createCheckGood(map);
    }

    //创建收货单
    @Override
    public void createGoodAccept(Map<String, Object> map) {
        inStoremapper.createGoodAccept(map);
    }

    //查询所有的仓库信息
    @Override
    public List<Map<String, Object>> showStores() {
        return inStoremapper.showStores();
    }

    //查询所有未制定计划的订单
    @Override
    public List<Map<String, Object>> checkPlan() {
        return inStoremapper.checkPlan();
    }

    //将订单状态更改为已到货状态
    @Override
    public void checkStoretrue(String orderid) {
        inStoremapper.checkStoretrue(orderid);
    }

    //将最初始的订单状态更改为已制定计划
    @Override
    public void editOrderPlan(String orderid) {
        inStoremapper.editOrderPlan(orderid);
    }

    //查询所有的未入库的已到货订单
    @Override
    public List<Map<String, Object>> showAllcheckOrder() {
        return inStoremapper.showAllcheckOrder();
    }

    //查询出即将入库订单的信息
    @Override
    public Map<String, Object> getOrderinfo(String orderid) {
        return inStoremapper.getOrderinfo(orderid).get(0);
    }

    //获取所有的仓库区域
    @Override
    public List<Map<String, Object>> getStoreRegion() {
        return inStoremapper.getStoreRegion();
    }

    //获取所有的仓位
    @Override
    public List<Map<String, Object>> getStorePosition() {
        return inStoremapper.getStorePosition();
    }

    //通过即将入库的订单货物代码查询在库货品中是否存在
    @Override
    public Map<String,Object> findByGoodcode(String goodcode){
        return inStoremapper.findByGoodcode(goodcode);
    }

    //将订单单单入库
    @Override
    public void goodInstore(Map<String, Object> map) {
        inStoremapper.goodInstore(map);
    }

    //将新的货品添加到在库货品中
    @Override
    public void goodAdd(Map<String, Object> map) {
        inStoremapper.goodAdd(map);
    }

    //通过货品名称查询出新增的在库货品信息
    @Override
    public Map<String, Object> findGoodBycode(String goodcode) {
        return inStoremapper.findGoodBycode(goodcode);
    }

    //若入库货品已经在库修改它的数量
    @Override
    public void updateGood(Map<String, Object> map) {
        inStoremapper.updateGood(map);
    }

    //订单入库之后,修改订单的状态为质检完成
    @Override
    public void checkOrderInstore(String orderid) {
        inStoremapper.checkOrderInstore(orderid);
    }

    //验收货物前通过订单号查询订单信息中的订单状态
    @Override
    public Map<String, Object> findOrderByid(String orderid) {
        return inStoremapper.findOrderByid(orderid);
    }

    //将订单状态更改为验收中
    @Override
    public void editOrderCheck(String orderid) {
        inStoremapper.editOrderCheck(orderid);
    }

    //将订单状态更改为已验收
    @Override
    public void checkOrdertrue(String orderid) {
        inStoremapper.checkOrdertrue(orderid);
    }

    //显示所有订单的验收记录
    @Override
    public List<Map<String, Object>> showGoodCheck() {
        return inStoremapper.showGoodCheck();
    }

    //通过goodcheckID查询出对应的验收记录信息
    @Override
    public Map<String, Object> findCheckgoodByid(String goodcheckid) {
        return inStoremapper.findCheckgoodByid(goodcheckid);
    }

    //当验收失败时,将订单状态更改为已到货
    @Override
    public void editOrderFail(String orderid) {
        inStoremapper.editOrderFail(orderid);
    }

    //将验收失败对应的记录删除
    @Override
    public void delGoodcheck(String goodcheckid) {
        inStoremapper.delGoodcheck(goodcheckid);
    }
}
