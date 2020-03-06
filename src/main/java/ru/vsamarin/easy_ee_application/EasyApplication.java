package ru.vsamarin.easy_ee_application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import javax.ws.rs.core.Application;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class EasyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Stream.of(OpenApiResource.class).collect(Collectors.toSet());
    }

}
