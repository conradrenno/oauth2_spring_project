package com.devrenno.resourceserver.dto;

public interface UserDetailsProjection {

    String getUsername();

    String getPassword();

    Long getAuthorityId();

    String getAuthority();
}
