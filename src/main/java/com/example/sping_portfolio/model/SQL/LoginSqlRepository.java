package com.example.sping_portfolio.model.SQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginSqlRepository {

    @Autowired
    private LoginJpaRepository jpa;

    public List<Login> listAll() {
        return jpa.findAll();
    }

    public void save(Login login) {
        jpa.save(login);
    }

}
