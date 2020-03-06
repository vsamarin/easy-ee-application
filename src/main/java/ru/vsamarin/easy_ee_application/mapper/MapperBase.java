package ru.vsamarin.easy_ee_application.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public abstract class MapperBase<Entity, Dto> {

    private ModelMapper modelMapper = new ModelMapper() {{
        this.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }};

    protected ModelMapper modelMapper() {
        return modelMapper;
    }

    public abstract Entity toEntity(Dto dto);

    public abstract Dto toDto(Entity entity);

}
