package com.eestec.codeapp.user;

import com.eestec.codeapp.base.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "users")
@Entity
@NoArgsConstructor
public class User extends BaseModel {

    public User(UserDto userDto) {
        this.username = userDto.username;
        this.email = userDto.email;
        this.phone = userDto.phone;
    }

    @Column(name = "username")
    public String username;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;


}
