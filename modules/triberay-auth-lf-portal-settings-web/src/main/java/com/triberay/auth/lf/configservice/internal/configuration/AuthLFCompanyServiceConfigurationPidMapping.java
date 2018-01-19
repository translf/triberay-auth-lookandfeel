package com.triberay.auth.lf.configservice.internal.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants;
import com.triberay.auth.lf.portal.settings.configuration.AuthLFConfiguration;
import org.osgi.service.component.annotations.Component;

/**
 * @author Wouter Vernaillen
 */
@Component
public class AuthLFCompanyServiceConfigurationPidMapping
        implements ConfigurationPidMapping {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return AuthLFConfiguration.class;
    }

    @Override
    public String getConfigurationPid() {
        return PortalSettingsAuthLFConstants.SERVICE_NAME;
    }

}