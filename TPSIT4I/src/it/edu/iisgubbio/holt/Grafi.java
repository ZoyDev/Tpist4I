package it.edu.iisgubbio.holt;

public class Grafi {
	int processi,risorse;
	int grafo[][];
	
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
	private void azzera(int x) {
		for(int i=0;i<risorse;i++) {
			grafo[x][i]=0;
		}
	}
	public void riduci() {
		if(isRiducibile()) {
			boolean riducibile=false;
			int c,i;
			for(i=0;i<risorse;i++) {
				riducibile=true;
				for(c=0;c<processi;c++) {
					if(grafo[i][c]==2) {
						riducibile=false;
					}
				}
				if(riducibile) {
					azzera(i);
				}
			}
		}
	}
	public boolean isRiducibile() {
		boolean riducibile=false;
		for(int i=0;i<risorse;i++) {
			riducibile=true;
			for(int c=0;c<processi;c++) {
				if(grafo[i][c]==2) {
					riducibile=false;
				}
			}
			if(riducibile) {
				break;
			}
		}
		return riducibile;
	}
	
}
