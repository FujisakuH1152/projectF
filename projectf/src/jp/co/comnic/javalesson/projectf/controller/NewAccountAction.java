package jp.co.comnic.javalesson.projectf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.projectf.controller.ControllerUtils;
import jp.co.comnic.javalesson.projectf.dao.BaseDao;
import jp.co.comnic.javalesson.projectf.dao.DaoException;
;

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

		String forwardPath = "/projectf/top.jsp"; // 例外発生時のフォワード先（元の登録画面）
		
		try {
				Object entity = Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)).newInstance();
				ControllerUtils.createEntity(request, entity);
				new BaseDao().insert(entity);
				
				forwardPath = null;
				response.sendRedirect("/login");
				
		} catch (DaoException e) {
			request.setAttribute("error", "ERROR : " + ControllerUtils.getShortMessage(e));
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		return forwardPath;
	}
}
