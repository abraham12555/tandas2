package com.abraham.prueba7.model;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.abraham.prueba7.data.Periodo;

public class PeriodoModel {
	//lista todos los periodos
	public List<Periodo> getAll(){
		List<Periodo> lst = new ArrayList<Periodo>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
			lst= s.createCriteria(Periodo.class).list();
			s.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;
	}
	
	// inserta
	public void create (Periodo p){
		List<Periodo> lst = new ArrayList<Periodo>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
            s.save(p);		
            s.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}

	}
	
	//eliminar
	
	
	public void remove (Periodo p){
		List<Periodo> lst = new ArrayList<Periodo>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
            s.delete(p);
            s.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}

	}
	//update 
	
	public void update (Periodo p){
		List<Periodo> lst = new ArrayList<Periodo>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
            s.update(p);
            s.getTransaction().commit();

		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}

	}
	
	public  List<Periodo> edit(Periodo p){
		List<Periodo> lst = new ArrayList<Periodo>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
			p.getIdperiodo();
		System.out.println("Hola soy el idperiodo que estas reciviendo"+p.getIdperiodo());
		int idperiodo =p.getIdperiodo();
		Query query = s.createQuery("from Periodo where idperiodo = :idperiodo ");
		query.setParameter("idperiodo", idperiodo);
	    lst = query.list();

            s.getTransaction().commit();
            

		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;

	}
	
	public Periodo getPeriodo(BigDecimal id){
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		Periodo p= new Periodo();
		try{
			s.beginTransaction();
            p=(Periodo) s.load(Periodo.class, id);
			s.getTransaction().commit();

		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return p;

	}
	
	
	
	

}
