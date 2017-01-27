package ejemploHibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Employee;
import java.util.List;

public class HibernateDemo {

	public static void main(String[] args) {

		System.out.println(".......................... \n" + ".  1 Leer \n" + ".  2 Insert  \n" + ".  3 Update \n"
				+ ".  4 Delete \n");

		Scanner sc = new Scanner(System.in);
		int keyS = sc.nextInt();

		switch (keyS) {
		case 1:
			System.out.println("Inicio Consulta");
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	
	        Query q= session.createQuery("select e from Employee e");
	        List results = q.list();
	        
	        Iterator homr= results.iterator();
	        while (homr.hasNext()){
	            Employee e = (Employee)homr.next();
	        	System.out.println ( "		Apellido: " + e.getSubName()+" apellido " + e.getEmpName());
	            
	        }
	 
	        session.close(); 

	    	System.out.println("Fin Consulta");
	    	
			break;
		case 2:

			System.out.println("Escribe tu nombre");
			String nombre = sc.next();

			System.out.println("Escribe tu apellido");
			String apellido = sc.next();

			Employee e2 = new Employee();
			e2.setEmpId(1);
			e2.setEmpName(nombre);
			e2.setSubName(apellido);
			SessionFactory sf2 = new Configuration().configure().buildSessionFactory();
			Session s2 = sf2.openSession();
			s2.beginTransaction();
			s2.save(e2);
			s2.getTransaction().commit();
			s2.close();

			break;
		case 3:

			break;
		default:
			break;
		}
/*
		Employee e = new Employee();
		e.setEmpId(1);
		e.setEmpName("Ana");
		e.setSubName("Roman");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(e);
		s.getTransaction().commit();
		s.close();
		System.exit(0);
*/
		
		
	}

}