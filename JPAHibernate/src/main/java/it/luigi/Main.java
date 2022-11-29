package it.luigi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("luigiMysql");

	public static void main(String[] args) {

		create(7, "Luigi", 26, 654321, "Maltese", 2);
		//update(1, "sergio", 50); 	
		//delete(1);

		/*List<Studente> studenti = readAll();
		if (studenti != null) {
			for (Studente studente : studenti) {
				System.out.println(studente);
			}
		}*/

		ENTITY_MANAGER_FACTORY.close();
	}



	public static void create(int id, String name, int age,int microchip,String razza, int eta) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();

			Studente stu = new Studente();
			stu.setId(id);
			stu.setNome(name);
			stu.setEta(age);
			
			Animale animale = new Animale();
			animale.setMicrochip(microchip);
			animale.setRazza(razza);
			animale.setEta(eta);

			manager.persist(stu);
			manager.persist(animale);
			transaction.commit();
			
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}


	public static List<Studente> readAll() {

		List<Studente> students = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();
			
			students = manager.createNativeQuery("SELECT * FROM Studente").getResultList();
			//students = manager.createQuery("SELECT s FROM Studente s", Studente.class).getResultList();

			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
		return students;
	}


	public static void delete(int id, int microchip) {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();

			Studente stu = manager.find(Studente.class, id);
			
			Animale animale = manager.find(Animale.class, microchip);

			manager.remove(stu);
			manager.remove(animale);

			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}


	public static void update(int id, String name, int age) {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();
			transaction.begin();

			Studente stu = manager.find(Studente.class, id);
			stu.setNome(name);
			stu.setEta(age);
			manager.persist(stu);
			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}
}
