package by.fpmi.web.tag;


import by.fpmi.web.model.dto.WorkerDto;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class WorkersTableTag extends TagSupport {

    private static final String OPEN_HEADER = " <table class=\"table\">";
    private static final String CLOSE_TABLE = "</table>";
    private static final String CLOSE_BODY = "</tbody>";
    private static final String OPEN_BODY = "<tbody>";

    private List<WorkerDto> workersDto;


    public void setWorkersDto(List<WorkerDto> workersDto) {
        this.workersDto = workersDto;
    }

    @Override
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        StringBuilder content = new StringBuilder();
        content.append(OPEN_HEADER);
        content.append(makeHeader());
        content.append(OPEN_BODY);
        for (WorkerDto workerDto : workersDto) {
            content.append(makeRow(workerDto));
        }
        content.append(CLOSE_BODY);
        content.append(CLOSE_TABLE);
        try {
            JspWriter out = pageContext.getOut();
            out.write(content.toString());
        } catch (IOException e) {
            throw new JspException(e.getMessage(), e);
        }
        return SKIP_BODY;
    }

    private String makeRow(WorkerDto workerDto) {
        return "<tr>" +
                "<th scope=\"col\">" + workerDto.getId() + "</th>" +
                "<th scope=\"col\">" + workerDto.getName() + "</th>" +
                "<th scope=\"col\">" + workerDto.getSurname() + "</th>" +
                "<th scope=\"col\">" + workerDto.getQualification() + "</th>" +
                "<th scope=\"col\">" + workerDto.getSalary() + "</th>" +
                "</tr>";
    }

    private String makeHeader() {
        return "            <thead>\n" +
                "            <tr>\n" +
                "                <th scope=\"col\">ID</th>\n" +
                "                <th scope=\"col\"><fmt:message key=\"local.name\"/>Name</th>\n" +
                "                <th scope=\"col\"><fmt:message key=\"local.surname\"/>Surname</th>\n" +
                "                <th scope=\"col\"><fmt:message key=\"local.qualification\"/>Qualification</th>\n" +
                "                <th scope=\"col\"><fmt:message key=\"local.salary\"/>Salary</th>\n" +
                "            </tr>\n" +
                "            </thead>";
    }


    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
