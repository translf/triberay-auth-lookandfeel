package com.triberay.auth.lf.configservice.internal;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.triberay.auth.lf.configservice.AuthLFConfigService;
import com.triberay.auth.lf.configservice.model.AuthLFConfig;
import com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants;
import com.triberay.auth.lf.portal.settings.configuration.AuthLFConfiguration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Wouter Vernaillen
 */
@Component(
        configurationPid = "AuthLFConfiguration",
        immediate = true, service = AuthLFConfigService.class
)
public class AuthLFConfigServiceImpl implements AuthLFConfigService {

    private ConfigurationProvider configurationProvider;

    @Reference
    protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
        this.configurationProvider = configurationProvider;
    }

    public AuthLFConfig getAuthLFConfig(long companyId) {
        AuthLFConfig config = new AuthLFConfig();
        AuthLFConfiguration authLFConfiguration = getAuthLFConfiguration(companyId);
        config.setWidth(authLFConfiguration.width());
        config.setAlign(authLFConfiguration.align());
        config.setButtonStyle(authLFConfiguration.buttonStyle());
        config.setShowSignOut(authLFConfiguration.showSignOut());
        return config;
    }

    public AuthLFConfiguration getAuthLFConfiguration(long companyId) {

        try {
            return configurationProvider.getConfiguration(
                    AuthLFConfiguration.class,
                    new CompanyServiceSettingsLocator(
                            companyId, PortalSettingsAuthLFConstants.SERVICE_NAME));
        }
        catch (ConfigurationException ce) {
            throw new SystemException(ce);
        }
    }
}
