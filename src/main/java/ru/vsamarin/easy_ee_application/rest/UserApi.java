package ru.vsamarin.easy_ee_application.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.vsamarin.easy_ee_application.dto.UserDto;
import ru.vsamarin.easy_ee_application.rest.exception.EntityNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "UserController", description = "API для работы с пользователями")
public interface UserApi {

    @GET
    @Path("/{id}")
    @Operation(
            summary = "Получить пользователя по идентификатору",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
            })
    UserDto getById(@PathParam("id") Long id) throws EntityNotFoundException;

    @GET
    @Path("/list")
    @Operation(summary = "Получить список пользователей")
    List<UserDto> list();

    @POST
    @Path("/create")
    @Operation(summary = "Создать пользователя")
    Long create(UserDto dto);

    @PUT
    @Path("/update/{id}")
    @Operation(
            summary = "Обновление пользователя",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Идентификатор обновленного пользователя"),
                    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
            })
    Long update(@PathParam("id") Long id, UserDto dto) throws EntityNotFoundException;

    @DELETE
    @Path("/update/{id}")
    @Operation(
            summary = "Удаление пользователя",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Идентификатор обновленного пользователя"),
                    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
            })
    Long delete(@PathParam("id") Long id) throws EntityNotFoundException;

}
