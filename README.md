# Triberay Authentication Look & Feel

<a href="https://travis-ci.org/triberay/triberay-auth-lookandfeel"><img src="https://api.travis-ci.org/triberay/triberay-auth-lookandfeel.svg?branch=master" alt="Travis CI" /></a>

## Description

A sharper look & feel for the Liferay login, including recognisable social media login buttons.

## Screenshot

![auth look & feel screenshot](https://raw.githubusercontent.com/triberay/triberay-auth-lookandfeel/master/screenshots/authlookandfeel.png)

## Setup

This project is set up as a [Liferay Workspace](https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/liferay-workspace) to make it easier to handle the separate OSGi modules.

## Modules

Bundles:
  * [Portal Settings Web](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-portal-settings-web):
     Adds a "Look & Feel" tab to the Authentication section in the Portal Settings of each Liferay instance.
  * [ServicePreAction](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-servicepreaction):
     Makes the configuration available to the (standard) Liferay login portlet.
  * [Theme Contributor](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-themecontributor):
     Injects our css into the theme, no matter which theme is in use.
  
Fragments:
  * [Facebook Connect Web Modification](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-facebook-connect-web)
  * [Google Web Modification](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-google-web)
  * [Login JSP Hook](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-jsp-hook)
  * [OpenId Web Modification](https://github.com/triberay/triberay-auth-lookandfeel/tree/master/modules/triberay-auth-lf-openid-web)
  
