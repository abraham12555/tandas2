package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Usuario;

public class UsuarioModel {
	//lista todos los periodos
	public List<Usuario> getAll(){
		List<Usuario> lst = new ArrayList<Usuario>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
			lst= s.createCriteria(Usuario.class).list();
			s.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;
	}
	
	// inserta
	public void create (Usuario p){
		List<Usuario> lst = new ArrayList<Usuario>();
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
	
	
	public void remove (Usuario p){
		List<Usuario> lst = new ArrayList<Usuario>();
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
	
	public void update (Usuario p){
		List<Usuario> lst = new ArrayList<Usuario>();
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
	
	
	
	public Usuario getPeriodo(BigDecimal id){
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		Usuario p= new Usuario();
		try{
			s.beginTransaction();
            p=(Usuario) s.load(Usuario.class, id);
			s.getTransaction().commit();

		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return p;

	}
	
	
	public  List<Usuario> edit(Usuario p){
		List<Usuario> lst = new ArrayList<Usuario>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
			p.getIduser();
		int iduser =p.getIduser();

		System.out.println("Hola soy el perfil que estas reciviendo"+p.getIduser());
		Query query = s.createQuery("from Usuario where iduser = :iduser ");
		query.setParameter("iduser", iduser);
	    lst = query.list();

            s.getTransaction().commit();
            

		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;

	}

}
