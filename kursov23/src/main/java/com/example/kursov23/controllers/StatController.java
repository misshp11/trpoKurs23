package com.example.kursov23.controllers;

import com.example.kursov23.models.Person;
import com.example.kursov23.models.Statistics;
import com.example.kursov23.models.Tasks;
import com.example.kursov23.repositories.PeopleRepository;
import com.example.kursov23.repositories.StatRepo;
import com.example.kursov23.repositories.TaskRepo;
import com.example.kursov23.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StatController {

    private int id_su;
    private int id_gr;

    @Autowired
    private StatRepo statRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("/findStatPage")
    public String findStatPage1( Model model) {
        return "findStatPage";
    }

    @PostMapping("/findStatPage")
    public String findStatPage(@RequestParam int id_gr1, int id_su1, Model model){
        try {
            id_gr = id_gr1;
            id_su = id_su1;
        } catch (Exception e) {
            return "admin";
        }
        return "redirect:/showStatistics";
    }

    @GetMapping("/showStatistics")
    public String showStatistics(Model model) {
        List<Tasks> tasks = taskRepo.finTasksByGrSub(id_gr, id_su);
        List<Person> person = peopleRepository.findAllUserByGroup(id_gr);
        System.out.println(tasks.size());
        System.out.println(person.size());
        if (!person.isEmpty()){
            for (int i = 0; i < person.size(); i++){
                float count = 0.0f;
                for (int j = 0 ; j < tasks.size(); j++){
                    if ((tasks.get(j).getId_user() == person.get(i).getId())
                    && (tasks.get(j).getId_group() == person.get(i).getGroup())){
                        count = count + tasks.get(j).getMark();
                    }
                }
                Statistics st = statRepo.finStatBySuUs(person.get(i).getId(), id_su);
                if (st != null){
                    st.setSum_mark(count);
                    statRepo.save(st);
                } else {
                    Statistics newStat = new Statistics();
                    newStat.setSum_mark(count);
                    newStat.setId_subject(id_su);
                    newStat.setId_user(person.get(i).getId());
                    statRepo.save(newStat);
                }
            }
        }
        model.addAttribute("statList1", statRepo.finStatBySuGr(id_su, id_gr));
        return "showStatistics";
    }
}
