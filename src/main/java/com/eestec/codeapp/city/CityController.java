package com.eestec.codeapp.city;

import com.eestec.codeapp.base.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public RestResponse findAll() {
        return new RestResponse(true).setData(cityService.fetchAll());
    }

    @GetMapping
    public RestResponse findOne(@PathVariable(value = "id") Long id) {
        return new RestResponse(true).setData(cityService.fetchOne(id));
    }

    @PostMapping
    public RestResponse save(@RequestBody @Valid CityDto cityDto) {
        return new RestResponse(true).setData(cityService.save(cityDto));
    }

    @DeleteMapping
    public RestResponse delete(@RequestParam Long id) {
        cityService.delete(id);
        return new RestResponse(true);
    }
}
