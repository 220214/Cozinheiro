package Controller;

import java.util.concurrent.Semaphore;

public class Simula extends Thread{
	Semaphore s1;
	double porl=62.5;
	double pors=50;
	 int p;
	static double por;
	String nome;
	int temp;
	public Simula(Semaphore s1, int p, double por, String nome) {
		this.s1= s1;
		this.p=p;
		Simula.por=por;
		this.nome= nome;
		
	}
	public void run() {
		try {
			
			double j = 1/1000;
			sleep((long) j);
			
			Inicio();
			
		} catch (Exception e) {
			
		}
		
		
		
		
		try {
			
			double j = 1/1000;
			sleep((long) j);
			
			Fazer();
			
		} catch (Exception e) {
			
		}
		
		try {
			
			s1.acquire();
			double j = 5/1000;
			sleep((long) j);
			
			entregar();
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}finally {
			s1.release();
		}
		
		}
	private void Inicio() {
		while ((temp <pors)||(temp<porl)){
			
		System.out.println("Iniciado o prato "+ p + "==> "+ nome + "em processo de  " + temp+ "%");
		temp = temp +(int) por;
		}
	}
	private void entregar() {
		
		System.out.println("Entregando " + p + " prato de :  " + nome );
	}
	private void Fazer() {
		while (temp <100) {
		
		System.err.println("Fazendo " + p + " prato de " + nome + " Está em " + temp +"%");
		temp = (int) (temp + por);
		}
	}
	}
