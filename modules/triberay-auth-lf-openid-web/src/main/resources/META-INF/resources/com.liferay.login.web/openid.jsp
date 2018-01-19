<%--
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
 */
--%>

<%@ include file="/com.liferay.login.web/init.jsp" %>

<%
    String openId = ParamUtil.getString(request, "openId");
%>

<portlet:actionURL var="openIdURL">
    <portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="/login/openid" />
</portlet:actionURL>

<%-- /**  Start modification by Triberay */ --%>
<div class="panel-group login-panel-container openid" id="sreb">
    <div class="panel panel-default lfr-panel lfr-panel-extended" id="mfqc">
        <div class="panel-heading toggler-header toggler-header-expanded" data-persist-id="mfqc">
            <div class="panel-toggle"> <img src="<%= themeDisplay.getPathThemeImages() + "/common/openid.gif" %>" alt=""> <span class="title-text"> OpenID </span></div>
        </div>
        <div class="toggler-content-wrapper">
            <div class="toggler-content toggler-content-expanded" id="mfqcContent">
                <div class="panel-body">
<%-- /**  End modification */ --%>

<aui:form action="<%= openIdURL %>" method="post" name="fm">
    <aui:input name="saveLastPath" type="hidden" value="<%= false %>" />

    <liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-openid-already-exists" />
    <liferay-ui:error exception="<%= OpenIdServiceException.AssociationException.class %>" message="an-error-occurred-while-establishing-an-association-with-the-openid-provider" />
    <liferay-ui:error exception="<%= OpenIdServiceException.ConsumerException.class %>" message="an-error-occurred-while-initializing-the-openid-consumer" />
    <liferay-ui:error exception="<%= OpenIdServiceException.DiscoveryException.class %>" message="an-error-occurred-while-discovering-the-openid-provider" />
    <liferay-ui:error exception="<%= OpenIdServiceException.MessageException.class %>" message="an-error-occurred-while-communicating-with-the-openid-provider" />
    <liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-associated-with-your-openid-account-is-already-being-used" />

    <aui:fieldset>
        <aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" cssClass="openid-login" label="openid" name="openId" title="openid" type="text" value="<%= openId %>" />

        <aui:button-row>
            <aui:button type="submit" value="sign-in" />
        </aui:button-row>
    </aui:fieldset>
</aui:form>

<%-- /**  Start modification by Triberay */ --%>
                </div>
            </div>
        </div>
    </div>
</div>
<%-- /**  End modification */ --%>