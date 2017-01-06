package com.abraham.prueba7.model;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.abraham.prueba7.data.Ejerce;
import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Usuario;

public class EjerceModel {

	
	public List<Ejerce> todoEjerce() {
		List<Ejerce> lst = new ArrayList<Ejerce>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
		s.beginTransaction();
		Query query = s.createQuery("from Ejerce");
		lst = query.list();


		List<Ejerce> ejerce = query.list();

		for (Ejerce c : ejerce) {
		System.out.println("id ejerce-> " + c.getIdejerce());
		System.out.println("id usuario-> " + c.getUsuario().getIduser());
		System.out.println("usuario-> " + c.getUsuario().getNombreu()+ c.getUsuario().getAmu()+ c.getUsuario().getApu());
		System.out.println("perfil-> " + c.getPerfil().getPerfil());
		}
		s.getTransaction().commit();
		} catch (Exception e) {
		e.printStackTrace();
		s.getTransaction().rollback();

		} return lst;
		}
     
 	
     public List<Ejerce> siguiente(){
		List<Ejerce> lst = new ArrayList<Ejerce>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
			Query query = s.createQuery("select a.idejerce from Ejerce a order by a.idejerce desc").setMaxResults(1);
			lst=query.list();
	
			s.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;
	}
     
     
     public void create (Ejerce ee){
			List<Perfil> lst = new ArrayList<Perfil>();
			Session s= HibernateUtil.getSessionFactory().getCurrentSession();
			try{
				s.beginTransaction();
	            s.save(ee);		
	            s.getTransaction().commit();


			}
			catch(Exception e){
				e.printStackTrace();
	            s.getTransaction().rollback();

			}

		}
     
 	public void remove (Ejerce ee){
		List<Usuario> lst = new ArrayList<Usuario>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
            s.delete(ee);
            s.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}

	}
	
	

}
