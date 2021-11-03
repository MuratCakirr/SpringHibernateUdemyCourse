package com.example.hibernatepractice;

import com.example.hibernatepractice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Employee employee = new Employee("Yesim","Çakır","Teias");

            session.beginTransaction();

            System.out.println("Employee Id: " + employee.getId());

            session.save(employee);

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            System.out.println("Employee Id: " + employee.getId());
            Employee myEmployee = session.get(Employee.class, employee.getId());

            System.out.println(myEmployee);

            session.getTransaction().commit();

        }
        finally {
            sessionFactory.close();
        }
    }
}
