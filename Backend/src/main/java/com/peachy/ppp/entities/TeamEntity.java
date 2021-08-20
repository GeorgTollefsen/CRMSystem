package com.peachy.ppp.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "teams")
public class TeamEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Size(max = 150)
    String team_name;

    @OneToMany(mappedBy = "targetTeam")
    List<UserEntity> users;

    @ManyToOne
    CompanyEntity targetCompany;

    public UUID getId() {
        return id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public CompanyEntity getTargetCompany() {
        return targetCompany;
    }

    public void setTargetCompany(CompanyEntity targetCompany) {
        this.targetCompany = targetCompany;
    }
}
