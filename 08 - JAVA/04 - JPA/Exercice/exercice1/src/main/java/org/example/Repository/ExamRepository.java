package org.example.Repository;

import org.example.entity.Exam;

import javax.persistence.EntityManager;

public class ExamRepository extends BaseRepository<Exam> {
    public ExamRepository(EntityManager em) {
        super(em);
    }
}
