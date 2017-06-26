package jp.co.cominc.javalesson.projectf.controller;

/**
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

}
