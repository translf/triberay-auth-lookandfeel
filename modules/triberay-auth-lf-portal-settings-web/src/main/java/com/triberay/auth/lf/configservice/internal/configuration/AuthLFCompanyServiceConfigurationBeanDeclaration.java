package com.triberay.auth.lf.configservice.internal.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.triberay.auth.lf.portal.settings.configuration.AuthLFConfiguration;
import org.osgi.service.component.annotations.Component;

/**
 * @author Wouter Vernaillen
 */
@Component
public class AuthLFCompanyServiceConfigurationBeanDeclaration
        implements ConfigurationBeanDeclaration {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return AuthLFConfiguration.class;
    }
}