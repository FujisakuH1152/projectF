package jp.co.cominc.javalesson.projectf.controller;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * <p>
 * Actionクラスの実装とそのインスタンスを生成して返す
 * </p>
 * 
 * @author toda.shinnosuke
 *
 */
@WebListener // リスナーの登録
public class ActionFactory implements ServletContextListener {

	private static ServletContext context;

	/**
	 * <p>
	 * クライアントのリクエストパスを受け取り
	 * </p>
	 * <p>
	 * リクエストパスとActionクラスの対応付けはweb.xmlファイルにて context-paramタグを使用して設定
	 * </p>
	 * <p>
	 * ServletContxtオブジェクトのgetInitParameterメソッドを使用して取得する
	 * </p>
	 * 
	 * @param servletPath
	 *            (request path)
	 * @return Action
	 * @throws ServletException
	 */
	public static Action getAction(String servletPath) throws ServletException {

		Action action = null;

		System.out.println(servletPath);

		// 引数として渡されたservletPathに対応するActionクラスの実装名を取得
		String actionClassName = context.getInitParameter(servletPath);

		System.out.println(actionClassName);
		try {
			// 取得したActionクラスの実装名からインスタンスを取得
			action = (Action) Class.forName(actionClassName).newInstance();
		} catch (Exception e) {
			throw new ServletException(e);
		}

		// 生成したActionクラスの実装名のインスタンスを返す
		return action;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	// Webアプリケーションが初期化処理を開始したことを通知
	// contextInitializedメソッドはコンテナの起動時自動的に呼び出される
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		// コンテナ起動時にServletContextオブジェクトを受け取ってフィールドにセット
		context = sce.getServletContext();
	}
}
