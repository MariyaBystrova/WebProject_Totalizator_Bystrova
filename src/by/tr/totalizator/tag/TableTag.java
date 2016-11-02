package by.tr.totalizator.tag;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import by.tr.totalizator.entity.Match;

public class TableTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private JSPListBean list;

	private String col2;
	private String col3;
	private String col4;
	private String col5;
	private String col6;

	public int doStartTag() throws JspTagException {
		int size = new Integer(list.getSize());
		try {
			pageContext.getOut()
					.write("<table class=\"table table-striped table-bordered table-hover table-condensed\">");
			pageContext.getOut().write("<tr><th>");
			pageContext.getOut().write("#" + "</th>");

			pageContext.getOut().write("<th>" + col2 + "</th>");
			pageContext.getOut().write("<th>" + col3 + "</th>");
			pageContext.getOut().write("<th>" + col4 + "</th>");
			pageContext.getOut().write("<th>" + col5 + "</th>");
			pageContext.getOut().write("<th>" + col6);
			pageContext.getOut().write("</th></tr>");

			for (int i = 0; i < size; i++) {
				Match match = list.getElement();
				pageContext.getOut().write("<tr>");
				pageContext.getOut().write("<td>");
				pageContext.getOut().write(new Integer(i + 1).toString());
				pageContext.getOut().write(".</td>");
				pageContext.getOut().write("<td>");
				pageContext.getOut()
						.write(match.getStartDate() + " - " + match.getEndDate());
				pageContext.getOut().write("</td>");
				pageContext.getOut().write("<td>");
				pageContext.getOut().write(match.getTeamOne() + " - " + match.getTeamTwo());
				pageContext.getOut().write("</td>");
				pageContext.getOut().write("<td>");
				pageContext.getOut().write("<input type=\"checkbox\" name=\"result" + new Integer(i + 1).toString() +"\" value=\"1\">");
				pageContext.getOut().write("</td>");
				pageContext.getOut().write("<td>");
				pageContext.getOut().write("<input type=\"checkbox\" name=\"result" + new Integer(i + 1).toString() +"\" value=\"X\">");
				pageContext.getOut().write("</td>");
				pageContext.getOut().write("<td>");
				pageContext.getOut().write("<input type=\"checkbox\" name=\"result" + new Integer(i + 1).toString() +"\" value=\"2\">");
				pageContext.getOut().write("</td>");
				pageContext.getOut().write("</tr>");
			}
			pageContext.getOut().write("</tr>");
			pageContext.getOut().write("</table>");
		} catch (IOException e) {
			throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
	}

	public JSPListBean getList() {
		return list;
	}

	public void setList(JSPListBean list) {
		this.list = list;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol4() {
		return col4;
	}

	public void setCol4(String col4) {
		this.col4 = col4;
	}

	public String getCol5() {
		return col5;
	}

	public void setCol5(String col5) {
		this.col5 = col5;
	}

	public String getCol6() {
		return col6;
	}

	public void setCol6(String col6) {
		this.col6 = col6;
	}

}
