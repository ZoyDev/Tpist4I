package it.edu.iisgubbio.fcfs;

public class fcfs {
	int processi=0,tempoEsecuzione=0;
	String lProcessi[];
	int tempi[];
	int attesa[];
	int servizio[];
	int arrivo[];
	
	/**
	 * Create all the vector that we will use,fill arrivo 
	 * @param x Vector Size
	 * @return Void
	 */
	public fcfs(int x) {
		lProcessi = new String[x];
		tempi = new int[x];
		arrivo=new int[x];
		attesa=new int[x];
		servizio=new int[x];
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
	 * Calculate Avarage Waiting Time
	 * @param Nothing
	 * @return Avarage Waiting Time
	 */
	public double calcola() {
		servizio[0]=0;
		for(int i=1;i<lProcessi.length ;i++) {
			servizio[i]=servizio[i-1]+tempi[i-1];
		}
		double media=0;
		for(int i=0;i<lProcessi.length;i++) {
			media=media+servizio[i]-arrivo[i];
		}
		return media/lProcessi.length;
	}
	
	
}
