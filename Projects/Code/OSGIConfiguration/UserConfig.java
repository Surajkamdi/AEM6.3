package com.core.api.osgi.config;

import java.util.Dictionary;
import java.util.StringTokenizer;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(immediate = true, label = " user Profile Config",
description = " User Profile configuration", metatype = true)
@Properties({
@Property(name = Constants.SERVICE_DESCRIPTION,
		value = " user Profile Configuration"),
@Property(name = Constants.SERVICE_VENDOR, value = "") })
@Service(value = UserProfileConfig.class)
public class UserProfileConfig {
	
	private static Logger log=LoggerFactory.getLogger(UserProfileConfig.class);
	
	
	//partner properties
	
	@Property(label="Profile UID",description="User Profile UID",value="profile/uid")
	public static final String USER_PROFILE_UID="uid";
	
	
	@Property(label="Profile Email",description="User Profile email",value="profile/email")
	public static final String USER_PROFILE_EMAIL="email";
		
	
	/** The props. */
	private static Dictionary<?, ?> props = null;

	/**
	 * Returns parameter value as a Java object.
	 *
	 * @param key
	 *            - key value
	 * @return Value of param key.
	 */
	public static String getPropertyValue(String key) {

		return props.get(key)!=null?props.get(key).toString():null;

	}
	
	
	public static String[] getPropertyValues(String key) {
		if(props.get(key)==null)return null;
		StringTokenizer st=new StringTokenizer(props.get(key).toString(), ",");
		String[] properties=new String[st.countTokens()];
		for(int i=0;st.hasMoreTokens();i++){
			properties[i]=st.nextToken();
		}
		
		return properties;
	}
	
	protected void activate(ComponentContext context) {
		try {
			log.info(" User profile config activated ...");
			props = context.getProperties();
		} catch (Exception e) {
			log.error("Error occured in activate method", e);
		}
	}

	/**
	 * Update.
	 *
	 * @param context
	 *            the context
	 */
	@Modified
	protected void update(ComponentContext context) {
		props = context.getProperties();
	}
}
