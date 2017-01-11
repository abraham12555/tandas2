package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Periodo;

public class PerfilModel {
	//lista todos los periodos
		public List<Perfil> getAll(){
			List<Perfil> lst = new ArrayList<Perfil>();
			Session s= HibernateUtil.getSessionFactory().getCurrentSession();
			try{
				s.beginTransaction();
				lst= s.createCriteria(Perfil.class).list();
				s.getTransaction().commit();


			}
			catch(Exception e){
				e.printStackTrace();
	            s.getTransaction().rollback();

			}
			return lst;
		}
		
		// inserta
		public void create (Perfil p){
			List<Perfil> lst = new ArrayList<Perfil>();
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
		
		
		public void remove (Perfil p){
			List<Perfil> lst = new ArrayList<Perfil>();
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
		
		public void update (Perfil p){
			List<Perfil> lst = new ArrayList<Perfil>();
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
		
		public  List<Perfil> edit(Perfil p){
			List<Perfil> lst = new ArrayList<Perfil>();
			Session s= HibernateUtil.getSessionFactory().getCurrentSession();
			try{
				s.beginTransaction();
				p.getIdperfil();
			int idperfil =	p.getIdperfil();
			System.out.println("Hola soy el perfil que estas reciviendo"+p.getIdperfil());
			Query query = s.createQuery("from Perfil where idperfil = :idperfil ");
			query.setParameter("idperfil", idperfil);
		    lst = query.list();

	            s.getTransaction().commit();
	            

			}
			catch(Exception e){
				e.printStackTrace();
	            s.getTransaction().rollback();

			}
			return lst;

		}
		
		public Perfil getPeriodo(BigDecimal id){
			Session s= HibernateUtil.getSessionFactory().getCurrentSession();
			Perfil p= new Perfil();
			try{
				s.beginTransaction();
	            p=(Perfil) s.load(Perfil.class, id);
				s.getTransaction().commit();

			}
			catch(Exception e){
				e.printStackTrace();
	            s.getTransaction().rollback();

			}
			return p;

		}
		
		

}
