package com.coral.service.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Table(name = "tb_user")
public class User implements Serializable {

    @GeneratedValue(generator="JDBC")
    @Id
    private  Long id;
    private  String username;
    private  String password;
    private  String name;
    private  Integer age;
    private  Integer sex;
    private  String birthday;
    private  String created;
}
