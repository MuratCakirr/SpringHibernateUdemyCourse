package com.example.hibernatepractice;

import com.example.hibernatepractice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int employeeId = 5;

            session.beginTransaction();

            Employee employee = session.get(Employee.class, employeeId);

            employee.setCompany("OBSS");

            session.getTransaction().commit();

        }
        finally {
            sessionFactory.close();
        }
    }
}
