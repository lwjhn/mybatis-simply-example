package com.rongji.egov.example.service.filter;

import com.rongji.egov.mybatis.dac.handler.AclBaseQueryHandler;
import com.rongji.egov.mybatis.web.interceptor.NormalInterceptor;

public class DefaultNormalInterceptor implements NormalInterceptor {
    @Override
    public AclBaseQueryHandler<?, ?> resolve(AclBaseQueryHandler<?, ?> aclBaseQueryHandler) {
        return aclBaseQueryHandler;
    }
}
