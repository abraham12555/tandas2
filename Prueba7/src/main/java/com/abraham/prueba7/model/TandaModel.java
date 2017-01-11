package com.abraham.prueba7.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.abraham.prueba7.data.Ejerce;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.data.Usuario;

public class TandaModel {
	public void create (Tanda t){
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
            s.save(t);		
            s.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}

	}
	
	public List<Tanda> todasTandas() {
		List<Tanda> lst = new ArrayList<Tanda>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
		s.beginTransaction();
		Query query = s.createQuery("from Tanda");
		lst = query.list();


		List<Tanda> tanda = query.list();

		for (Tanda c : tanda) {
			  System.out.print("id Tanda " + c.getIdtanda()); 
	            System.out.print("Monto " + c.getMonto()); 
	            System.out.print("Estatus " + c.getEstatus()); 
	            System.out.print("Numero de pagos " + c.getNpagos()); 

	            System.out.print("nombre periodo " + c.getPeriodo().getPeriodo()); 
		}
		s.getTransaction().commit();
		} catch (Exception e) {
		e.printStackTrace();
		s.getTransaction().rollback();

		} return lst;
		}
	
	  
	   public  List<Tanda> edit(Tanda t){
			List<Tanda> lst = new ArrayList<Tanda>();
			Session s= HibernateUtil.getSessionFactory().getCurrentSession();
			try{
				s.beginTransaction();
t.getIdtanda();
int idtanda =t.getIdtanda();

			System.out.println("Hola soy el perfil que estas reciviendo"+t.getIdtanda());
			Query query = s.createQuery("from Tanda where idtanda = :idtanda ");
			query.setParameter("idtanda", idtanda);
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
