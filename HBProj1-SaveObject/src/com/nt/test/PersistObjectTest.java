package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class PersistObjectTest {
      public static void main(String[] args) {
		  Configuration cfg=null;
			 SessionFactory factory=null;
			Session ses =null;
			Product prod=null;
			Transaction tx=null;
			boolean flag=false;
		  
		  //Activate the hibernate framework
		  cfg=new Configuration();
			 //supply hibernate configuration file as input file
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			//create session factory
			factory=cfg.buildSessionFactory();
			//System.out.println(cfg.getClass());
			//System.out.println(factory.getClass());
			//open session
			ses=factory.openSession();
			//System.out.println(ses.getClass());
			//create the entity object to save in db s/w
			prod=new Product();
			prod.setPid(2239);
			prod.setPname("bed"); 
//    	prod.setPrice(90000); 
//		prod.setQty(2);
			try {
			  tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			 System.out.println(tx.getClass());
			      //save object
			     ses.persist(prod);
			     flag=true;
			}
			catch(HibernateException he) {
			  he.printStackTrace();
			  flag=false;
			}
			finally {
			   //commit or rollback  Tx
			    if(flag==true) {
			    	   tx.commit();  //internally calls con.commit()
			    	   System.out.println(tx.getStatus());
			    	   System.out.println("Object is saved");
			    }
			    else {
			    	tx.rollback(); //internally calls  con.rollback()
			    	System.out.println(tx.getStatus());
			    	System.out.println("Object is not saved");
			    }
			    
			    //close  session object
			    ses.close();
			    //close SessionFactroy
			    factory.close();
			}//finally
			    }
}