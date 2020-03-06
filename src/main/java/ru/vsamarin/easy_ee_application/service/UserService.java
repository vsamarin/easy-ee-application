package ru.vsamarin.easy_ee_application.service;

import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.entity.UserEntity;
import ru.vsamarin.easy_ee_application.mapstruct.UserMapper;
import ru.vsamarin.easy_ee_application.repository.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Local
@Stateless
public class UserService {

    @EJB
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;

    public UserDto getById(Long id) {
        UserEntity entity = userRepository.getById(id);
        return userMapper.toDto(entity);
    }

    public Long create(UserDto dto) {
        UserEntity entity = userMapper.toEntity(dto);
        userRepository.create(entity);
        return entity.getId();
    }

    public List<UserDto> list() {
        List<UserEntity> entityList = userRepository.getList();
        return userMapper.toDto(entityList);
    }

}
