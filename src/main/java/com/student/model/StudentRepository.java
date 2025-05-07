package com.student.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentVO, Integer> {

    @Modifying
    @Transactional
    @Query(value="UPDATE student SET eng=?1, math=?2 WHERE  no=?3", nativeQuery = true)
    void updateScores(Integer eng, Integer math, Integer no);

}
