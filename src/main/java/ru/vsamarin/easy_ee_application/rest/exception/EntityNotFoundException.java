package ru.vsamarin.easy_ee_application.rest.exception;

import java.text.MessageFormat;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Long id) {
        super(MessageFormat.format("Объект с идентификатором {0} не найден", String.valueOf(id)));
    }

}
