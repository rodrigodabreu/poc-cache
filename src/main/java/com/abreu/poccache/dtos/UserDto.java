package com.abreu.poccache.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private String firstName;
  private String lastName;
  private String email;

}
