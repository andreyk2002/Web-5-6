package by.fpmi.web.model.dto;

import by.fpmi.web.model.entity.Qualification;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerDto {
    private long id;
    private String projectName;
    private int workersOnTask;
    private String surname;
    private String name;
    private Qualification qualification;
    private double salary;
    private boolean isFree;
}
