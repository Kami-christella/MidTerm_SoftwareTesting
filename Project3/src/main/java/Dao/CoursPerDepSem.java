package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Beans.Course;

import java.util.List;

public class CoursPerDepSem {

    private static final String PERSISTENCE_UNIT_NAME = "Your_Persistence_Unit_Name";

    public List<Course> getCoursesPerDepartmentAndSemester(String departmentId, String semesterId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Course> query = entityManager.createQuery(
                    "SELECT c FROM Course c WHERE c.department.academicId = :departmentId AND c.semester.semesterId = :semesterId",
                    Course.class);
            query.setParameter("departmentId", departmentId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
