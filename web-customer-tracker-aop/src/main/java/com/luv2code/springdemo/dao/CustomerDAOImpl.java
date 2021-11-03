package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(int theSortField) {

        Session currentSession = sessionFactory.getCurrentSession();

        String theFieldName = null;

        switch (theSortField) {
            case SortUtils.FIRST_NAME:
                theFieldName = "firstName";
                break;
            case SortUtils.LAST_NAME:
                theFieldName = "lastName";
                break;
            case SortUtils.EMAIL:
                theFieldName = "email";
                break;
            default:
                theFieldName = "lastName";
        }

        String queryString = "from Customer order by " + theFieldName;
        Query<Customer> theQuery =
                currentSession.createQuery(queryString, Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;

    }

    @Override
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int theId) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, theId);

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query theQuery = session.createQuery("delete from Customer WHERE id=:customerId");
        theQuery.setParameter("customerId",theId);


        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        Session session = sessionFactory.getCurrentSession();

        Query theQuery = null;

        if(theSearchName != null && theSearchName.trim().length() > 0){
            theQuery = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            theQuery =session.createQuery("from Customer", Customer.class);
        }

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }
}
