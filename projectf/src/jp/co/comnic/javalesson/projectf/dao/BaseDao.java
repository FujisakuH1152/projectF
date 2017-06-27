package jp.co.comnic.javalesson.projectf.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.projectf.dao.DaoException;


/**
 * 
 * 共通の基底となるDaoクラス
 * @author fujisaku.hayato
 * @author ver1.0α
 */


public class BaseDao {
	// EntityManagerの生成 (エンティティ全体の管理用オブジェクト)
	protected EntityManager em = Persistence.createEntityManagerFactory("projectf").createEntityManager();
	// EntityTransactionの取得 (トランザクション管理用オブジェクト)
	protected EntityTransaction tx = em.getTransaction();
	// QueryBuilderの取得 (SQLクエリの生成用オブジェクト)
	protected CriteriaBuilder builder = em.getCriteriaBuilder();
	
	
	

	/**
	 * <p>全件検索</p>
	 * 
	 * @param query
	 * @param root
	 * @return　検索結果のエンティティ・オブジェクト
	 */
	//	<T> ジェネリクス　コンパイル時にオブジェクト型としてコンパイル
	protected <T> List<T> findAll(CriteriaQuery<T> query, Root<T> root) {
		return em.createQuery(query.select(root)).getResultList();
	}
	
	/**
	 * <p>主キー検索</p>
	 * 
	 * @param entityClass
	 * @param id
	 * @return 検索結果のエンティティ・オブジェクト
	 */
	public <T> T findById(Class<T> entityClass, Serializable id) {
		return em.find(entityClass, id);
	}
		
	/**
	 * <p>新規レコードの挿入</p>
	 * 
	 * @param entity
	 */
	public void insert(Object entity) throws DaoException {

		try {
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * <p>既存レコードの削除</p>
	 * 
	 * @param entityClass 削除するレコードに対応するエンティティ・クラス
	 * @param id 削除するレコードのID
	 */
	public <T> void remove(Class<T> entityClass, Serializable id) throws DaoException {
		// エンティティ・オブジェクトを取得して削除
		remove(em.find(entityClass, id));
	}
	
	/**
	 * <p>既存レコードの削除</p>
	 * 
	 * @param entity 削除するエンティティ・オブジェクト
	 */
	public void remove(Object entity) throws DaoException {
		try {
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public void update(Object entity) throws DaoException {
		try {
			tx.begin();
			em.merge(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
