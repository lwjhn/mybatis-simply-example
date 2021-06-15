package com.rongji.egov.example.service.controller;

import com.rongji.egov.example.service.service.StatisticMng;
import com.rongji.egov.mybatis.base.model.SQLSelector;
import com.rongji.egov.mybatis.base.utils.ModelUtils;
import com.rongji.egov.utils.api.paging.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/example")
public class StatisticController {
    private static final String MODEL_PACKAGE = StatisticController.class.getPackage().getName().replaceAll("\\.[^.]*$", "") + ".model.";
    @Resource
    StatisticMng statisticMng;

    @PostMapping("/statistic/query/{class}")
    public List<?> query(@PathVariable(value = "class") String clazz, @RequestBody SQLSelector query) {
        query.setModel(ModelUtils.loadClass(MODEL_PACKAGE + clazz));
        return statisticMng.query(query);
    }

    @PostMapping("/statistic/queries/{class}")
    public List<?> query(@PathVariable(value = "class") String clazz, @RequestBody List<SQLSelector> queries) {
        Class<?> model = ModelUtils.loadClass(MODEL_PACKAGE + clazz);
        List<List<HashMap<String, ?>>> result = new ArrayList<>();
        for (SQLSelector query : queries) {
            query.setModel(model);
            result.add(statisticMng.query(query));
        }
        return result;
    }

    @PostMapping("/statistic/queryCount/{class}")
    public Long queryCount(@PathVariable(value = "class") String clazz, @RequestBody SQLSelector query) {
        query.setModel(ModelUtils.loadClass(MODEL_PACKAGE + clazz));
        return statisticMng.queryCount(query);
    }

    @PostMapping("/statistic/queryPage/{class}")
    public Page<?> queryPage(@PathVariable(value = "class") String clazz, @RequestBody SQLSelector query) {
        query.setModel(ModelUtils.loadClass(MODEL_PACKAGE + clazz));
        return statisticMng.queryPage(query);
    }
}
