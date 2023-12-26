package com.example.kursov23.services;

import com.example.kursov23.models.Statistics;
import com.example.kursov23.repositories.StatRepo;
import com.example.kursov23.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatServiceImpl implements StatService{

    @Autowired
    private StatRepo statRepo;

    @Override
    public Statistics getStatById(int id) {
        Optional<Statistics> optional = statRepo.findById(id);
        Statistics statistics = null;
        if (optional.isPresent()){
            statistics = optional.get();
        }else {
            throw  new RuntimeException("Person not Found for id ::" + id);
        }
        return statistics;
    }

    @Override
    public List<Statistics> getAllStat() {
        return statRepo.findAll();
    }

    @Override
    public void saveStat(Statistics statistics) {
        this.statRepo.save(statistics);
    }

    @Override
    public void deleteStatById(int id) {
        this.statRepo.deleteById(id);
    }
}
