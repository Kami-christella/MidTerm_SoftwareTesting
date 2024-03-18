package Dao;

import javax.transaction.Transaction;

import org.hibernate.SharedSessionContract;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import Beans.Semester;

public class SemesterDao {

	
	public Semester saveSemester (Semester sem){
		Transaction transaction =null;
		try {
			 SessionFactory sessionFactory = (SessionFactory) HibernateUtil.getSessionFactory();
			 Session session =(Session) ((org.hibernate.SessionFactory) sessionFactory).openSession();
			 transaction = (Transaction) ((SharedSessionContract) session).beginTransaction();
			 
			 ((org.hibernate.Session) session).save(sem);
			 
			 transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
