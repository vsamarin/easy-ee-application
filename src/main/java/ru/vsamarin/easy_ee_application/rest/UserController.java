package ru.vsamarin.easy_ee_application.rest;

import ru.vsamarin.easy_ee_application.dto.UserDto;
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
    public UserDto dto(Long id) {
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

}
