package it.edu.iisgubbio.holt;

public class Grafi {
	int processi,risorse;
	int grafo[][];
	
	/**
	 * Create grafi,fill grafo, we will know how much process and resources we will have 
	 * @param x Resources number, y Process number
	 * @return Void
	 */
	public Grafi(int x, int y) {
		risorse=x;
		processi=y;
		grafo = new int[x][y];
		for(int i=0;i<x;i++) {
			for(int c=0;c<y;c++) {
				grafo[i][c]=0;
			}
		}
	}
	
	/**
	 * Assign a resource to a process
	 * @param processo Process, risorsa Resource
	 * @return Void
	 */
	public void in (int processo, int risorsa) {
		boolean preso=false;
		for(int i=0;i<processi;i++) {
			if(grafo[risorsa][i]==1) {
				preso=true;			
			}
		}
		if(preso) {
			grafo[risorsa][processo]=2;
		}else {
			grafo[risorsa][processo]=1;
		}
		
	}
}
