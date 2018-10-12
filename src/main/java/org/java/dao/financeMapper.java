package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface financeMapper {
    public HashMap<String,Object> onefinance(HashMap<String,Object>h);
    public List<HashMap<String,Object>>getAll();
    public  void upd(HashMap<String,Object>h);
    public   List<HashMap<String,Object>> outAll();
    public  void outupd(HashMap<String,Object>h);
}
