package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public  interface outStoreMapper {
public List<HashMap<String,Object>> orderAll();
public void insgoodsent(HashMap<String,Object>h);
public List<HashMap<String,Object>> goodsentAll();
public  void insgoodchange(HashMap<String,Object>h);
    public  void insgoodchange2(HashMap<String,Object>h);
    public List<HashMap<String,Object>> goodchangeAll();
    public  void pickUpListins(HashMap<String,Object>h);
    public  List<HashMap<String,Object>> pickUpListAll();
    public List<HashMap<String,Object>> goodreachAll();
    public  List<HashMap<String,Object>> goodChange1(HashMap<String,Object>h);
    public  List<HashMap<String,Object>> goodchange2All(HashMap<String,Object>h);
    public  void goodupd(HashMap<String,Object>h);
}
