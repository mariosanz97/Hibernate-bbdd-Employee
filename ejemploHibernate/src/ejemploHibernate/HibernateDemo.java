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

			Query q = session.createQuery("select e from Employee e");
			List results = q.list();

			Iterator homr = results.iterator();
			while (homr.hasNext()) {
				Employee e = (Employee) homr.next();
				System.out.println("		Apellido " + e.getSubName() + " y nombre " + e.getEmpName());

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

			System.out.println("Inicio Consulta");
			Session s5 = HibernateUtil.getSessionFactory().openSession();

			Query q5 = s5.createQuery("select e from Employee e");
			List results5 = q5.list();

			Iterator homr5 = results5.iterator();
			while (homr5.hasNext()) {
				Employee e = (Employee) homr5.next();
				System.out.println("		Apellido " + e.getSubName() + " y nombre " + e.getEmpName() + " id -----> "
						+ e.getEmpId());

			}

			s5.close();

			Session s7 = HibernateUtil.getSessionFactory().openSession();

			System.out.println("Escribe la id de la persona que quieres modificar");
			Scanner sc3 = new Scanner(System.in);
			int id2 = sc3.nextInt();
			System.out.println("Escribe nombre");
			String nombre6 = sc.next();
			System.out.println("Escribe apellido");
			String apellido6 = sc.next();
			Employee empleado = (Employee) s7.get(Employee.class, id2);
			empleado.setEmpName(nombre6);
			empleado.setSubName(apellido6);

			s7.update(empleado);
			s7.getTransaction().commit();
			s7.close();
			System.out.println("up ");

			break;
		case 4:

			System.out.println("Inicio Consulta");
			Session s4 = HibernateUtil.getSessionFactory().openSession();

			Query q4 = s4.createQuery("select e from Employee e");
			List results4 = q4.list();

			Iterator homr4 = results4.iterator();
			while (homr4.hasNext()) {
				Employee e = (Employee) homr4.next();
				System.out.println("		Apellido " + e.getSubName() + " y nombre " + e.getEmpName() + " id -----> "
						+ e.getEmpId());

			}
			s4.close();

			// System.out.println("Fin Consulta");

			System.out.println("Inicio Borrado");
			Session s3 = HibernateUtil.getSessionFactory().openSession();
			s3.beginTransaction();

			System.out.println("Escribe la id de la persona que quieres borrar");
			Scanner sc2 = new Scanner(System.in);
			int id = sc2.nextInt();

			Query q2 = s3.createQuery("delete from Employee where id = " + id + "");
			q2.executeUpdate();

			s3.getTransaction().commit();
			s3.close();
			System.out.println("Fin Borrado");

			break;
		default:
			break;
		}
		/*
		 * Employee e = new Employee(); e.setEmpId(1); e.setEmpName("Ana");
		 * e.setSubName("Roman"); SessionFactory sf = new
		 * Configuration().configure().buildSessionFactory(); Session s =
		 * sf.openSession(); s.beginTransaction(); s.save(e);
		 * s.getTransaction().commit(); s.close(); System.exit(0);
		 */

	}

}