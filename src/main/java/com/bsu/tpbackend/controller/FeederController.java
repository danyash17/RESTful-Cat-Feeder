package com.bsu.tpbackend.controller;

import com.bsu.tpbackend.entity.FeederEntity;
import com.bsu.tpbackend.exception.feeder.FeederAlreadyExistException;
import com.bsu.tpbackend.exception.feeder.FeederNotFoundException;
import com.bsu.tpbackend.service.FeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/feeder")
public class FeederController {
    @Autowired
    private FeederService service;

    @GetMapping("{/id}")
    public ResponseEntity get(@RequestParam Integer id){
        try{
            return ResponseEntity.ok(service.getFeeder());
        }
        catch (FeederNotFoundException e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity requestCreate(@RequestBody FeederEntity feeder){
        try {
            service.requestCreateFeeder(feeder);
            return ResponseEntity.ok("Request is on moderation");
        }
        catch (FeederAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody FeederEntity newFeeder) {
        try {
            service.updateFeeder(id,newFeeder);
            return ResponseEntity.ok("Feeder updated");
        } catch (FeederNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity requestDelete(@RequestParam Integer id) {
        try {
            service.requestDeleteFeeder(id);
            return ResponseEntity.ok("Request is on moderation");
        } catch (FeederNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
