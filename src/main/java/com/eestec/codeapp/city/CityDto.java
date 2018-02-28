package com.eestec.codeapp.city;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CityDto {

    @NotNull
    public String name;

    @NotNull
    public String latitude;

    @NotNull
    public String longitude;

}
