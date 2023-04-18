package com.abreu.poccache.services;

import com.abreu.poccache.dtos.UserDto;
import java.util.List;

public interface UserService {

  List<UserDto> list();

  void create(UserDto dto);

  void remove(Long id);

  UserDto getUserById(Long id) throws Exception;
}
