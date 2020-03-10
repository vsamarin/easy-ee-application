package ru.vsamarin.easy_ee_application.service;

import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.entity.UserEntity;
import ru.vsamarin.easy_ee_application.mapstruct.UserMapper;
import ru.vsamarin.easy_ee_application.repository.UserRepository;
import ru.vsamarin.easy_ee_application.rest.exception.EntityNotFoundException;

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

    public UserDto getById(Long id) throws EntityNotFoundException {
        UserEntity entity = userRepository.getById(id);
        if (entity == null) {
            throw new EntityNotFoundException(id);
        }
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

    public Long update(Long id, UserDto dto) throws EntityNotFoundException {
        UserEntity entity = userRepository.getById(id);
        if (entity == null) {
            throw new EntityNotFoundException(id);
        }
        entity = userMapper.updateEntity(entity, dto);
        entity = userRepository.update(entity);
        return entity.getId();
    }

    public Long delete(Long id) throws EntityNotFoundException {
        UserEntity entity = userRepository.getById(id);
        if (entity == null) {
            throw new EntityNotFoundException(id);
        }
        userRepository.delete(entity);
        return entity.getId();
    }

}
