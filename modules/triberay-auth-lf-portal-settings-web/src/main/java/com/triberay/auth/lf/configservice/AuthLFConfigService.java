package com.triberay.auth.lf.configservice;

import com.triberay.auth.lf.configservice.model.AuthLFConfig;

/**
 * @author Wouter Vernaillen
 */
public interface AuthLFConfigService {

    public AuthLFConfig getAuthLFConfig(long companyId);
}
