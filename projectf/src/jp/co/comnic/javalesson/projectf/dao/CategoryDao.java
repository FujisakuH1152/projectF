package jp.co.comnic.javalesson.projectf.dao;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.projectf.entity.Category;

/**
 * <p>カテゴリー･テーブルの操作を実装するDAOクラス</p>
 * @author fujisaku.hayato
 * @author ver1.0α
 */

public class CategoryDao extends BaseDao {

	public CategoryDao() throws DaoException {}

	private CriteriaQuery<Category> query = builder.createQuery(Category.class);
	private Root<Category> root = query.from(Category.class);

	public java.util.List<Category> findAll() {
		return super.findAll(query, root);
	}
	
	public Category findById(Integer id) {
		return super.findById(Category.class, id);
	}
}
