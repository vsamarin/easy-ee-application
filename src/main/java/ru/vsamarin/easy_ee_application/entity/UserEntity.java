package ru.vsamarin.easy_ee_application.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_tbl")
public class UserEntity extends EntityBase {

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "login", length = 50, nullable = false)
    private String login;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

}

