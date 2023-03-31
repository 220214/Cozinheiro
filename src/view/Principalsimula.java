package view;

import java.util.concurrent.Semaphore;

import Controller.Simula;

public class Principalsimula {

	public static void main(String[] args) {
		Semaphore s1 = new Semaphore(1);
		for( int p=1; p<6;p++) {
			int k = p%2;
			if(k==0) {
				double por = 12.5;
				
				
				String nome = "Lasanha á Bolonhesa";
			
				Thread t=new Simula(s1, p, por, nome);
				t.start();
				
			}
			else if(k!=0) {
				double por = 8.35;
			
				String nome = "Sopa de Cebola ";
			
				Thread t=new Simula(s1, p, por, nome);
				t.start();
				

	}
			}
	}
}
