package com.ih.azuread.ad.security.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;

public class CommonUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	
	private CommonUtils() {
		
	}
	
	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String getJson(Object obj) {
		return getJson(obj, false);
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		Gson gson = getGson(false);
		return gson.fromJson(json, clazz);
	}
	
	public static String getJson(Object obj, boolean prettyPrint) {
		Gson gson = getGson(prettyPrint);
		return gson.toJson(obj, obj.getClass());
	}
	
	public static String getRequestHeaderValueAsString(String headerName) {
		String authHeader = null;
		Boolean authFlag = false;
		try {
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes();
			authHeader = servletRequestAttributes.getRequest().getHeader(headerName);

			return authHeader;
		} catch (IllegalStateException e) {
			logger.error("Error getting header [{}].", headerName, e);
			authFlag = true;
		}
		catch(Exception e) {
			logger.error("Error getting header [{}].", headerName, e);
			
		}
		/*
		 * if (authFlag) { authHeader = AuthorizationContext.getCurrentAuthorization();
		 * }
		 */
		return authHeader;
	}
	
	public static String getAuthorizationHeaderValue() {
		//return getRequestHeaderValueAsString("Authorization");
		return getRequestHeaderValueAsString("X-AUTH-TOKEN");
		
	}
	public static String getAuthorizationToken() {
		return getRequestHeaderValueAsString("Authorization");
	}
	
	private static Gson getGson(boolean prettyPrint) {
		GsonBuilder b = new GsonBuilder();
		if(prettyPrint) {
			b.setPrettyPrinting();
		}
		
		return b.create();
	}
}
