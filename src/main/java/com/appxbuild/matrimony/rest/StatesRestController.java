package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.States;
import com.appxbuild.matrimony.service.StatesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatesRestController {
    private StatesService statesService;

    public StatesRestController(StatesService statesService) {
        this.statesService = statesService;
    }

    // "/states" -> return list of all states
    @GetMapping("/states")
    public List<States> findAll() {
        System.out.println("\n\n----------------->>> Error: " + statesService.findAll() + "\n\n");
        return statesService.findAll();
    }

    // "/states/{statesId}" -> return state with specific id
    @GetMapping("/states/{statesId}")
    public States getStates(@PathVariable int statesId) {
        States states = statesService.findById(statesId);

        if (states == null) {
            throw new RuntimeException("Cannot find the state id: " + statesId);
        }

        System.out.println("\n\n----------------->>> Error: " + states + "\n\n");
        return states;
    }

    // "/states" ->  add new states
    @PostMapping("/states")
    public States addStates(@RequestBody States states) {
        states.setId(0);
        LocalDateTime dt = LocalDateTime.now();
        states.setCreated(dt);
        states.setModified(null);

        States dbStates = statesService.save(states);
        return dbStates;
    }

    // "/states" -> update state
    @PutMapping("/states")
    public States updateState(@RequestBody States states) {

        LocalDateTime dt = LocalDateTime.now();
        states.setModified(dt);

        States dbStates = statesService.save(states);
        return dbStates;
    }

    // "/states/{statesId}" -> delete state by id
    @DeleteMapping("/states/{statesId}")
    public String delete(@PathVariable int statesId) {
        States dbStated = statesService.findById(statesId);

        if (dbStated == null) {
            throw new RuntimeException("Did not find state id: " + statesId);
        }

        statesService.delete(statesId);
        return ("State id: " + statesId + " deleted.");
    }

}
