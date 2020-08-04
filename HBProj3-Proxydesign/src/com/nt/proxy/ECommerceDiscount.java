package com.nt.proxy;

import com.nt.component.AmazonStore;
import com.nt.component.EcommerceStore;

public class ECommerceDiscount implements EcommerceStore {
    
	private float discount;
	private EcommerceStore real;
	public ECommerceDiscount(float discount) {
		this.discount=discount;
        real = new AmazonStore();
	}
	@Override
	public double shopping(String[] items, double[] prices) {
		double billAmt=0.0f;
		double finalAmt=0.0f;
		billAmt=real.shopping(items, prices);
		finalAmt=billAmt-billAmt*(discount/100);
		return finalAmt;
	}

}
