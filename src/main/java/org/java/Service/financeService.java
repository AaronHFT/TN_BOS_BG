package org.java.service;

import java.util.List;
import java.util.Map;

public interface financeService {
    public Map<String,Object> onefinance(Map<String, Object> h);
    public List<Map<String,Object>> getAll();
    public  void upd(Map<String, Object> h);
    public  List<Map<String,Object>> outAll();
    public  void outupd(Map<String, Object> h);
    public  List<Map<String,Object>> rkf(Map<String, Object> h);
    public List<Map<String,Object>> ckf(Map<String, Object> h);
    public  Map<String,Object> kjs(Map<String, Object> h);
    public  Map<String,Object> ddxx(Map<String, Object> h);
    public  List<Map<String,Object>> dd();
}
