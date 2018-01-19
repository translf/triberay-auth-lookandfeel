package com.triberay.auth.lf.portal.settings.authentication.web.internal.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseJSPDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;

/**
 * @author Wouter Vernaillen
 */
@Component(
        immediate = true,
        property = {"portal.settings.authentication.tabs.name=Look & Feel"},
        service = DynamicInclude.class
)
public class PortalSettingsAuthLFDynamicInclude
        extends BaseJSPDynamicInclude {

    @Override
    protected String getJspPath() {
        return "/com.liferay.portal.settings.web/authlookandfeel.jsp";
    }

    @Override
    protected Log getLog() {
        return LOGGER;
    }

    @Override
    @Reference(
            target = "(osgi.web.symbolicname=com.triberay.auth.lf.portal.settings.web)",
            unbind = "-"
    )
    protected void setServletContext(ServletContext servletContext) {
        super.setServletContext(servletContext);
    }

    private static final Log LOGGER = LogFactoryUtil.getLog(
            PortalSettingsAuthLFDynamicInclude.class);

}
