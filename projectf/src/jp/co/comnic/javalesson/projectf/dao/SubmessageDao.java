package jp.co.comnic.javalesson.projectf.dao;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.projectf.entity.Submessage;

public class SubmessageDao extends BaseDao {

	public SubmessageDao() throws DaoException {}
	
	private CriteriaQuery<Submessage> query = builder.createQuery(Submessage.class);
	private Root<Submessage> root = query.from(Submessage.class);
	
	public java.util.List<Submessage> findAll(){
		return super.findAll(query, root);
	}
	
}
