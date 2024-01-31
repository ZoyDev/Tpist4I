package it.edu.iisgubbio.video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Player {
	
	int tempiC=0;
	int tempi[];
	int rep[];
	int tempoTot;
	String []c={"1","2","3","4","5","6"};
	ArrayList<String> esec = new ArrayList<String>();
	
	
	
	/**
	 * Create all the vector that we will use and the total time
	 * @param x Vector Size,y Total Time
	 * @return Void
	 */
	Player(int x,int y){
		tempi=new int[x];
		rep=new int[x];
		tempoTot=y;
	}
	
	/**
	 * Add new Video
	 * @param x Video Duration
	 * @return Void
	 */
	void add(int x) {
		tempi[tempiC]=x;
		tempiC++;
	}
	
	/**
	 * In this function the videos are scheduled and played
	 * @param Nothing
	 * @return Void
	 */
	void esegui() {
        Random random = new Random();
		int tCiascuno=tempoTot/tempi.length;
		for(int i=0;i<rep.length;i++) {
			rep[i]=tCiascuno/tempi[i];
		}
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<rep[i];j++) {
				esec.add(c[i]);
			}
		}
		Collections.shuffle(esec);
		for(int i=0;i<esec.size();i++) {
				if(esec.get(i).equals(esec.get(i+1))) {
					Collections.swap(esec, i+1 , random.nextInt(esec.size() - i )+i);
					i=i-1;
				}else {
					System.out.println(esec.get(i));
				}
		}
			
		}

	}
