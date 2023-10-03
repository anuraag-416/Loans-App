package com.whizdm.payment_service.dao;

import com.whizdm.payment_service.entity.LoanPayment;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class LoanPaymentDaoImpl implements LoanPaymentDao{

    private EntityManager entityManager;

    @Autowired
    public LoanPaymentDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void saveLoanPayment(LoanPayment loanPayment) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(loanPayment);
    }
}
