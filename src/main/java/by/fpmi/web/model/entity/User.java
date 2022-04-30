package by.fpmi.web.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private final String name;

  private final String password;

  private final UserRole userRole;

}
