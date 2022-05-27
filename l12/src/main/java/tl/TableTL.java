package tl;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

@SuppressWarnings("serial")
public class TableTL extends TagSupport {

    private String nameTable;
    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    private int countItem;
    public void setCountItem(int countItem) {
        this.countItem = countItem;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("<h4>" + nameTable + "</h4>");
            out.write("<table border='1' cellspacing='0'><tr><td>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doAfterBody() throws JspException {
        if (countItem-- > 1) {
            try {
                pageContext.getOut().write("</td></tr><tr><td>");
            } catch (IOException e) {
                throw new JspException(e.getMessage());
            }
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write("</td></tr>");
            out.write("</table>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}