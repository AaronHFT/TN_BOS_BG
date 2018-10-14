package org.java.service.impl;

import org.java.dao.GoodsMapper;
import org.java.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName BOS_Project
 * @ClassName GoodManageServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 下午 2:47
 * @Version 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Map<String, Object>> findAllGoodAccept() {
        List<Map<String,Object>> list=goodsMapper.findAllGoodAccept();
        return list;
    }

    @Override
    public List<Map<String, Object>> findAllGood() {
        List<Map<String,Object>> list=goodsMapper.findAllGood();
        return list;
    }

    @Override
    public void lvChange(Map<String, Object> map) {
        goodsMapper.lvChange(map);
    }

    @Override
    public List<Map<String,Object>> findGoodsDetail(Map<String, Object> map) {
        List<Map<String,Object>> list=goodsMapper.findGoodsDetail(map);
        return list;
    }

    @Override
    public List<Map<String, Object>> goodLine() {
        List<Map<String,Object>> list=goodsMapper.goodLine();
        return list;
    }

    @Override
    public List<Map<String, Object>> findGoodsDetailByInCode(Map<String, Object> map) {
        List<Map<String,Object>> list=goodsMapper.findGoodsDetailByInCode(map);
        return list;
    }

    @Override
    public void uselessOut(Map<String, Object> map) {
        goodsMapper.uselessOut(map);
    }

    @Override
    public void updateGoods(Map<String, Object> map) {
        goodsMapper.updateGoods(map);
    }

    @Override
    public List<Map<String, Object>> findGoodsForReturn() {
        return goodsMapper.findGoodsForReturn();
    }

    @Override
    public Map<String, Object> findGoodsForReturnByOrderId(Map<String, Object> map) {
        return goodsMapper.findGoodsForReturnByOrderId(map);
    }

    @Override
    public void createReturnOrder(Map<String, Object> map) {
        goodsMapper.createReturnOrder(map);
    }

    @Override
    public void createReturnHistoryForBad(Map<String, Object> map) {
        goodsMapper.createReturnHistoryForBad(map);
    }

    @Override
    public void updateGoodAcceptAfterReturn(Map<String, Object> map) {
        goodsMapper.updateGoodAcceptAfterReturn(map);
    }

    @Override
    public List<Map<String, Object>> findAllReturnOrder() {
        return goodsMapper.findAllReturnOrder();
    }

    @Override
    public List<Map<String, Object>> findCheckGoodAndHedgingNum() {
        return goodsMapper.findCheckGoodAndHedgingNum();
    }

    @Override
    public Map<String, Object> findGoodNumByLine(Map<String, Object> map) {
        return goodsMapper.findGoodNumByLine(map);
    }

    @Override
    public void createCheckGood(Map<String, Object> map) {
        goodsMapper.createCheckGood(map);
    }

    @Override
    public List<Map<String,Object>> findCheckGoodDetail(Map<String, Object> map) {
        return goodsMapper.findCheckGoodDetail(map);
    }

    @Override
    public List<Map<String, Object>> findCheckGoodDetailByLineAndDate(Map<String, Object> map) {
        return goodsMapper.findCheckGoodDetailByLineAndDate(map);
    }

    @Override
    public void updateCheckGoodByLineAndDate(Map<String, Object> map) {
        goodsMapper.updateCheckGoodByLineAndDate(map);
    }

    @Override
    public Map<String, Object> findGoodInStoreByLine(Map<String, Object> map) {
        return goodsMapper.findGoodInStoreByLine(map);
    }

    @Override
    public void checkGoodOutStore(Map<String, Object> map) {
        goodsMapper.checkGoodOutStore(map);
    }

    @Override
    public void updateCheckGoodState(Map<String, Object> map) {
        goodsMapper.updateCheckGoodState(map);
    }

    @Override
    public void updateGoodForCheck(Map<String, Object> map) {
        goodsMapper.updateGoodForCheck(map);
    }

    @Override
    public void unitTrans(Map<String, Object> map) {
        goodsMapper.unitTrans(map);
    }
}
