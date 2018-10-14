package org.java.service;

import java.util.List;
import java.util.Map;

public interface InStoreService {

    public void createCheckreach(Map<String,Object> map);

    public List<Map<String,Object>> getInStoreTypes();

    public List<Map<String,Object>> getstorelist();

    public List<Map<String,Object>> checkStore();

    public void editorder(String orderid);

    public Map<String,Object> getGoodinfo(String gid);

    public void createPlanorder(Map<String,Object> map);

    public void createCheckGood(Map<String,Object> map);

    public void createGoodAccept(Map<String,Object> map);

    public List<Map<String,Object>> showStores();

    public List<Map<String,Object>> checkPlan();

    public void checkStoretrue(String orderid);

    public void editOrderPlan(String orderid);

    public List<Map<String,Object>> showAllcheckOrder();

    public Map<String,Object> getOrderinfo(String orderid);

    public List<Map<String,Object>> getStoreRegion();

    public List<Map<String,Object>> getStorePosition();

    public Map<String,Object> findByGoodcode(String goodcode);

    public void goodInstore(Map<String,Object> map);

    public void goodAdd(Map<String,Object> map);

    public Map<String,Object> findGoodBycode(String goodcode);

    public void updateGood(Map<String,Object> map);

    public void checkOrderInstore(String orderid);

    public Map<String,Object> findOrderByid(String orderid);

    public void editOrderCheck(String orderid);

    public void checkOrdertrue(String orderid);

    public List<Map<String,Object>> showGoodCheck();

    public Map<String,Object> findCheckgoodByid(String goodcheckid);

    public void editOrderFail(String orderid);

    public void delGoodcheck(String goodcheckid);

    public Map<String,Object> searchOrderinfo(String orderid);

    public Map<String,Object> getgoodreachinfo(String orderid);

    public List<Map<String,Object>> showArriveGood();

    public List<Map<String,Object>> showGoodChecked();

    public Map<String,Object> acceptGood(String orderid);

    public Map<String,Object> IsChecked(Map<String,Object> map);

    public void editOrderAccept(String orderid);
}
