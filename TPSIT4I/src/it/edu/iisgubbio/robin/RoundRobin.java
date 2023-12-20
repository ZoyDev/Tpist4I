package it.edu.iisgubbio.robin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RoundRobin {
	int processi=0,tempoEsecuzione=0;
	String lProcessi[];
	int tempi[];
	int attesa[];
	ArrayList<Integer> tempiOrdinati = new ArrayList<Integer>();
	ArrayList<Integer> servizio= new ArrayList<Integer>();
	int servizio1[];
	int arrivo[];
	int quanto=0;
	
	/**
	 * Create all the vector that we will use,fill arrivo 
	 * @param x Vector Size,y Quanto di Tempo
	 * @return Void
	 */
	public RoundRobin(int x,int y) {
		quanto=y;
		lProcessi = new String[x];
		tempi = new int[x];
		arrivo=new int[x];
		attesa=new int[x];
		servizio1= new int[x];
		for(int i=0;i<x;i++) {
			arrivo[i]=i;
		}
	}
	/**
	 * Add new Process
	 * @param x Process Name, y Execution Time
	 * @return Void
	 */
	public void add(String x, int y) {
		lProcessi[processi]=x;
		tempi[tempoEsecuzione]=y;
		processi++;
		tempoEsecuzione++;
	}
	/**
	 * Control if we end the operations
	 * @param None
	 * @return Boolean finito
	 */
	public boolean fine() {
		boolean finito=true;
		for(int i=0;i<tempi.length;i++) {
			if(tempi[i]>0) {
				finito=false;
			}
		}
		return finito;
	}
	
	public double ordina() {
		servizio.add(0);
		double media=0;
		for(int c=0;!fine();c++){
			for(int i=0;i<tempi.length;i++) {
				if(tempi[i]>0) {
					if(tempi[i]-quanto<0) {
						servizio.add(servizio.get(servizio.size()-1)+tempi[i]);
					}else {
						servizio.add(servizio.get(servizio.size()-1)+quanto);
					}	
					servizio1[i]=servizio.get(servizio.size()-2);
				}
				tempi[i]=tempi[i]-quanto;
			}
		
		}	
		for(int i=0;i<tempi.length;i++) {
			media=media+servizio1[i]-i;


	}
		return media/tempi.length;
	
	}
}

