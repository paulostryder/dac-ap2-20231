package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Incidente;
import util.JPAUtil;

public class IncidenteDao {
	
	public static void salvar(Incidente i) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Incidente i) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Incidente i) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		i = em.find(Incidente.class, i.getId());
		em.remove(i);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static List<Incidente> listarTodos() {
		
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select i from Incidente i");
		@SuppressWarnings("unchecked")
		List<Incidente> list = q.getResultList();
		em.close();
		return list;
	}
	
	
	public static Incidente listarPorId(Integer id) {
	
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Incidente i = em.find(Incidente.class, id);
		em.close();
		return i;
	}	
}
