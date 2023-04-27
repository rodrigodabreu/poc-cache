package com.abreu.poccache.controllers;

import com.abreu.poccache.dtos.UserDto;
import com.abreu.poccache.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @GetMapping
  public ResponseEntity<List<UserDto>> listUsers() {
    List<UserDto> dtos = service.list();
    return new ResponseEntity<>(dtos, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable Long id) throws Exception {
    UserDto dto = service.getUserById(id);
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity createUser(@RequestBody UserDto dto){
    service.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }


  @DeleteMapping("/{id}")
  public ResponseEntity removeUser(@PathVariable Long id) {
    service.remove(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
