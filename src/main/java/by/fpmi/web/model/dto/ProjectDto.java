package by.fpmi.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDto {

    private long id;
    private String projectDescription;
    private String projectName;
    private String customerName;
    private String customerSurname;
    private double customerMoney;
    private boolean paidByCustomer;
}
