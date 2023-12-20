package it.edu.iisgubbio.priorità;

import java.util.ArrayList;
import java.util.Collections;

public class Priorità {
	int processi=0,tempoEsecuzione=0;
	String lProcessi[];
	int tempi[];
	int attesa[];
	int priorità[];
	ArrayList<Integer> tempiOrdinati = new ArrayList<Integer>();
	ArrayList<Integer> arriviOrdinati= new ArrayList<Integer>();
	ArrayList<Integer> prioritàOrdinati= new ArrayList<Integer>();
	int servizio[];
	int arrivo[];
	
	/**
	 * Create all the vector that we will use,fill arrivo 
	 * @param x Vector Size
	 * @return Void
	 */
	public Priorità(int x) {
		lProcessi = new String[x];
		tempi = new int[x];
		arrivo=new int[x];
		attesa=new int[x];
		servizio=new int[x];
		priorità=new int[x];
		for(int i=0;i<x;i++) {
			arrivo[i]=i;
		}
	}
	/**
	 * Add new Process
	 * @param x Process Name, y Execution Time, z Priority
	 * @return Void
	 */
	public void add(String x, int y,int z) {
		lProcessi[processi]=x;
		tempi[tempoEsecuzione]=y;
		prioritàOrdinati.add(z);
		priorità[processi]=z;
		processi++;
		tempoEsecuzione++;
	}
	
	/**
	 * Calculate Avarage Waiting Time ordering by priority
	 * @param Nothing
	 * @return Avarage Waiting Time
	 */
	public double ordina() {
		Collections.sort(prioritàOrdinati);
		for(int c=3;c>=0;c--) {
			for(int i=0;i<tempi.length;i++) {
				if(prioritàOrdinati.get(c) == priorità[i]) {	
					priorità[i]=0;
					prioritàOrdinati.set(c, -1);
					arriviOrdinati.add(arrivo[i]);
					tempiOrdinati.add(tempi[i]);
				}
			}
		}
		
		servizio[0]=0;
		for(int i=1;i<lProcessi.length ;i++) {
				servizio[i]=servizio[i-1]+tempiOrdinati.get(i-1);
		}

			System.out.println(tempiOrdinati);
			System.out.println(arriviOrdinati);


		double media=0;
		for(int i=0;i<lProcessi.length;i++) {
			if(servizio[i]-arriviOrdinati.get(i)>=0) {
				media=media+(servizio[i]-arriviOrdinati.get(i));
			}else {
				media=media+0;
			}
		}
		return media/lProcessi.length;
	}
}
