package ru.vsamarin.easy_ee_application.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.vsamarin.easy_ee_application.dto.UserDto;

import javax.ws.rs.*;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
@Tag(name = "UserController", description = "API для работы с пользователями")
public interface UserApi {

    @GET
    @Path("/{id}")
    @Operation(summary = "Получить пользователя по идентификатору")
    UserDto dto(@PathParam("id") Long id);

    @GET
    @Path("/list")
    @Operation(summary = "Получить список пользователей")
    List<UserDto> list();

    @POST
    @Path("/create")
    @Operation(summary = "Создать пользователя")
    Long create(UserDto dto);



}
