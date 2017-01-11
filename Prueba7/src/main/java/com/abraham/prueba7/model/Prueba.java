package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public static void main(String[] args) throws ParseException {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 List lista = session.createQuery("FROM Tanda").list(); 
         for (Iterator iterator = lista.iterator(); iterator.hasNext();){
            Tanda tanda = (Tanda) iterator.next(); 
      
            System.out.print("Id ejerce " + tanda.getIdtanda()); 
            System.out.print("  NombrePerfil " + tanda.getMonto()); 
            System.out.println("  Nombre completo " +tanda.getPeriodo().getPeriodo()); 
			 session.getTransaction().commit();
	// TODO Auto-generated method stub
         }
	}

}
