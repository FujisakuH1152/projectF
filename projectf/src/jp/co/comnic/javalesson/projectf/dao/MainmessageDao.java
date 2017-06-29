package jp.co.comnic.javalesson.projectf.dao;


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
	public Mainmessage findById(Integer id) {
		return super.findById(Mainmessage.class, id);
	}
}
