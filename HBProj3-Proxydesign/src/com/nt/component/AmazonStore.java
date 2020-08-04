package com.nt.component;

import java.util.stream.DoubleStream;

public class AmazonStore implements EcommerceStore {

	@Override
	public double shopping(String[] items, double[] prices) {
		double total=0.0f;
		for(double p:prices) {
			total+=p;
		}
    return total;
	}
	
	/*public double shopping(String[] items,double[] prices) {
		double billAmt=0.0f;
		billAmt=DoubleStream.of(prices).sum();
	}
	return billAmt;*/
}
