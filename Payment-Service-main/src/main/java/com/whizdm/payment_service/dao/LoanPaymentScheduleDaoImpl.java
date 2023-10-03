package com.whizdm.payment_service.dao;

import com.whizdm.payment_service.entity.LoanPaymentSchedule;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LoanPaymentScheduleDaoImpl implements LoanPaymentScheduleDao{

    private EntityManager entityManager;

    @Autowired
    public LoanPaymentScheduleDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void saveInitialSchedule(List<LoanPaymentSchedule> loanPaymentSchedule) {

        Session currentSession = entityManager.unwrap(Session.class);
        for(LoanPaymentSchedule val : loanPaymentSchedule){
            currentSession.saveOrUpdate(val);
        }
    }

    @Override
    @Transactional
    public void updateLoanPaymentSchedule(List<LoanPaymentSchedule> theLoanPaymentSchedule) {

        Session currentSession = entityManager.unwrap(Session.class);
        for(LoanPaymentSchedule val : theLoanPaymentSchedule){
            Query theQuery = currentSession.createQuery("update LoanPaymentSchedule  set paymentUtrId = :payUtrId, status = :payStatus, dueAmount = :dAmount, dateModified = :dModified where id = :Id");

            theQuery.setParameter("payUtrId", val.getPaymentUtrId());
            theQuery.setParameter("payStatus", val.getStatus());
            theQuery.setParameter("dAmount", val.getDueAmount());
            theQuery.setParameter("dModified", val.getDateModified());
            theQuery.setParameter("Id", val.getId());

            theQuery.executeUpdate();
        }
    }

    @Override
    @Transactional
    public List<LoanPaymentSchedule> retrieveLoanPayment(String theLoanApplicationId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from LoanPaymentSchedule where loan_application_id = :Id");
        theQuery.setParameter("Id",theLoanApplicationId);
        List<LoanPaymentSchedule> list = theQuery.getResultList();
        return list;

    }
}
