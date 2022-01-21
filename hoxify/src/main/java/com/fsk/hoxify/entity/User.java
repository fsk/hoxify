package com.fsk.hoxify.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String displayName;
    private String password;
}
