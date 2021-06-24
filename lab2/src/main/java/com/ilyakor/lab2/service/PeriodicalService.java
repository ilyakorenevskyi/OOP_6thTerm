package com.ilyakor.lab2.service;

import com.ilyakor.lab2.entity.Periodical;
import com.ilyakor.lab2.repository.PeriodicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodicalService {

    @Autowired
    private PeriodicalRepo repo;


    public List<Periodical> getAllPeriodicals(){
        List<Periodical> periodicals;
        periodicals = (List<Periodical>) repo.findAll();
        return periodicals;
    }

    public Periodical getPeriodical(long id){
        return repo.findById(id).orElse(null);
    }


    public Periodical addPeriodical(Periodical periodical){
        if(repo.existsById(periodical.getId())){
            return null;
        }
        else {
            repo.save(periodical);
            return periodical;
        }
    }

    public void deletePeriodical(long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Periodical doesn't exist");
        }
        else {
            repo.deleteById(id);
        }
    }

    public Periodical updatePeriodical(Periodical periodical){
        Periodical old = repo.findById(periodical.getId()).orElse(null);
        if(old == null) return null;
        else{
            old.copyFields(periodical);
            repo.save(old);
        }
        return old;
    }

}
