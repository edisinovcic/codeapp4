package com.eestec.codeapp.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> fetchAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> fetchOne(Long id) {
        return Optional.ofNullable(cityRepository.findOne(id));
    }

    @Override
    public Optional<City> save(CityDto cityDto) {
        Optional<City> optionalCity = Optional.ofNullable(cityRepository.findByName(cityDto.name));
        City city = optionalCity.orElse(new City(cityDto));
        cityRepository.save(city);
        return Optional.ofNullable(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
    }
}
