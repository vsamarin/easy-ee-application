package ru.vsamarin.easy_ee_application.rest.exception;

import ru.vsamarin.easy_ee_application.dto.ExceptionDto;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {

    @Override
    public Response toResponse(EntityNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(new ExceptionDto(e.getMessage()))
                .build();
    }

}
