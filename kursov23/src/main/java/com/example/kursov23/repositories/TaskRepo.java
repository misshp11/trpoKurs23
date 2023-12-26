package com.example.kursov23.repositories;

import com.example.kursov23.models.TaskDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.kursov23.models.Tasks;

import java.util.List;

public interface TaskRepo extends CrudRepository<Tasks, Integer> {
    List<Tasks> findAll();

    @Query("SELECT new com.example.kursov23.models.TaskDTO(t, g.group_name, p.surname, p.name, su.name) FROM Tasks t JOIN Stugroup g on t.id_group = g.id JOIN Person p on t.id_user = p.id JOIN Subject su on t.id_subject = su.id WHERE t.id_group = :id_gr and t.id_subject = :id_su")
    List<TaskDTO> finTasksByGroupSub(int id_gr, int id_su);

    @Query("SELECT t FROM Tasks t WHERE t.id_group = :id_gr and t.id_subject = :id_su")
    List<Tasks> finTasksByGrSub(int id_gr, int id_su);
}
