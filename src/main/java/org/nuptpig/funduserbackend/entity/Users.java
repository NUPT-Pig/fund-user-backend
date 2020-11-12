package org.nuptpig.funduserbackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_tb")
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    private String password;

    private String salt;

    private String email;

    private int role=Role.VIEWER.getRoleLevel();

    public enum Role {
        ADMIN("ADMIN", 0),
        USER("USER", 5),
        VIEWER("VIEWER", 10);

        private String roleDesc;
        private int roleLevel;

        Role(String roleDesc, int roleLevel) {
            this.roleDesc = roleDesc;
            this.roleLevel = roleLevel;
        }

        public String getRoleDesc(){
            return this.roleDesc;
        }

        public int getRoleLevel(){
            return this.roleLevel;
        }
    }
}

