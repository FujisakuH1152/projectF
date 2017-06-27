package jp.co.comnic.javalesson.projectf.taglibs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspException;
import javax.sql.DataSource;

/**
 * @author M.Yoneyama
 *
 */
public class OptionTag extends AbstractBaseTag {
	private static final long serialVersionUID = 1L;
	
	private String value;
	private String display;
	private String selected;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	public int doStartTag() throws JspException {
		
		try {

			pageContext.getOut().print(generateHtml());
			
		} catch (IOException e) {
			throw new JspException(e);
		} 
	
		return SKIP_BODY;
	}
	
	private String generateHtml() throws JspException {
		
		SelectTag selectTag = (SelectTag)getParent();
		String sql = "SELECT " + value + ", " + display + " FROM " + 
		             selectTag.getTable() + 
			         " ORDER BY " + value;
		
		DataSource ds;
		try {
			ds = (DataSource) new InitialContext()
					.lookup("java:comp/env/" + selectTag.getDataSource());
		} catch (NamingException e) {
			throw new JspException(e);
		}
		
		try (Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);) {
		
			StringBuffer html = new StringBuffer();
			html.append("<option></option>");
			
			while (rs.next()) {
				
				Object v = rs.getObject(value);
				Object d = rs.getObject(display);
				
				html.append("<option value='");
				html.append(v);
				html.append("\'");

				if(selected != null && v.toString().equals(selected)) {
					html.append(" selected");
				}
				
				html.append(">");
				html.append(d);
				html.append("</option>");
			}
			
			return html.toString();
			
		} catch (SQLException e) {
			throw new JspException(e);
		} 
	}
}
