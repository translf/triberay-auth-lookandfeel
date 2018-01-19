package com.triberay.auth.lf.mvc;

import com.triberay.auth.lf.configservice.model.AuthLFConfig;

import javax.portlet.PortletRequest;

/**
 * @author Wouter Vernaillen
 */
public abstract class AuthLFAbstractCommand {

    protected void setConfiguration(PortletRequest request, AuthLFConfig config, boolean isEmailLogin) {

        request.setAttribute("isEmailLogin", isEmailLogin);
        request.setAttribute("authLFConfig", config);
    }
}
