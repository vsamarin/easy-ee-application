package ru.vsamarin.easy_ee_application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends EntityDto {
    private String name;
    private String login;
    private String password;
    private Long version;
}
