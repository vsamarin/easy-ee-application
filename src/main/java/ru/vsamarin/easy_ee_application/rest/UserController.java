package ru.vsamarin.easy_ee_application.rest;

import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.rest.exception.EntityNotFoundException;
import ru.vsamarin.easy_ee_application.service.UserService;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ws.rs.Path;
import java.util.List;

@Local
@Path("/user")
public class UserController implements UserApi {

    @EJB
    private UserService userService;

    @Override
    public UserDto dto(Long id) throws EntityNotFoundException {
        return userService.getById(id);
    }

    @Override
    public List<UserDto> list() {
        return userService.list();
    }

    @Override
    public Long create(UserDto dto) {
        return userService.create(dto);
    }

    @Override
    public Long update(Long id, UserDto dto) throws EntityNotFoundException {
        return userService.update(id, dto);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        return userService.delete(id);
    }
}
