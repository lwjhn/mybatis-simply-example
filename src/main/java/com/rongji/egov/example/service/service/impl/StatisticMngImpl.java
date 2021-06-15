package com.rongji.egov.example.service.service.impl;

import com.rongji.egov.example.service.dao.StatisticDao;
import com.rongji.egov.example.service.service.StatisticMng;
import com.rongji.egov.mybatis.base.dao.BaseDao;
import com.rongji.egov.mybatis.base.model.SQLSelector;
import com.rongji.egov.mybatis.base.service.impl.BaseServiceImpl;
import com.rongji.egov.mybatis.base.utils.ModelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@Service
public class StatisticMngImpl extends BaseServiceImpl<HashMap<String, ?>> implements StatisticMng {
    @Resource
    StatisticDao statisticDao;


    private static void setQueryTable(SQLSelector query) {
        Objects.requireNonNull(query, "\nStatisticMngImpl:: The selectQuery must not be null");
        Objects.requireNonNull(query.getModel(), "\nStatisticMngImpl:: The selectQuery.mode(class) must not be null");
        query.setTable(ModelUtils.getTableName(query.getModel()));
    }

    @Override
    public BaseDao<HashMap<String, ?>> getBaseDao() {
        return statisticDao;
    }

    @Override
    public void preproccess(SQLSelector query) {
        setQueryTable(query);
    }
}
