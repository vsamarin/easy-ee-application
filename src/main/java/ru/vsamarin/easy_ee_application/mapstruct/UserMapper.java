package ru.vsamarin.easy_ee_application.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.entity.UserEntity;

@Mapper(componentModel = "cdi")
public interface UserMapper extends MapperBase<UserEntity, UserDto> {

    @Mappings({@Mapping(target = "password", ignore = true)})
    @Override
    UserDto toDto(UserEntity entity);

    @Override
    UserEntity toEntity(UserDto dto);

    default UserEntity updateEntity(UserEntity entity, UserDto dto) {
        if (dto == null) {
            return null;
        }
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getLogin() != null) {
            entity.setLogin(dto.getLogin());
        }
        if (dto.getPassword() != null) {
            entity.setPassword(dto.getPassword());
        }
        if (dto.getVersion() != null) {
            entity.setVersion(dto.getVersion());
        }
        return entity;
    }

}
