package com.triberay.auth.lf.portal.settings.authentication.web.internal.portlet.action;

import com.liferay.portal.settings.web.portlet.action.PortalSettingsFormContributor;
import com.liferay.portal.settings.web.portlet.action.PortalSettingsParameterUtil;
import com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.util.Optional;

/**
 * @author Wouter Vernaillen
 */
@Component(immediate = true, service = PortalSettingsFormContributor.class)
public class AuthLFPortalSettingsFormContributor
        implements PortalSettingsFormContributor {

    @Override
    public Optional<String> getDeleteMVCActionCommandNameOptional() {
        return Optional.of("/portal_settings/authlf_delete");
    }

    @Override
    public String getParameterNamespace() {
        return PortalSettingsAuthLFConstants.FORM_PARAMETER_NAMESPACE;
    }

    @Override
    public Optional<String> getSaveMVCActionCommandNameOptional() {
        return Optional.of("/portal_settings/authlf");
    }

    @Override
    public String getSettingsId() {
        return PortalSettingsAuthLFConstants.SERVICE_NAME;
    }

    @Override
    public void validateForm(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        boolean authLFEnabled = PortalSettingsParameterUtil.getBoolean(
                actionRequest, this, "enabled");

        if (!authLFEnabled) {
            return;
        }
    }
}
