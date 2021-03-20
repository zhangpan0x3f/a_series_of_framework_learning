package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang pan
 * @Description 类描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Integer id;

    private String username;

    private String password;

}
