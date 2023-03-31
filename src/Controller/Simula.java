package Controller;

import java.util.concurrent.Semaphore;

public class Simula extends Thread{
	Semaphore s1;
	double porl=62.5;
	double pors=50;
	 int p;
	double por,porso;
	String nome;
	double temp;
	public Simula(Semaphore s1, int p, double por, String nome, double temp) {
		this.s1= s1;
		this.p=p;
		this.por=por;
		this.nome= nome;
		this.temp=temp;
	}
	public void run() {
		if ((por < porl) || (por<pors)) {
		Inicio();
		}
		
		try {
			double j = 1/1000;
			sleep((long) j);
			
			Fazer();
			
		} catch (Exception e) {
			
		}
		
		try {
			
			s1.acquire();
			double j = 1/100;
			sleep((long) j);
			
			entregar();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}finally {
			s1.release();
		}
		
		}
	private void Inicio() {
		System.out.println("Iniciado o prato "+ p + "==> "+ nome + "em " + por+ "%");
		
	}
	private void entregar() {
		
		System.out.println("Entregando " + p + " prato de :  " + nome );
	}
	private void Fazer() {
		System.err.println("Fazendo " + p + " prato de " + nome + "Está em " + por +"%");
		
	}
	}
