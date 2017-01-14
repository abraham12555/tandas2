package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abraham.prueba7.data.Calendariopagos;
import com.abraham.prueba7.data.Involucrado;
import com.abraham.prueba7.data.Tanda;

public class InvolucradoModel {
	// lista todos los involucrados
	public List<Involucrado> getAll() {
		List<Involucrado> lst = new ArrayList<Involucrado>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {

			s.beginTransaction();
			Query query = s.createQuery("from Involucrado");
			lst = query.list();
			List<Involucrado> ejerce = query.list();

			for (Involucrado c : ejerce) {
				System.out.println("id usuario-> " + c.getUsuario().getIduser());
				System.out.println(
						"usuario-> " + c.getUsuario().getNombreu() + c.getUsuario().getAmu() + c.getUsuario().getApu());

			}

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return lst;
	}
	public List<Tanda> getAllTanda(){
		List<Tanda> lst = new ArrayList<Tanda>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
		      Query query = s.createQuery("from Tanda");
		      lst = query.list();
		      s.getTransaction().commit();
				
		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;
	}

	// inserta
	public void create(Involucrado p) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.save(p);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}

	}

	// eliminar

	public void remove(Involucrado p) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.delete(p);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}

	}
	// update

	public void update(Involucrado p) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.update(p);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}

	}

	public Involucrado getPeriodo(BigDecimal id) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Involucrado p = new Involucrado();
		try {
			s.beginTransaction();
			p = (Involucrado) s.load(Involucrado.class, id);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return p;

	}

	public List<Involucrado> edit(Involucrado p) {
		List<Involucrado> lst = new ArrayList<Involucrado>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			p.getIdit();
			int idit = p.getIdit();
			Query query = s.createQuery("from Involucrado where idit = :idit ");
			query.setParameter("idit", idit);
			lst = query.list();

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return lst;

	}
	
	
	public List<Calendariopagos> todoCalendariopagos(int idtanda) {
		List<Calendariopagos> lst = new ArrayList<Calendariopagos>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
		s.beginTransaction();
		Query query = s.createQuery("from Calendariopagos where idtanda="+idtanda+"");
		lst = query.list();


		List<Calendariopagos> calendariopagos = query.list();

		for (Calendariopagos c : calendariopagos) {
		System.out.println("id cp-> " + c.getIdcp());
		System.out.println("No pago-> " + c.getPagon());
		System.out.println("fecha inicio-> " + c.getFip());
		System.out.println("fecha final-> " + c.getFfp());

		System.out.println("idtanda-> " + c.getTanda().getIdtanda());

		}
		s.getTransaction().commit();
		} catch (Exception e) {
		e.printStackTrace();
		s.getTransaction().rollback();

		} return lst;
		}

}