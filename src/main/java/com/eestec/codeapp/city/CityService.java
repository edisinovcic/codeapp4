package com.eestec.codeapp.city;

import java.util.List;
import java.util.Optional;

public interface CityService {

    public List<City> fetchAll();

    public Optional<City> fetchOne(Long id);

    public Optional<City> save(CityDto cityDto);

    public void delete(Long id);

    public void deleteAll();
}
