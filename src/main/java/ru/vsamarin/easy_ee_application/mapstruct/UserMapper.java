package ru.vsamarin.easy_ee_application.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.entity.UserEntity;

@Mapper(componentModel = "cdi")
public interface UserMapper extends MapperBase<UserEntity, UserDto> {

    @Override
    @Mappings({@Mapping(target = "password", ignore = true)})
    UserDto toDto(UserEntity entity);

    @Override
    UserEntity toEntity(UserDto dto);

}
