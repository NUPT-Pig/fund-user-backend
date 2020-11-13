package org.nuptpig.funduserbackend.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCreateRequest {
    @JsonProperty(value = "user_name")
    private String userName;

    private String password;

    private String email;
}
