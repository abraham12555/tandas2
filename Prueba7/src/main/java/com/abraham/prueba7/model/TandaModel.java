package com.abraham.prueba7.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abraham.prueba7.data.Tanda;

public class TandaModel {

	// lista todos los periodos
	public List<Tanda> getAll() {
		List<Tanda> lst = new ArrayList<Tanda>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Transaction tx = s.beginTransaction();

			Query query = s.createQuery("from Tanda");
			lst = query.list();

			for (Tanda c : lst) {
				System.out.println("id tanda-> " + c.getIdtanda());
				System.out.println("id periodo-> " + c.getPeriodo().getPeriodo());

			}
			tx.commit();
		  

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}
		return lst;
	}

	// inserta
	public void create(Tanda t) {
		List<Tanda> lst = new ArrayList<Tanda>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			System.out.println("Id tanda a instertar"+t.getIdtanda());
			s.save(t);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();

		}

	}
	//Eliminar Tanda
	public void remove (Tanda p){
		List<Tanda> lst = new ArrayList<Tanda>();
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
	
	
	public void borrarcalendario(int idtanda){
	
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			 Query query2 = session.createSQLQuery("delete from calendariopagos where idtanda="+idtanda+"");
    	     
	         query2.executeUpdate();
	         session.getTransaction().commit();


		}
		catch(Exception e){
			e.printStackTrace();
            session.getTransaction().rollback();

		}
		

	}
	//Actualizar tanda
	
	public void update (Tanda t){
		List<Tanda> lst = new ArrayList<Tanda>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			s.beginTransaction();
            s.update(t);
            s.getTransaction().commit();

		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}

	}
	
	public  List<Tanda> edit(Tanda t){	
		List<Tanda> lst = new ArrayList<Tanda>();
		Session s= HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			Transaction tx = s.beginTransaction();

			s.beginTransaction();
			t.getIdtanda();
		int idtanda =	t.getIdtanda();
		System.out.println("Hola soy el tanda que estas reciviendo"+t.getIdtanda());
		Query query = s.createQuery("From Tanda where idtanda =:idtanda ");  
		query.setParameter("idtanda", idtanda);
	    lst = query.list();
	    
	    for (Tanda c : lst) {
			System.out.println("id tanda-> " + c.getIdtanda());
			System.out.println("id periodo-> " + c.getPeriodo().getPeriodo());

		}

	    tx.commit();
            
		}
		catch(Exception e){
			e.printStackTrace();
            s.getTransaction().rollback();

		}
		return lst;

	}
	
	
	
	
	public void crearcalendario(int idtanda) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	     int intervalodias =0;
	     int npagos =0;
	     String fecha = null;
	          Date fechaguardada = null;
	          Date nuevaFecha=null;
	          try{ 

	        	     SQLQuery query =  session.createSQLQuery("select tanda.idtanda, tanda.npagos, periodo.periodo, tanda.finicio,tanda.ffinal,periodo.intervalo from tanda,"
	        	         + " periodo where periodo.idperiodo=tanda.idperiodo and tanda.idtanda="+idtanda+" ");

	        	     List<Object[]> rows = query.list();
	        	     for(Object[] row : rows){
	        	        session.beginTransaction();

	        	        fecha= row[3].toString();
	        	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
	        	         String finicio = row[3].toString();
	        	            // Date date = formatter.parse(finicio);
	        	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	        	        Date fecha1= sdf.parse(row[3].toString());
	        	        
	        	  
	        	       intervalodias = Integer.parseInt(row[5].toString());
	        	       npagos=Integer.parseInt(row[1].toString());
	        	        idtanda = Integer.parseInt(row[0].toString());

	        	     //  tanda.setFinicio(date);
	        	       
	        	       
	        	       Calendar cal = Calendar.getInstance();
	        	            cal.setTime(fecha1);
	        	             nuevaFecha = cal.getTime();
	        	            System.out.println(nuevaFecha);
	        	    
	        	     //System.out.println("fecha"+ nuevaFecha);
	        	     }
	        	     System.out.println("dias = "+ intervalodias+ "Numero de pagos "+npagos+"fecha inicio "+fecha+"id tanda"+idtanda);

	        	     for (int i=1 ; i<=npagos; i++){

	        	             if(i==1)
	        	            {
	        	              Calendar cal = Calendar.getInstance();
	        	                cal.setTime(nuevaFecha);
	        	                cal.add(Calendar.DATE, intervalodias);
	        	                fechaguardada = cal.getTime();
	        	               System.out.println("Primera insert fecha inicio "+ nuevaFecha+ " fecha mas  dias "+fechaguardada);
	        	               
	        	               SimpleDateFormat formatoddmmyy = new SimpleDateFormat("yyyy-MM-dd");
	        	               String fecha1,fecha2;
	        	                 fecha1=formatoddmmyy.format(nuevaFecha);
	        	                 fecha2=formatoddmmyy.format(fechaguardada);

	        	             System.out.println("! insert fecha inicio con formato  "+fecha1+"   Fecha mas  "+intervalodias+"  dias "+fecha2);
	        	         Query query2 = session.createSQLQuery("INSERT INTO calendariopagos (pagon,fip,ffp,idtanda) VALUES ("+i+",'"+fecha1+"','"+fecha2+"',"+idtanda+")");
	        	     
	        	         query2.executeUpdate();
	        	     
	        	             }else{
	        	               int a=i*intervalodias;
	        	               
	        	               Calendar cal = Calendar.getInstance();
	        	                 cal.setTime(nuevaFecha);
	        	                 cal.add(Calendar.DATE, a);
	        	                 Date fechaguardada2 = cal.getTime();
	        	                 
	        	               Calendar cal2 = Calendar.getInstance();
	        	                 cal.setTime(fechaguardada2);
	        	                 cal.add(Calendar.DATE, -intervalodias);
	        	                 Date fechaguardada3 = cal.getTime();
	        	                 
	        	               SimpleDateFormat formatoddmmyy = new SimpleDateFormat("yyyy-MM-dd");

	        	               String fecha1,fecha2;
	        	                 fecha1=formatoddmmyy.format(fechaguardada2);
	        	                 fecha2=formatoddmmyy.format(fechaguardada3);
	        	                 
	        	               System.out.println(+i+"fecha inicio : "+fecha2+"  fecha inicio fin"+ fecha1);

	        	Query query2 = session.createSQLQuery("INSERT INTO calendariopagos (pagon,fip,ffp,idtanda) VALUES ("+i+",'"+fecha2+"','"+fecha1+"',"+idtanda+")");

	        	                query2.executeUpdate();
	        	               
	        	             }
	        	             
	        	             
	        	     }
	        	     session.getTransaction().commit();
	        	     
	        	     
	        	    
	        	     

	        	     }
	        	     catch(Exception e){
	        	        e.printStackTrace();
	        	              session.getTransaction().rollback();

	        	      }
	         



	}

}



			  
