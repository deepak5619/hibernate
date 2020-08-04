package com.nt.factory;

import com.nt.component.AmazonStore;
import com.nt.component.EcommerceStore;
import com.nt.proxy.ECommerceDiscount;

public class EcommerceStoreFactoryClass {
      public static EcommerceStore getInstane(String coupen) {
    	  if(coupen.equalsIgnoreCase("") || coupen.trim().length()==0) {
    		  return new AmazonStore();
    	  }
    	  else {
				if (coupen.equalsIgnoreCase("AMZ10")) {

					return new ECommerceDiscount(10);
				}
				else if (coupen.equalsIgnoreCase("AMZ20")) {
					return new ECommerceDiscount(20);
				}
				else if (coupen.equalsIgnoreCase("AMZ30")) {
					return new ECommerceDiscount(30);
				}
				else {
					return new ECommerceDiscount(5);
				}
      }
}
}