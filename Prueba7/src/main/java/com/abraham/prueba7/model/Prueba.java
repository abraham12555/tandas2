
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

import com.abraham.prueba7.data.Involucrado;
import com.abraham.prueba7.data.Pago;



public class Prueba {

	public static void main(String[] args) throws ParseException {
        Date dinicio = null, dfinal = null;
        long milis1, milis2, diff;
		List<Pago> lst = new ArrayList<Pago>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			
			Query query = s.createQuery("from Pago as pago where pago.calendariopagos.tanda=2 and pago.involucrado.tanda=2 order by pago.calendariopagos.pagon asc");
	
		
			lst = query.list();
			List<Pago> pago = query.list();

			for (Pago c : pago) {
				System.out.println("Numero de pago " + c.getCalendariopagos().getPagon());
					
			//System.out.println("idpago " + c.getIdpago());
		
			System.out.println("idit-> " + c.getInvolucrado().getUsuario().getNombreu()+c.getInvolucrado().getUsuario().getApu()+c.getInvolucrado().getUsuario().getAmu());

			System.out.println("Fecha inicio" + c.getCalendariopagos().getFip());
			System.out.println("Fecha final " + c.getCalendariopagos().getFfp());
			System.out.println("Fecha en que pago " + c.getFpago());
		 

            
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(c.getCalendariopagos().getFfp());
            calendar2.setTime(c.getFpago());
            long milsecs1= calendar1.getTimeInMillis();
            long milsecs2 = calendar2.getTimeInMillis();
            long diff2 =  milsecs1-milsecs2;
            long dsecs = diff2 / 1000;
            long dminutes = diff2 / (60 * 1000);
            long dhours = diff2 / (60 * 60 * 1000);
           double ddays = diff2 / (24 * 60 * 60 * 1000);

            System.out.println("Your Day Difference="+ddays);
			}

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}

	}
}



