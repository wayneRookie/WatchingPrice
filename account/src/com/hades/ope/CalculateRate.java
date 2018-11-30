package com.hades.ope;

public class CalculateRate {

	public double rate(double price) throws NumberFormatException, Exception {

		NowPrice np = new NowPrice();
		double nowprice = Double.valueOf(np.getPrice());
		double rate = price / nowprice;

		return (rate - 1);

	}

}
