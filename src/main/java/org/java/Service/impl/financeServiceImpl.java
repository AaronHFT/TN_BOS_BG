package org.java.Service.impl;

import org.java.Service.financeService;
import org.java.dao.financeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class financeServiceImpl implements financeService {
    @Autowired
    private financeMapper f;
    @Override
    public HashMap<String, Object> onefinance(HashMap<String, Object> h) {
        System.out.print(f.onefinance(h));
        return f.onefinance(h);
    }

    @Override
    public List<HashMap<String, Object>> getAll() {
        return f.getAll();
    }

    @Override
    public void upd(HashMap<String, Object> h) {
        f.upd(h);
    }

    @Override
    public List<HashMap<String, Object>> outAll() {
        return f.outAll();
    }

    @Override
    public void outupd(HashMap<String, Object> h) {
        f.outupd(h);
    }
}
