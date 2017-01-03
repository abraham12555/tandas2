package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.util.SocketUtils;

import com.abraham.prueba7.data.Ejerce;
import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.data.Usuario;;

public class Prueba {

	public static void main(String[] args) {
		 Session session = HibernateUtil.getSessionFactory().openSession();

		 try{
	          session.beginTransaction();
	         List lista = session.createQuery("FROM Ejerce").list(); 
	         for (Iterator iterator = lista.iterator(); iterator.hasNext();){
	            Ejerce ejerce = (Ejerce) iterator.next(); 
	            Perfil perfil = new Perfil();
				 perfil=ejerce.getPerfil();
				 Usuario usuario = new Usuario();
				 usuario=ejerce.getUsuario();
	            System.out.print("Id ejerce " + ejerce.getIdejerce()); 
	            System.out.print("  NombrePerfil " + perfil.getPerfil()); 
	            System.out.println("  Nombre completo " + usuario.getNombreu()+usuario.getApu()+usuario.getAmu()); 
	         }
			 session.getTransaction().commit();
			 }catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	// TODO Auto-generated method stub

	}

}
