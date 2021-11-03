package com.example.hibernatepractice;

import com.example.hibernatepractice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int employeeId = 3;

            /*session.beginTransaction();

            Employee employee = session.get(Employee.class, employeeId);

            session.delete(employee);

            session.getTransaction().commit();*/

            session.beginTransaction();

            session.createQuery("DELETE FROM Employee where id=4").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            sessionFactory.close();
        }
    }
}
