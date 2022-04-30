package by.fpmi.web.model.entity;

import lombok.*;


@Data
@AllArgsConstructor
public class Worker {
    private long id;
    private long projectId;
    private long taskId;
    private String surname;
    private String name;
    private Qualification qualification;
    private double salary;
    private boolean isFree;
}
