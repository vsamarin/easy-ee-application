package ru.vsamarin.easy_ee_application.mapper;

import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.entity.UserEntity;

import javax.enterprise.context.RequestScoped;
import java.util.Objects;

@RequestScoped
public class UserMapper extends MapperBase<UserEntity, UserDto> {

    @Override
    public UserEntity toEntity(UserDto dto) {
        return Objects.isNull(dto) ? null : modelMapper().map(dto, UserEntity.class);
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper().map(entity, UserDto.class);
    }

}
