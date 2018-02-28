package com.eestec.codeapp.post;

import com.eestec.codeapp.city.City;
import com.eestec.codeapp.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

    public String description;
    public User user;
    public City city;
}
