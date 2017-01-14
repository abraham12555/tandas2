package com.abraham.prueba7.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abraham.prueba7.data.Calendariopagos;
import com.abraham.prueba7.data.Pago;

public class PagoModel {
	// // lista todos los involucrados
	public List<Pago> getAll() {
		List<Pago> lst = new ArrayList<Pago>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {

			s.beginTransaction();
			Query query = s.createQuery("from Pago");
			lst = query.list();

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return lst;
	}

	public List<Calendariopagos> getAllCP() {
		List<Calendariopagos> lst = new ArrayList<Calendariopagos>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {

			s.beginTransaction();
			Query query = s.createQuery("from Calendariopagos");
			lst = query.list();

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return lst;
	}

	//
	// inserta
	public void create(Pago p) {
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

	//
	// // eliminar
	//
	public void remove(Pago p) {
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

	// // update
	//
	public void updateP(Pago p) {
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

	public List<Pago> edit(Pago p) {
		List<Pago> lst = new ArrayList<Pago>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			p.getIdpago();
			int idpago = p.getIdpago();
			Query query = s.createQuery("from Pago where idpago = :idpago ");
			query.setParameter("idpago", idpago);
			lst = query.list();

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return lst;

	}

}
