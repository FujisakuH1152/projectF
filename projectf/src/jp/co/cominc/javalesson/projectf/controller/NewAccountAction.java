package jp.co.cominc.javalesson.projectf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.webapp.ems.controller.ControllerUtils;
import jp.co.comnic.javalesson.webapp.ems.dao.BaseDao;

/**
 * <p> .新規アカウント追加処理を実行するActionインターフェイスの実装 </p>
 * 
 * @author toda.shinnosuke
 *
 */
public class NewAccountAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String servletPath = request.getServletPath();
		
		try {
				Object entity = Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)).newInstance();
			
				
				new BaseDao().insert(entity);
		} catch {
			
		}
		
		return null;
	}
	

}
