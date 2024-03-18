package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Beans.StudentRegistration;

import java.util.List;

public class StudPerCourseSem {

    private static final String PERSISTENCE_UNIT_NAME = "Your_Persistence_Unit_Name";

    public List<StudentRegistration> getStudentsPerCourseAndSemester(String courseCode, String semesterId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<StudentRegistration> query = entityManager.createQuery(
                    "SELECT sr FROM StudentRegistration sr WHERE sr.courseCodes CONTAINS :courseCode AND sr.semesterId.semesterId = :semesterId",
                    StudentRegistration.class);
            query.setParameter("courseCode", courseCode);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
