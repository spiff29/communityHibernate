package readAll.community;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;


import readAll.community.entity.*;

public class ReadAll {
	
	@SuppressWarnings("checked")
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Name.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(PhoneNumber.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Name.class);
			criteria.setProjection(Projections.rowCount());
			List names = criteria.list();
			long rowCount = 0;
            if (names!=null) {
                rowCount = (Long) names.get(0);
                System.out.println("Total Results:" + rowCount);
            }
            session.getTransaction().commit();
            
            session = factory.getCurrentSession();
			session.beginTransaction();
			for (long i = 1; i < rowCount + 1; i++) {
				Integer theId = (int) (long) i;
				Address tempAddress = session.get(Address.class, theId);
				PhoneNumber tempPN = session.get(PhoneNumber.class, theId);
				System.out.println(tempAddress + " "+ tempPN);
			}
			session.getTransaction().commit();
			

		}
		finally {
			factory.close();
		}
	}

}
