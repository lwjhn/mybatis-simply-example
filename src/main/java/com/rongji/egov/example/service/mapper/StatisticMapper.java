package com.rongji.egov.example.service.mapper;

import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

@Mapper
public interface StatisticMapper extends BaseMapper<HashMap<String, ?>>{

}
