package com.eestec.codeapp.city;

import com.eestec.codeapp.base.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "city")
@Entity
@NoArgsConstructor
public class City extends BaseModel {

    public City(CityDto cityDto) {
        this.name = cityDto.name;
        this.latitude = cityDto.latitude;
        this.longitude = cityDto.longitude;
    }

    @Column(name = "name")
    public String name;

    @Column(name = "latitude")
    public String latitude;

    @Column(name = "longitude")
    public String longitude;

}
