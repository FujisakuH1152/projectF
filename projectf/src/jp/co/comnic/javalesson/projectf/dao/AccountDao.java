package jp.co.comnic.javalesson.projectf.dao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.cominc.javalesson.projectf.entity.Account;

/**
 * <p>アカウント･テーブルのCRUD操作を実装するDAOクラス</p>
 * @author fujisaku.hayato
 * @author ver1.0α
 */
public class AccountDao extends BaseDao {

	public AccountDao() throws DaoException{}
	
	private CriteriaQuery<Account> query = builder.createQuery(Account.class);
	private Root<Account> root = query.from(Account.class);
	
	public java.util.List<Account> findAll(){
		return super.findAll(query, root);	
	}
	
	public Account loginAuthenticate(String email, String password){
		
//		インスタンスの初期化
		Account account = null;
		
//		SQLのクエリ生成  (SELECT * FROM ACCOUNT WHERE email = ["email"] AND password = ["password"])
		try {
			query.select(root)
				 .where(builder.equal(root.get("email"),email),
						 builder.equal(root.get("password"), password));
//			SQLの実行結果をエンティティオブジェクトで取得
			account = em.createQuery(query).getSingleResult();
			
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		return account;
	}
}