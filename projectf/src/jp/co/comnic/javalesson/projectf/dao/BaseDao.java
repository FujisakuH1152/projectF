package jp.co.comnic.javalesson.projectf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class BaseDao {
	// EntityManagerの生成 (エンティティ全体の管理用オブジェクト)
	protected EntityManager em = Persistence.createEntityManagerFactory("projectf2").createEntityManager();
	// EntityTransactionの取得 (トランザクション管理用オブジェクト)
	protected EntityTransaction tx = em.getTransaction();
	// QueryBuilderの取得 (SQLクエリの生成用オブジェクト)
	protected CriteriaBuilder builder = em.getCriteriaBuilder();
	
	
//	<T> ジェネリクス　コンパイル時にオブジェクト型としてコンパイル
	protected <T> List<T> findAll(CriteriaQuery<T> query, Root<T> root) {
		return em.createQuery(query.select(root)).getResultList();
	}
}
