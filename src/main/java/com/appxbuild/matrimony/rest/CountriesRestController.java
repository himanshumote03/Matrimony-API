package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Countries;
import com.appxbuild.matrimony.service.CountriesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountriesRestController {

    private CountriesService countriesService;

    public CountriesRestController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    // "/countries" -> return list of all countries
    @GetMapping("/countries")
    public List<Countries> findAll() {
        System.out.println("\n\n----------------->>> Error: " + countriesService.findAll() + "\n\n");
        return countriesService.findAll();
    }

    // "/countries/{countryId}" -> return country with specific id
    @GetMapping("/countries/{countryId}")
    public Countries getCountry(@PathVariable int countryId) {
        Countries countries = countriesService.findById(countryId);

        if (countries == null) {
            throw new RuntimeException("Cannot find the country id: " + countryId);
        }

        System.out.println("\n\n----------------->>> Error: " + countries + "\n\n");
        return countries;
    }

    // "/countries" ->  add new countries
    @PostMapping("/countries")
    public Countries addCountry(@RequestBody Countries countries) {
        countries.setId(0);
        LocalDateTime dt = LocalDateTime.now();
        countries.setCreated(dt);
        countries.setModified(null);

        Countries dbCountries = countriesService.save(countries);
        return dbCountries;
    }

    // "/countries" -> update country
    @PutMapping("/countries")
    public Countries updateCountry(@RequestBody Countries countries) {

        LocalDateTime dt = LocalDateTime.now();
        countries.setModified(dt);

        Countries dbCountry = countriesService.save(countries);
        return dbCountry;
    }

    // "/countries/{countryId}" -> delete country by id
    @DeleteMapping("/countries/{countryId}")
    public String delete(@PathVariable int countryId) {
         Countries dbCountries = countriesService.findById(countryId);

         if (dbCountries == null) {
             throw new RuntimeException("Did not find country id: " + countryId);
         }

         countriesService.delete(countryId);
         return ("Country id: " + countryId + " deleted.");
    }

}
