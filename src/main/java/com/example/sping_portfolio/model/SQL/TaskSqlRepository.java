package com.example.sping_portfolio.model.SQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskSqlRepository {

    @Autowired
    private TaskJpaRepository jpa;

    public List<Task> listAll() {
        return jpa.findAll();
    }

    public void save(Task task) {
        jpa.save(task);
    }


    public Task get(long id) {
        return jpa.findById(id).get();
    }

}
