package com.example.kursov23.services;

import com.example.kursov23.models.Statistics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatService {
    Statistics getStatById(int id);
    List<Statistics> getAllStat();
    void saveStat(Statistics stat);
    void deleteStatById(int id);
}
