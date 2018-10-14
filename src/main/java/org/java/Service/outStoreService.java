package org.java.service;


import java.util.List;
import java.util.Map;

public interface outStoreService {
    public List<Map<String,Object>> orderAll();
    public List<Map<String,Object>> goodreachAll(Map<String, Object> m);
    public void insgoodreach(Map<String, Object> m);
    public List<Map<String,Object>> pickuplistAll();
    public void insgoodchange(Map<String, Object> m);
    public Map<String,Object>onegoodreach(Map<String, Object> m);
    public List<Map<String,Object>> goodchangeAll(Map<String, Object> m);
}
