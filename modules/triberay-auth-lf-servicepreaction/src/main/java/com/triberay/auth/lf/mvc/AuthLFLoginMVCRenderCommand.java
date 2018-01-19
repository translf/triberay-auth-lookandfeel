package com.triberay.auth.lf.mvc;

import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.triberay.auth.lf.configservice.AuthLFConfigService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Wouter Vernaillen
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + LoginPortletKeys.LOGIN,
                "mvc.command.name=/login/login",
                "service.ranking:Integer=100"
        },
        service = MVCRenderCommand.class
)
public class AuthLFLoginMVCRenderCommand extends AuthLFAbstractCommand implements MVCRenderCommand {

    @Reference
    protected AuthLFConfigService authLFConfigService;

    @Reference(target =
            "(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCRenderCommand)")
    protected MVCRenderCommand mvcRenderCommand;

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        setConfiguration(
                renderRequest,
                authLFConfigService.getAuthLFConfig(PortalUtil.getCompanyId(renderRequest)),
                true
                );

        return mvcRenderCommand.render(renderRequest, renderResponse);
    }
}
