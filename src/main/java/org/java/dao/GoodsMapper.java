package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName BOS_Project
 * @ClassName GoodManageMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 下午 2:10
 * @Version 1.0
 **/
@Mapper
public interface GoodsMapper {
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

    public List<Map<String,Object>> findCheckGoodAndHedgingNum();

    public Map<String,Object> findGoodNumByLine(Map<String,Object> map);

    public void createCheckGood(Map<String,Object> map);

    public List<Map<String,Object>> findCheckGoodDetail(Map<String,Object> map);

    public List<Map<String,Object>> findCheckGoodDetailByLineAndDate(Map<String,Object> map);

    public void updateCheckGoodByLineAndDate(Map<String,Object> map);

    public Map<String,Object> findGoodInStoreByLine(Map<String,Object> map);

    public void checkGoodOutStore(Map<String,Object> map);

    public void checkGoodInStore(Map<String,Object> map);

    public void updateCheckGoodState(Map<String,Object> map);

    public void updateGoodForCheck(Map<String,Object> map);

    public void unitTrans(Map<String,Object> map);
}
