package jp.co.comnic.javalesson.projectf.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProjectfFrontControllerServlet
 */
@WebServlet("*.do")
public class ProjectfFrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// リクエストURLから適切なActionオブジェクト(ビジネス・ロジックの実行をカプセル化するオブジェクト)を取得
		Action action = ActionFactory.getAction(request.getServletPath());
		// Actionを実行して、転送先Viewのパスを取得
		String forwardPath = action.execute(request, response);
		
		// Actionの実装先でsendRedirectが実行されている場合にはレスポンスがすでに返送されているためnullが返る
		if (forwardPath != null) { // レスポンスがまだ返送されていなければ
			// 適切なViewに転送
			request.getRequestDispatcher(forwardPath).forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(request, response);
	}

}

