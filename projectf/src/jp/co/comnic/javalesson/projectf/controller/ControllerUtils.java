package jp.co.comnic.javalesson.projectf.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import org.apache.commons.beanutils.converters.DateConverter;

import jp.co.comnic.javalesson.projectf.dao.AccountDao;
import jp.co.comnic.javalesson.projectf.dao.CategoryDao;
import jp.co.comnic.javalesson.projectf.dao.DaoException;
import jp.co.comnic.javalesson.projectf.dao.MainmessageDao;
import jp.co.comnic.javalesson.projectf.entity.Account;
import jp.co.comnic.javalesson.projectf.entity.Category;
import jp.co.comnic.javalesson.projectf.entity.Mainmessage;
import jp.co.comnic.javalesson.projectf.entity.Submessage;

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
			System.out.println(propertyMap.put(key, parameterMap.get(key)[0]));
		}

		try {
			// 日付形式への対応
			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("yyyy-MM-dd");
			
			// コンバーターの登録
			ConvertUtils.register(dateConverter, java.util.Date.class);
			ConvertUtils.register(new CategoryConverter(), Category.class);
			ConvertUtils.register(new AccountConverter(), Account.class);
			ConvertUtils.register(new SubMessageConverter(), Submessage.class);
			ConvertUtils.register(new MainmessageConverter(), Mainmessage.class);
			

			
			// Apache Commons ProjectのBeanUtilsを使用して
			// Mapオブジェクトからエンティティ・オブジェクトへ値をセット
			BeanUtils.populate(entity, propertyMap);
			
			System.out.println("conveterrrrrrrrrrrrr : ");
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class MainmessageConverter implements Converter {

		@Override
		public <T> T convert(Class<T> mainmessageClass, Object value) {
			// TODO Auto-generated method stub
			
		
			
			T mainmessage = null;
			
			try {
				
				mainmessage = mainmessageClass.cast(new MainmessageDao().findById(Integer.parseInt((String) value)));
				
			} catch (NumberFormatException | DaoException e){
				e.printStackTrace();
			}
			
			return mainmessage;
		}
	}
	
	private static class CategoryConverter implements Converter {

		@Override
		public <T> T convert(Class<T> categoryClass, Object value) {
			// TODO Auto-generated method stub
			
			T category = null;
			
			try {
				
				category = categoryClass.cast(new CategoryDao().findById(Integer.parseInt((String) value)));
				System.out.println("converter : " + value);
				
			} catch (NumberFormatException | DaoException e){
				e.printStackTrace();
			}
			
			return category;
		}
	}
	
	private static class AccountConverter implements Converter {

		@Override
		public <T> T convert(Class<T> accountClass, Object value) {
			// TODO Auto-generated method stub
			
			System.out.println("AccountConverter value is " + value);
			
			T account = null;
			
			try {
				
				account = accountClass.cast(new AccountDao().findById((String)value));
				
			} catch (NumberFormatException | DaoException e){
				e.printStackTrace();
			}
			
			return account;
		}
		
	}
	
	private static class SubMessageConverter implements Converter {

		@Override
		public <T> T convert(Class<T> submessageClass, Object value) {
			// TODO Auto-generated method stub
			
			System.out.println("AccountConverter value is " + value);
			
			T submessage = null;
			
			try {
				
				submessage = submessageClass.cast(new AccountDao().findById((String)value));
				
			} catch (NumberFormatException | DaoException e){
				e.printStackTrace();
			}
			
			return submessage;
		}
		
	}
	
	public static String getShortMessage(Throwable e) {

		String errorMessage = e.getCause().getMessage().split(":")[3];
		
		if (errorMessage.endsWith("Error Code")) {
			errorMessage = errorMessage.replaceAll("Error Code", "入力されていない項目があります。");
		}
		
		return errorMessage;
	}
	
	
}
