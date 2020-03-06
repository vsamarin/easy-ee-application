package ru.vsamarin.easy_ee_application.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@Entity
@Table(name = "role")
public class RoleEntity extends EntityBase {

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "title", nullable = false)
    private String title;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

}
