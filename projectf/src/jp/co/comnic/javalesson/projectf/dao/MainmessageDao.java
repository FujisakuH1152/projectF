package jp.co.comnic.javalesson.projectf.dao;

/**
 * <p>メインメッセージ･テーブルの操作を実装するDAOクラス</p>
 * @author fujisaku.hayato
 * @author ver1.0α
 */
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.projectf.entity.Mainmessage;

public class MainmessageDao extends BaseDao {
	
	public MainmessageDao() throws DaoException {}
	
	private CriteriaQuery<Mainmessage> query = builder.createQuery(Mainmessage.class);
	private Root<Mainmessage> root = query.from(Mainmessage.class);
	
	public java.util.List<Mainmessage> findAll(){
		return super.findAll(query, root);
	}
	
}
