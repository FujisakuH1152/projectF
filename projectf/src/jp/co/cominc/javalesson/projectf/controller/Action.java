package jp.co.cominc.javalesson.projectf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> ActionFactoryクラスの実装のためのインターフェース </p>
 * 
 * @author toda.shinnosuke
 *
 */
public interface Action {
	
	

	/**
	 * 
	 * 
	 * @param request HTTPRequestObject
	 * @param reponse HTTPResponseObject
	 * @return 遷移パス(ActionFactoryクラスでReturn)
	 * @throws ServletException
	 * @throws IOException
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
