package com.peachy.ppp.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "usermodules")
public class UserModuleEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    String name;

    @ManyToMany
    @JoinTable(name = "users_usermodules",
        joinColumns = @JoinColumn(name = "usermodules_id"),
        inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    List<UserEntity> targetUser = new ArrayList<>();

    @NotBlank
    @Size(max = 50)
    private String updatedat;
    //todo fix this maby date instead
    @NotBlank
    @Size(max = 50)
    private String createdat;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(List<UserEntity> targetUser) {
        this.targetUser = targetUser;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }
}
