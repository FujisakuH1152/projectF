package jp.co.cominc.javalesson.projectf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> .ログアウト認証処理を実行するクラス </p>
 * 
 * @author toda.shinnosuke
 *
 */
public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getSession().invalidate(); //セッションの切断
		response.sendRedirect(request.getRequestURI()); //ログアウト処理を実行したページへ遷移
		
		return null;
	}

}
