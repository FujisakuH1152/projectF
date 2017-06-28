package jp.co.comnic.javalesson.projectf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.projectf.dao.BaseDao;
import jp.co.comnic.javalesson.projectf.dao.DaoException;

/**
 * <p> 新規投稿を行うクラス </p>
 * 
 * @author toda.shinnosuke
 *
 */
public class NewSubMessageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = "/Submessage/";

		String forwardPath = "top.jsp"; // 例外発生時のフォワード先（元の登録画面）

		try {
			
			// リクエスト・パス文字列から空のエンティティ・オブジェクトを生成(MainmessageEntity)
			Object entity = Class.forName(ControllerUtils.getFullyQualifiedClassName(str)).newInstance();
			
			// リクエスト・パラメータの値を使用してエンティティ・オブジェクトのフィールド値を設定
			ControllerUtils.createEntity(request, entity);
			new BaseDao().insert(entity);

			forwardPath = null;
			response.sendRedirect("top.jsp");

		} catch (DaoException e) {
			request.setAttribute("error", "ERROR : " + ControllerUtils.getShortMessage(e));
		} catch (Exception e) {
			throw new ServletException(e);
		}

		return forwardPath;
	}

}
