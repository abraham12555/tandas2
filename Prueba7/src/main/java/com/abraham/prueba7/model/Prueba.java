package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abraham.prueba7.data.Periodo;;

public class Prueba {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try{
			Transaction tx = session.beginTransaction();

	        Periodo p = new Periodo();
	        Query query = session.createQuery("from Usuario where nombreu = :nombreu ");
	        query.setParameter("nombreu", "Juan");
	        List list = query.list();
	        System.out.println(list.get(0));
	        int size=list.size();
	        for(int x=0;x<list.size();x++) {
	            System.out.println(list.get(x));
	          }
        }

		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	// TODO Auto-generated method stub

	}

}
