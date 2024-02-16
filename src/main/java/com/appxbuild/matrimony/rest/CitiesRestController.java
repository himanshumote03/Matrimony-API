package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Cities;
import com.appxbuild.matrimony.service.CitiesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CitiesRestController {

    private CitiesService citiesService;

    public CitiesRestController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    // "/cities" -> return list of all cities
    @GetMapping("/cities")
    public List<Cities> findAll() {
        return citiesService.findAll();
    }


    // "/cities/{cityId}" -> return city with specific id
    @GetMapping("/cities/{cityId}")
    public Cities getCity(@PathVariable int cityId) {
        Cities cities = citiesService.findById(cityId);

        if (cities == null) {
            throw new RuntimeException("Did not find id: " + cityId);
        }
        return cities;
    }

    // "/cities" -> add city
    @PostMapping("/cities")
    public Cities addCity(@RequestBody Cities cities) {
        cities.setId(0);
        LocalDateTime dt = LocalDateTime.now();
        cities.setCreated(dt);
        cities.setModified(null);

        Cities dbCities = citiesService.save(cities);
        return dbCities;
    }

    // "/cities" -> update city
    @PutMapping("/cities")
    public Cities updateCity(@RequestBody Cities cities) {
        LocalDateTime dt = LocalDateTime.now();
        cities.setModified(dt);

        Cities dbCities = citiesService.save(cities);
        return dbCities;
    }

    // "/cities/{cityId}" -> delete city
    @DeleteMapping("/cities/{cityId}")
    public void delete(@PathVariable int cityId) {
        Cities dbCity = citiesService.findById(cityId);

        if (dbCity == null) {
            throw new RuntimeException("Did not find id: " + cityId);
        }
        citiesService.delete(cityId);
    }



}
