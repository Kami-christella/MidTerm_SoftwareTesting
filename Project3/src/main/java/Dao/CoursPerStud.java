package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Beans.Course;
import Beans.Student;

import java.util.List;

public class CoursPerStud {

    private static final String PERSISTENCE_UNIT_NAME = "Your_Persistence_Unit_Name";

    public List<Course> getCoursesPerStudent(int studentId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Course> query = entityManager.createQuery(
                    "SELECT sr.student.courses FROM StudentRegistration sr WHERE sr.student.studentId = :studentId",
                    Course.class);
            query.setParameter("studentId", studentId);
            return query.getResultList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    
}
