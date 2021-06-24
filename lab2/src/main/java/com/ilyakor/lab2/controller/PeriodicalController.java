package com.ilyakor.lab2.controller;

import com.ilyakor.lab2.dto.PeriodicalRequest;
import com.ilyakor.lab2.entity.Periodical;
import com.ilyakor.lab2.repository.PeriodicalRepo;
import com.ilyakor.lab2.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/periodicals")
public class PeriodicalController {

    @Autowired
    private PeriodicalService service;

    @GetMapping
    public ResponseEntity<List<Periodical>> getAllPeriodicals(){
        return ResponseEntity.ok(service.getAllPeriodicals());
    }

    @PostMapping
    public ResponseEntity<Periodical> addPeriodical(@RequestBody PeriodicalRequest periodical){
        System.out.println(periodical.getName());
        return ResponseEntity.ok(service.addPeriodical(periodical));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periodical> getPeriodical(@PathVariable long id){
        Periodical periodical =  service.getPeriodical(id);
        if(periodical==null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(periodical);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Periodical> updatePeriodical(@PathVariable long id, @RequestBody PeriodicalRequest periodical){
        Periodical updatedPeriodical =  service.updatePeriodical(id,periodical);
        if(updatedPeriodical==null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(updatedPeriodical);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeriodical(@PathVariable long id){
        service.deletePeriodical(id);
        return ResponseEntity.ok().build();
    }

}
