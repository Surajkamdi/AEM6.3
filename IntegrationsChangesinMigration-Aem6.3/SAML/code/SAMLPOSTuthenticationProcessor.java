package com.webapi.core.impl;

import java.io.IOException;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.auth.core.spi.AuthenticationInfo;
import org.apache.sling.auth.core.spi.AuthenticationInfoPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, metatype = false)
@Service
public class SAMLPOSTAuthenticationProcessor implements AuthenticationInfoPostProcessor {

	@Reference
	ResourceResolverFactory resolverFactory;
	private String loginUrl;
	

	@Activate
	protected void activate(Map<String, Object> properties) {
		if (properties.get("redirect.url") != null)
			loginUrl = properties.get("redirect.url").toString();
		 
	}

	@Override
	public void postProcess(AuthenticationInfo arg0, HttpServletRequest request, HttpServletResponse response)
			throws LoginException {
		
		response.sendredirect(login.url);
		 
	}

	 
	
}
