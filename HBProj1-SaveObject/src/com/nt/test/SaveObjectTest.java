package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
      public static void main(String[] args) {
		  Configuration cfg=null;
			 SessionFactory factory=null;
			Session ses =null;
			Product prod=null;
			Transaction tx=null;
			boolean flag=false;
			int idval=0;
		  
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
			prod.setPid(471);
			//generator tag in hibernate mapping file makes setter method of id property optional ,
			//ie. whatever value we are passing in setter method the id value will be generated only by generator
			prod.setPname("table"); 
//			prod.setPrice(90000); 
//			prod.setQty(5);
			try {
			  tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			 System.out.println(tx.getClass());
			      //save object
			     idval=(int)ses.save(prod);
			    System.out.println(idval);
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