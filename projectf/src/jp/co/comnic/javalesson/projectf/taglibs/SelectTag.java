package jp.co.comnic.javalesson.projectf.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.sql.DataSource;

/**
 * <p>HTMLの&lt;select&gt;タグに対応するカスタムタグのハンドラー・クラス。</p>
 * <p>items属性に指定可能なデータ･コレクションは基本的にJSTLのc:&lt;forEachタグ&gt;で使用可能な以下オブジェクト</p>
 * <li>
 *   <ul>1次元配列</ul>
 *   <ul>2次元配列</ul>
 *   <ul>Listオブジェクト</ul>
 *   <ul>Mapオブジェクト</ul>
 * </li>
 * 
 * @author M.Yoneyama
 */
public class SelectTag extends AbstractBaseTag {
	private static final long serialVersionUID = 1L;
	
	private Object items;
	private String dataSource;
	private String table;

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Override
	public int doStartTag() throws JspException {

		try {
			
			if(dataSource != null && table == null) {
				throw new Exception("If you specify dataSource attribute, you must specify table attribute.");
			}
			
			if(table != null && dataSource == null) {
				throw new Exception("If you specify table attribute, you must specify dataSource attribute.");
			}
			
			JspWriter out = pageContext.getOut();
			
			out.print("<select "); 		
			writeDynamicAttributes(); 	
			out.println(">"); 			
			
		} catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		
		try {
			String str = bodyContent.getString();
			getPreviousOut().println(str);
		} catch (IOException e) {
			throw new JspException(e);
		}
		
		return SKIP_BODY;
	}
	

	@Override
	public int doEndTag() throws JspException {
		
		try {
			pageContext.getOut().println("</select>");
		} catch (IOException e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		super.release();
	}
}
