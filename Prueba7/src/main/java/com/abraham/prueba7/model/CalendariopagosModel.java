package com.abraham.prueba7.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abraham.prueba7.data.Calendariopagos;
import com.abraham.prueba7.data.Ejerce;

public class CalendariopagosModel {
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
