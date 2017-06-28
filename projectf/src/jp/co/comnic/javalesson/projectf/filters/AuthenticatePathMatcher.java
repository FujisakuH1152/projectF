package jp.co.comnic.javalesson.projectf.filters;

/**
 * <p>ログイン認証のフィルターで使用されるパス・マッチャー</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class AuthenticatePathMatcher {

	public static boolean matches(String path) {

		if (path.matches("/signInSub.*") || 
		    path.matches(".*(.css)|(.js)|(.gif)|(.png)|(.jpg)")) {

			return true;
		}
		
		return false;
	}
}

