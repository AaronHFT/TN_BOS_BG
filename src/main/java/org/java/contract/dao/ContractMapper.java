package org.java.contract.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName tn_bos_background
 * @ClassName ContractMapper
 * @Description TODO
 * @Author Trouble
 * @Date 2018/10/10 10:15
 * @Version 1.0
 **/
@Mapper
public interface ContractMapper {
    //查询所有合同
    List<Map<String,Object>> showAllContract();

    //新建一个合同
    void createContract(Map<String,Object> map);

    //根据Id删除合同
    void delContById(Map<String,Object> map);

    //获得所有合同类型
    List<Map<String,Object>> getAllContType();

    //合同编辑-保存
    void saveContract(Map<String,Object> map);

    //更改合同状态
    void updContState(Map<String,Object> map);
}
