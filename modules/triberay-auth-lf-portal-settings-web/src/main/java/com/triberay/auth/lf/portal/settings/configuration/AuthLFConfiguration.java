package com.triberay.auth.lf.portal.settings.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Wouter Vernaillen
 */
@ExtendedObjectClassDefinition(category = "Triberay")
@Meta.OCD(
        id = "com.triberay.auth.lf.portal.settings.configuration.AuthLFConfiguration",
        localization = "content/Language",
        name = "auth-lf-configuration-name"
)
public interface AuthLFConfiguration {

    @Meta.AD(deflt = "authLFWidthFull", id = "width", name = "auth-lf-width", description = "auth-lf-width-description", required = false)
    public String width();

    @Meta.AD(deflt = "authLFAlignCenter", id = "align", name = "auth-lf-align", description = "auth-lf-align-description", required = false)
    public String align();

    @Meta.AD(deflt = "authLFButtonStyleFull", id = "buttonStyle", name = "auth-lf-buttonstyle", description = "auth-lf-buttonstyle-description", required = false)
    public String buttonStyle();

    @Meta.AD(deflt = "true", id = "showSignOut", name = "auth-lf-showSignOut", description = "auth-lf-showSignOut-description", required = false)
    public boolean showSignOut();
}