package com.abreu.poccache.mappers;

import com.abreu.poccache.dtos.UserDto;
import com.abreu.poccache.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toDto(UserEntity entity);

  UserEntity toEntity(UserDto dto);

}
