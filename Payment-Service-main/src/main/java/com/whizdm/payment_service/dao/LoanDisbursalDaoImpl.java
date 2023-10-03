package com.whizdm.payment_service.dao;

import com.whizdm.payment_service.entity.LoanDisbursal;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class LoanDisbursalDaoImpl implements LoanDisbursalDao{

    private EntityManager entityManager;

    @Autowired
    public LoanDisbursalDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void saveLoanDisbursal(LoanDisbursal loanDisbursal) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(loanDisbursal);
    }
}
