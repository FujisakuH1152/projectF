package jp.co.comnic.javalesson.projectf.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.projectf.dao.AccountDao;
import jp.co.comnic.javalesson.projectf.dao.DaoException;
import jp.co.comnic.javalesson.projectf.entity.Account;

/**
 * <p>
 * ログイン処理
 * </p>
 * 
 * @author toda.shinnosuke
 *
 */
public class LoginAction implements Action {

	/* (non-Javadoc)
	 * @see jp.co.cominc.javalesson.aaaaaprojectf.controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//各parameterを取得, forwordPathは後々設定		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String forwardPath = "login";
		
		try {
			// クライアント送られてきたメールアドレスとパスワードによる認証処理を????Daoに委譲し、
			//実行結果をAccoutoオブジェクトとして取得
			Account account = new AccountDao().loginAuthenticate(email, password);
			
			if(account != null) {
				// セッション管理を開始し、セッションのスコープ・オブジェクトとなるHttpSessionに
				// 認証済みを表すboolean値とログイン・ユーザー名をセット
				request.getSession().setAttribute("isAuthenticated", "AUTHENTICATED");
				request.getSession().setAttribute("loginUsername", account.getUsername());
				
				System.out.println(request.getServletPath());
				
				forwardPath = null;
				//ログイン後、ログイン画面遷移前のページへ遷移
//				response.sendRedirect(request.getRequestURI());
//				response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/" + request.getServletPath()); //---> /aaaaaprojectf/
				response.sendRedirect("/projectf/top.jsp");
				
			} else { //ログイン認証失敗処理 
				//ログイン失敗時のエラーメッセージ
				request.setAttribute("error", "Emailまたはパスワードに誤りがあります。"); 
			}
		} catch (DaoException e) {
			throw new ServletException(e);
		}
						
		// TODO Auto-generated method stub
		return forwardPath;
	}
	
	
}
