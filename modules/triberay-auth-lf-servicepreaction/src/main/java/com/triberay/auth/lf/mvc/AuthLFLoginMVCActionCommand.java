package com.triberay.auth.lf.mvc;

import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.triberay.auth.lf.configservice.AuthLFConfigService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + LoginPortletKeys.FAST_LOGIN,
                "javax.portlet.name=" + LoginPortletKeys.LOGIN,
                "mvc.command.name=/login/login",
                "service.ranking:Integer=100"
        },
        service = MVCActionCommand.class
)
public class AuthLFLoginMVCActionCommand extends AuthLFAbstractCommand implements MVCActionCommand {

    @Reference
    protected AuthLFConfigService authLFConfigService;

    @Reference(target =
            "(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCActionCommand)")
    protected MVCActionCommand mvcActionCommand;

    @Override
    public boolean processAction(
            ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

        setConfiguration(
                actionRequest,
                authLFConfigService.getAuthLFConfig(PortalUtil.getCompanyId(actionRequest)),
                true
        );

        return mvcActionCommand.processAction(actionRequest, actionResponse);
    }

}
