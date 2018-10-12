package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName BOS_Project
 * @ClassName GoodManageService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 下午 2:47
 * @Version 1.0
 **/
public interface GoodsService {

    public List<Map<String,Object>> findAllGoodAccept();

    public List<Map<String,Object>> findAllGood();

    public void lvChange(Map<String,Object> map);

    public List<Map<String,Object>> findGoodsDetail(Map<String,Object> map);

    public List<Map<String,Object>> goodLine();

    public List<Map<String,Object>> findGoodsDetailByInCode(Map<String,Object> map);

    public void uselessOut(Map<String,Object> map);

    public void updateGoods(Map<String,Object> map);

    public List<Map<String,Object>> findGoodsForReturn();

    public Map<String,Object> findGoodsForReturnByOrderId(Map<String,Object> map);

    public void createReturnOrder(Map<String,Object> map);

    public void createReturnHistoryForBad(Map<String,Object> map);

    public void updateGoodAcceptAfterReturn(Map<String,Object> map);

    public List<Map<String,Object>> findAllReturnOrder();
}
