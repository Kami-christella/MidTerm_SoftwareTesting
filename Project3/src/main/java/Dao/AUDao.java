package Dao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;
import org.hibernate.*;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import Beans.AcademicUnit;
import Beans.Student;
import Dao.HibernateUtil;

import java.util.*;

public class AUDao {
	
	
public AcademicUnit saveAcademicUnit (AcademicUnit au){
	Transaction transaction =null;
	try {
		 SessionFactory sessionFactory = (SessionFactory) HibernateUtil.getSessionFactory();
		 Session session =(Session) ((org.hibernate.SessionFactory) sessionFactory).openSession();
		 transaction = (Transaction) ((SharedSessionContract) session).beginTransaction();
		 
		 ((org.hibernate.Session) session).save(au);
		 
		 transaction.commit();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	return null;
}
    
    
    
}
