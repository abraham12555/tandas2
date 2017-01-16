
package com.abraham.prueba7.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.util.SocketUtils;

import com.abraham.prueba7.data.Calendariopagos;
import com.abraham.prueba7.data.Ejerce;
import com.abraham.prueba7.data.Involucrado;
import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.data.Usuario;;

public class Prueba {

	public static void main(String[] args) throws ParseException {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		try{ 
int idtanda=1;
session.beginTransaction();
   	     SQLQuery query =  session.createSQLQuery("select involucrado.idit,involucrado.numerot,tanda.idtanda,"
   	     		+ "usuario.nombreu,usuario.apu,usuario.amu,calendariopagos.pagon as numerodepago ,"
   	     		+ "calendariopagos.fip,calendariopagos.ffp,pago.fpago as fechaquepago,calendariopagos.ffp-pago.fpago as dif"
   	     		+ " from involucrado , usuario , tanda ,pago ,calendariopagos where usuario.iduser=involucrado.iduser"
   	     		+ " and tanda.idtanda=involucrado.idtanda and pago.idit = involucrado.idit"
   	     		+ " and pago.idcp=calendariopagos.idcp and tanda.idtanda="+idtanda+" order by calendariopagos.pagon asc");

   	     List<Object[]> rows = query.list();

   	     for(Object[] row : rows){
   	        
	        
 	        int idinvolucrado = Integer.parseInt(row[0].toString());
 	       int pago = Integer.parseInt(row[6].toString());

 	        String nombre = row[3].toString()+row[4].toString()+row[5].toString();

      	     System.out.println("id involucrado= "+ idinvolucrado+ nombre + pago);

   	    
   	     //System.out.println("fecha"+ nuevaFecha);
   	     }

   	     session.getTransaction().commit();
   	     
   	     
   	    
   	     

   	     }
		
   	     catch(Exception e){
   	        e.printStackTrace();
   	              session.getTransaction().rollback();

   	      }
    


	}
}



