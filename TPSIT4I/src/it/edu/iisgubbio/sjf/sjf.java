package it.edu.iisgubbio.sjf;

import java.util.ArrayList;
import java.util.Collections;

public class sjf {
	int processi=0,tempoEsecuzione=0;
	String lProcessi[];
	int tempi[];
	int attesa[];
	ArrayList<Integer> tempiOrdinati = new ArrayList<Integer>();
	int servizio[];
	int arrivo[];
	
	public sjf(int x) {
		lProcessi = new String[x];
		tempi = new int[x];
		arrivo=new int[x];
		attesa=new int[x];
		servizio=new int[x];
		for(int i=0;i<x;i++) {
			arrivo[i]=i;
		}
	}
	public void add(String x, int y) {
		lProcessi[processi]=x;
		tempi[tempoEsecuzione]=y;
		tempiOrdinati.add(y);
		processi++;
		tempoEsecuzione++;
	}
	public double ordina() {
		Collections.sort(tempiOrdinati);
		for(int c=0;c<4;c++) {
			for(int i=0;i<tempi.length;i++) {
				if(tempiOrdinati.get(c) == tempi[i]) {	
					int appoggio=arrivo[c];
					arrivo[c]=arrivo[i];
					arrivo[i]=appoggio;
					
				}
			}
		}
		servizio[0]=0;
		for(int i=1;i<lProcessi.length ;i++) {
			servizio[i]=servizio[i-1]+tempiOrdinati.get(i-1);
		}
		double media=0;
		for(int i=0;i<lProcessi.length;i++) {
			media=media+servizio[i]-arrivo[i];
		}
		return media/lProcessi.length;
	}
	
}