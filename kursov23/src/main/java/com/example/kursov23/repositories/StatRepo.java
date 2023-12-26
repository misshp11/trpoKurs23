package com.example.kursov23.repositories;

import com.example.kursov23.models.StatDTO;
import com.example.kursov23.models.Statistics;
import com.example.kursov23.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepo extends JpaRepository<Statistics, Integer> {
    @Query("SELECT new com.example.kursov23.models.StatDTO(s, p.name, p.surname, st.group_name, su.name) FROM Statistics s JOIN Person p on s.id_user = p.id JOIN Stugroup st on p.id_group = st.id JOIN Subject su on s.id_subject = su.id WHERE s.id_user = :id_user")
    List<StatDTO> finStatById(Integer id_user);

    @Query("SELECT new com.example.kursov23.models.StatDTO(s, p.name, p.surname, st.group_name, su.name) FROM Statistics s JOIN Person p on s.id_user = p.id JOIN Stugroup st on p.id_group = st.id JOIN Subject su on s.id_subject = su.id WHERE s.id_subject = :id_su AND p.id_group = :id_gr")
    List<StatDTO> finStatBySuGr(int id_su, int id_gr);

    @Query("SELECT s FROM Statistics s WHERE s.id_user = :id_user AND s.id_subject = :id_su")
    Statistics finStatBySuUs(int id_user, int id_su);

    List<Statistics> findAll();
}
