package jp.co.comnic.javalesson.projectf.taglibs;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;

/**
 * <p>すべてのカスタム・タグのベースとなる抽象クラス。</p>
 * 
 * @author M.Yoneyama
 */
public abstract class AbstractBaseTag extends BodyTagSupport implements DynamicAttributes {

	protected HashMap<String, Object> dynamicAttributes = new HashMap<String, Object>();
		
	@Override
	public void setDynamicAttribute(String namespaceURI, String attributeName, 
			                        Object attributeValue) throws JspException {
		
		dynamicAttributes.put(attributeName, attributeValue);
	}

	/**
	 * <p>動的属性の出力。</p>
	 * 
	 * @throws JspException
	 */
	protected void writeDynamicAttributes() throws JspException {
		
		for(String attributeName : dynamicAttributes.keySet()) {
			try {
				pageContext.getOut().print(attributeName + "=\"" + dynamicAttributes.get(attributeName) + "\" ");
			} catch (IOException e) {
				throw new JspException(e);
			}
		}
	}
}
