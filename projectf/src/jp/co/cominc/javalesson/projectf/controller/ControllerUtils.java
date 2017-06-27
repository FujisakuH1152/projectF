package jp.co.cominc.javalesson.projectf.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 * <p> Entityの作成を行うクラス </p>
 * 
 * @author toda.shinnosuke
 *
 */
public class ControllerUtils {
	
	public static String getFullyQualifiedClassName(String servletPath) {
		
		String className = servletPath.substring(1, servletPath.lastIndexOf('/'));
		String packageName = "jp.comnic.javalesson.projectf.entity.";
		String firstCharacter = String.valueOf(className.charAt(0));
		firstCharacter = firstCharacter.toUpperCase();
	
		
		return packageName + className.replaceFirst(".", firstCharacter);
		
	}
	
	public static void createEntity(HttpServletRequest request, Object entity) {
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		//cast
		Map<String, String> propertyMap = new HashMap<>();
		for(String key : parameterMap.keySet()){
			propertyMap.put(key, parameterMap.get(key)[0]);
		}

		BeanUtils.populate(entity, propertyMap);

	}
	
	public static String getShortMessage(Throwable e) {

		String errorMessage = e.getCause().getMessage().split(":")[3];
		
		if (errorMessage.endsWith("Error Code")) {
			errorMessage = errorMessage.replaceAll("Error Code", "");
		}
		
		return errorMessage;
	}
}