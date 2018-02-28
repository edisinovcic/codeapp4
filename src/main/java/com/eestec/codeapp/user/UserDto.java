package com.eestec.codeapp.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    public String username;
    public String email;
    public String phone;
}
