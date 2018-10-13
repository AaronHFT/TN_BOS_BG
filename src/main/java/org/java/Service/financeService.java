package org.java.Service;

import java.util.HashMap;
import java.util.List;

public interface financeService {
    public HashMap<String,Object> onefinance(HashMap<String, Object> h);
    public List<HashMap<String,Object>> getAll();
    public  void upd(HashMap<String, Object> h);
    public  List<HashMap<String,Object>> outAll();
    public  void outupd(HashMap<String, Object> h);
    public  List<HashMap<String,Object>> rkf(HashMap<String,Object>h);
    public List<HashMap<String,Object>> ckf(HashMap<String,Object>h);
    public  HashMap<String,Object> kjs(HashMap<String,Object>h);
    public  HashMap<String,Object> ddxx(HashMap<String,Object>h);
    public  List<HashMap<String,Object>> dd();
}
