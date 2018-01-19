<%@ page import="com.triberay.auth.lf.portal.settings.configuration.AuthLFConfiguration" %><%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */com.liferay.portal.settings.web/
 */
--%>

<%@ include file="init.jsp" %>

<%
    AuthLFConfiguration authLFConfiguration = ConfigurationProviderUtil.getConfiguration(AuthLFConfiguration.class, new ParameterMapSettingsLocator(request.getParameterMap(), PortalSettingsAuthLFConstants.FORM_PARAMETER_NAMESPACE, new CompanyServiceSettingsLocator(company.getCompanyId(), PortalSettingsAuthLFConstants.SERVICE_NAME)));
    String authLFWidth = authLFConfiguration.width();
    String authLFAlign = authLFConfiguration.align();
    String authLFbuttonStyle = authLFConfiguration.buttonStyle();
    boolean showSignOut = authLFConfiguration.showSignOut();
%>

<img src="/o/portal-settings-auth-lf-web/images/triberay-logo-color.svg" class="triberay-logo-svg" height="50" style="float: left; padding-right: 10px;"/>
<liferay-ui:message key="auth-lf-intro"/><br/><br/>

<aui:fieldset>
    <aui:input name="<%= ActionRequest.ACTION_NAME %>" type="hidden" value="/portal_settings/authlf" />

    <aui:select label="auth-lf-width" name='<%= com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants.FORM_PARAMETER_NAMESPACE + "width" %>'>
        <aui:option value="authLFWidthFull" selected="<%=authLFWidth.equals("authLFWidthFull") %>"><liferay-ui:message key="auth-lf-width-authLFWidthFull"/></aui:option>
        <aui:option value="authLFWidthHalf" selected="<%=authLFWidth.equals("authLFWidthHalf") %>"><liferay-ui:message key="auth-lf-width-authLFWidthHalf"/></aui:option>
        <aui:option value="authLFWidth400" selected="<%=authLFWidth.equals("authLFWidth400") %>"><liferay-ui:message key="auth-lf-width-authLFWidth400"/></aui:option>
        <aui:option value="authLFWidth300" selected="<%=authLFWidth.equals("authLFWidth300") %>"><liferay-ui:message key="auth-lf-width-authLFWidth300"/></aui:option>
    </aui:select>

    <aui:select label="auth-lf-align" name='<%= com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants.FORM_PARAMETER_NAMESPACE + "align" %>'>
        <aui:option value="authLFAlignLeft" selected="<%=authLFAlign.equals("authLFAlignLeft") %>"><liferay-ui:message key="auth-lf-align-left"/></aui:option>
        <aui:option value="authLFAlignCenter" selected="<%=authLFAlign.equals("authLFAlignCenter") %>"><liferay-ui:message key="auth-lf-align-center"/></aui:option>
        <aui:option value="authLFAlignRight" selected="<%=authLFAlign.equals("authLFAlignRight") %>"><liferay-ui:message key="auth-lf-align-right"/></aui:option>
    </aui:select>

    <aui:select label="auth-lf-buttonstyle" name='<%= com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants.FORM_PARAMETER_NAMESPACE + "buttonStyle" %>'>
        <aui:option value="authLFButtonStyleFull" selected="<%=authLFbuttonStyle.equals("authLFButtonStyleFull") %>"><liferay-ui:message key="auth-lf-buttonstyle-full"/></aui:option>
        <aui:option value="authLFButtonStyleHalf" selected="<%=authLFbuttonStyle.equals("authLFButtonStyleHalf") %>"><liferay-ui:message key="auth-lf-buttonstyle-half"/></aui:option>
    </aui:select>

    <aui:input label="auth-lf-showSignOut" name='<%= com.triberay.auth.lf.portal.settings.authentication.web.internal.constants.PortalSettingsAuthLFConstants.FORM_PARAMETER_NAMESPACE + "showSignOut" %>' type="checkbox" value="<%= showSignOut %>" />

    <aui:button-row>
        <portlet:actionURL name="/portal_settings/authlf_delete" var="resetValuesURL">
            <portlet:param name="tabs1" value="authlf" />
        </portlet:actionURL>

        <%
            String taglibOnClick = "if (confirm('" + UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-reset-the-configured-values") + "')) {submitForm(document.hrefFm, '" + resetValuesURL.toString() + "');}";
        %>

        <aui:button cssClass="btn-lg" onClick="<%= taglibOnClick %>" value="reset-values" />
    </aui:button-row>
</aui:fieldset>
