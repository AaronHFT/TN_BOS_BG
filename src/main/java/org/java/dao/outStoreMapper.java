package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public  interface outStoreMapper {
public List<Map<String,Object>> orderAll();
    public List<Map<String,Object>> goodreachAll(Map<String, Object> m);
    public void insgoodreach(Map<String, Object> m);
    public List<Map<String,Object>> pickuplistAll();
    public void insgoodchange(Map<String, Object> m);
    public Map<String,Object>onegoodreach(Map<String, Object> m);
    public List<Map<String,Object>> goodchangeAll(Map<String, Object> m);
}
