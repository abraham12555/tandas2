package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abraham.prueba7.data.Ejerce;
import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.data.Usuario;;

public class Prueba {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try{
			Transaction tx = session.beginTransaction();

EjerceModel model= new EjerceModel();
model.siguiente();
System.out.println(model.siguiente());

        }

		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	// TODO Auto-generated method stub

	}

}
