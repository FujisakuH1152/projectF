package jp.co.comnic.javalesson.projectf.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.ConvertUtils;
//import org.apache.commons.beanutils.Converter;
//import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.ConvertUtils;
//import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

//import jp.co.comnic.javalesson.projectf.controller.ControllerUtils.MainmessageConverter;
//import jp.co.comnic.javalesson.projectf.entity.Mainmessage;


//import jp.co.comnic.javalesson.projectf.entity.Account;

/**
 * <p> Entityの作成を行うクラス </p>
 * 
 * @author toda.shinnosuke
 *
 */



/**
 * <p> Entityの作成を行うクラス </p>
 * 
 * @author toda.shinnosuke
 *
 */
public class ControllerUtils {
	
	public static String getFullyQualifiedClassName(String servletPath) {

		String className = servletPath.substring(1, servletPath.lastIndexOf('/'));
		String packageName = "jp.co.comnic.javalesson.projectf.entity.";
		String firstCharacter = String.valueOf(className.charAt(0));
		firstCharacter = firstCharacter.toUpperCase();
	
		return packageName + className.replaceFirst(".", firstCharacter);
	}
	
	/**
	 * <p> リクエストパラメータを受け取りエンティティを生成しそれを返す </p>
	 * 
	 * @param request
	 * @param entity
	 */
	public static void createEntity(HttpServletRequest request, Object entity) {
		
		//リクエストパラメータをmapに格納
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		//<String, String>に変換
		Map<String, String> propertyMap = new HashMap<>();
		for(String key : parameterMap.keySet()) {
			propertyMap.put(key, parameterMap.get(key)[0]);
		}

		try {
			// 日付形式への対応
			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("yyyy-MM-dd HH:mm:ss");
						
			// コンバーターの登録
			ConvertUtils.register(dateConverter, java.util.Date.class);
//			ConvertUtils.register(new MainmessageConverter(), Mainmessage.class);
			
			// Apache Commons ProjectのBeanUtilsを使用して
			// Mapオブジェクトからエンティティ・オブジェクトへ値をセット
			BeanUtils.populate(entity, propertyMap);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private static class MainmessageConverter implements Converter {
//
//		@Override
//		public <T> T convert(Class<T> mainmessageClass, Object value) {
//			// TODO Auto-generated method stub
//			
//			T mainmessage = null;
//			
//			try {
//				
//				mainmessage = mainmessageClass.cast(new ) ;
//				
//			} catch {
//				
//			}
//			
//			return null;
//		}
//		
//	}
//	
	
	public static String getShortMessage(Throwable e) {

		String errorMessage = e.getCause().getMessage().split(":")[3];
		
		if (errorMessage.endsWith("Error Code")) {
			errorMessage = errorMessage.replaceAll("Error Code", "");
		}
		
		return errorMessage;
	}
	
	
}
