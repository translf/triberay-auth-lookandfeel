package com.triberay.auth.lf.actions;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.util.PortalUtil;
import com.triberay.auth.lf.configservice.AuthLFConfigService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wouter Vernaillen
 */
@Component(
        immediate = true, property = {"key=servlet.service.events.pre"},
        service = LifecycleAction.class
)
public class LoginConfigServicePreAction implements LifecycleAction {

    @Reference
    private AuthLFConfigService authLFConfigService;

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
            throws ActionException {

        HttpServletRequest request = lifecycleEvent.getRequest();
        long companyId = PortalUtil.getCompanyId(request);

        request.setAttribute("authLFConfig", authLFConfigService.getAuthLFConfig(companyId));
    }

}