package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public  interface outStoreMapper {
public List<Map<String,Object>> orderAll();
public void insgoodsent(Map<String,Object> h);
public List<Map<String,Object>> goodsentAll();
public  void insgoodchange(Map<String,Object> h);
    public  void insgoodchange2(Map<String,Object> h);
    public List<Map<String,Object>> goodchangeAll();
    public  void pickUpListins(Map<String,Object> h);
    public  List<Map<String,Object>> pickUpListAll();
    public List<Map<String,Object>> goodreachAll();
    public  List<Map<String,Object>> goodChange1(Map<String,Object> h);
    public  List<Map<String,Object>> goodchange2All(Map<String,Object> h);
    public  void goodupd(Map<String,Object> h);
}
