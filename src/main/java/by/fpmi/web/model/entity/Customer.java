package by.fpmi.web.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {

    private long id;

    private String name;

    private String surname;

    private double money;
}
