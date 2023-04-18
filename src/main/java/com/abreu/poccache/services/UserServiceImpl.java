package com.abreu.poccache.services;

import com.abreu.poccache.dtos.UserDto;
import com.abreu.poccache.entities.UserEntity;
import com.abreu.poccache.mappers.UserMapper;
import com.abreu.poccache.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserMapper mapper;

  @Override
  public List<UserDto> list() {
    return repository.findAll().stream().map(mapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void create(UserDto dto) {
    UserEntity entity = mapper.toEntity(dto);
    repository.save(entity);
  }

  @Override
  public void remove(Long id) {
    repository.deleteById(id);
  }

  @Override
  public UserDto getUserById(Long id) throws Exception {
    Optional<UserEntity> entity = repository.findById(id);
    if (entity.isPresent()) {
      return mapper.toDto(entity.get());
    } else {
      throw new Exception("User not found by id");
    }
  }
}
