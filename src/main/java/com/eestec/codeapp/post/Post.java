package com.eestec.codeapp.post;

import com.eestec.codeapp.base.BaseModel;
import com.eestec.codeapp.city.City;
import com.eestec.codeapp.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "post")
@Entity
@NoArgsConstructor
public class Post extends BaseModel {

    public Post(PostDto postDto) {
        this.description = postDto.description;
        this.city = postDto.city;
        this.user = postDto.user;
    }

    @Column(name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "city_id")
    public City city;

}
