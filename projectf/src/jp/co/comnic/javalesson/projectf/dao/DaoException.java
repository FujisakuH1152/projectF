package jp.co.comnic.javalesson.projectf.dao;


/**
 * 例外クラス
 * @author fujisaku.hayato
 * @author ver1.0α
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException(Exception e) {
		super("an exception occur in the DAO layer.", e);
	}
}
