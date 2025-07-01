package com.devrenno.resourceserver.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "tb_authority")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Authority() {}

    public Authority(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority authority)) return false;

        return Objects.equals(name, authority.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
