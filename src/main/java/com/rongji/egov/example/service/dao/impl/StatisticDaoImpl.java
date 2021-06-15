package com.rongji.egov.example.service.dao.impl;

import com.rongji.egov.example.service.dao.StatisticDao;
import com.rongji.egov.example.service.mapper.StatisticMapper;
import com.rongji.egov.mybatis.base.dao.impl.BaseDaoImpl;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;

@Repository
public class StatisticDaoImpl extends BaseDaoImpl<HashMap<String, ?>> implements StatisticDao {
    @Resource
    StatisticMapper statisticMapper;

    @Override
    public BaseMapper<HashMap<String, ?>> getMapper() {
        return (BaseMapper<HashMap<String, ?>>) statisticMapper;
    }
}
