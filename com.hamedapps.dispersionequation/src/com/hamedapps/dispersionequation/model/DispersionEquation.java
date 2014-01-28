package com.hamedapps.dispersionequation.model;

import java.util.Vector;


/**
 * @author Hamed Mohammadi
 *
 */
public class DispersionEquation {
	private double t;
	private double sigma, h;
	private double kh;
	private double k;
	private Vector<Double> khs;
	private Vector<Double> khVsTanhkhs;
	private Vector<Double> khVsYs;
	
	public DispersionEquation(double t, double h) {
		this.t = t;
		sigma= (2*Math.PI)/t;
		this.h = h;
		
		khs = new Vector<>();
		khVsTanhkhs = new Vector<>();
		khVsYs = new Vector<>();
		
		compute();
	}
	
	private void compute() {
		computeK();
		computeKHvsTanhKH();
		computeKhvsY();
	}

	private void computeK() {
		double y = Math.pow(sigma, 2)*h/9.81;
		double kh_i = (Math.pow(sigma, 2)*h)/(9.81*Math.sqrt(Math.tanh(y)));
		System.out.println("kh_i = " + kh_i);
		kh =0;
		boolean next = true;
		while (next) {
			double f_kh = y/kh_i - Math.tanh(kh_i);
			double fp_kh = -y/Math.pow(kh_i, 2) - Math.pow(1.0/Math.cosh(kh_i), 2);
			kh = kh_i - f_kh/fp_kh;
			System.out.println("kh = " + kh);
			if(Math.abs(kh-kh_i)<0.0000000000001)
				next = false;
			kh_i=kh;
		}
		k=kh/h;
	}
	
	private void computeKHvsTanhKH() {
		double kh1= kh-0.9*kh;
		double kh2 = kh+0.9*kh;
		double x = (kh2-kh1)/100.0;
		
		
		for(int i = 0; i < 100; i++) {
			double khi = kh1+x*i;
			khs.add(khi);
			khVsTanhkhs.add(Math.tanh(khi));
		}
	}
	
	private void computeKhvsY() {
		for(int i = 0; i < 100; i++ ) {
			khVsYs.add(Math.pow(sigma, 2)*h/(9.806*khs.get(i)));
		}
	}

	/**
	 * @return
	 */
	public double getSigma() {
		return sigma;
	}

	/**
	 * @param sigma
	 */
	public void setSigma(double sigma) {
		this.sigma = sigma;
		compute();
	}

	/**
	 * @return
	 */
	public double getH() {
		return h;
	}

	/**
	 * @param h
	 */
	public void setH(double h) {
		this.h = h;
		compute();
	}

	/**
	 * @return
	 */
	public double getK() {
		return k;
	}

	/**
	 * @return the khs
	 */
	public Vector<Double> getKhs() {
		return khs;
	}

	/**
	 * @param khs the khs to set
	 */
	public void setKhs(Vector<Double> khs) {
		this.khs = khs;
	}

	/**
	 * @return the khVsTanhkhs
	 */
	public Vector<Double> getKhVsTanhkhs() {
		return khVsTanhkhs;
	}

	/**
	 * @param khVsTanhkhs the khVsTanhkhs to set
	 */
	public void setKhVsTanhkhs(Vector<Double> khVsTanhkhs) {
		this.khVsTanhkhs = khVsTanhkhs;
	}

	/**
	 * @return the khVsYs
	 */
	public Vector<Double> getKhVsYs() {
		return khVsYs;
	}

	/**
	 * @param khVsYs the khVsYs to set
	 */
	public void setKhVsYs(Vector<Double> khVsYs) {
		this.khVsYs = khVsYs;
	}

	/**
	 * @return the t
	 */
	public double getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(double t) {
		this.t = t;
	}
}
