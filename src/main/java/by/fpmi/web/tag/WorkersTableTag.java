package by.fpmi.web.tag;


import by.fpmi.web.model.dto.WorkerDto;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class WorkersTableTag extends TagSupport {

    private static final String INFO_HEADER = "<h3 class=\"personal-info\">";
    private static final String CLOSE_INFO = "</h3>";
    private static final String TITLE_HEADER = "<h2 class=\"personal-title\">";
    private static final String CLOSE_TITLE = "</h2>";
    private static final String NAME_PROPERTY = "local.username";
    private static final String RATING_PROPERTY = "local.rating";

    private List<WorkerDto> workersDto;


    public void setWorkersDto(List<WorkerDto> workersDto) {
        this.workersDto = workersDto;
    }

    @Override
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();

        double rating = workersDto.getRating();
        StringBuilder content = new StringBuilder();
        content.append(makeTitle(loginLabel, login));
        content.append(makeInfo(ratingLabel, Double.toString(rating)));
        try {
            JspWriter out = pageContext.getOut();
            out.write(content.toString());
        } catch (IOException e) {
            throw new JspException(e.getMessage(), e);
        }
        return SKIP_BODY;
    }

    private StringBuilder makeInfo(String label, String content) {
        StringBuilder info = new StringBuilder();
        info.append(INFO_HEADER);
        info.append(label);
        info.append(" : ");
        info.append(content);
        info.append(CLOSE_INFO);
        return info;
    }

    private StringBuilder makeTitle(String loginLabel, String login) {
        StringBuilder title = new StringBuilder();
        title.append(TITLE_HEADER);
        title.append(loginLabel);
        title.append(" : ");
        title.append(login);
        title.append(CLOSE_TITLE);
        return title;
    }


    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
