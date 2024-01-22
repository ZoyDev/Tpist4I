package it.edu.iisgubbio.video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Video {
	
	int tempiC=0;
	int tempi[];
	int rep[];
	int tempoTot;
	String []c={"1","2","3","4","5","6"};
	ArrayList<String> esec = new ArrayList<String>();
	
	Video(int x,int y){
		tempi=new int[x];
		rep=new int[x];
		tempoTot=y;
	}
	void add(int x) {
		tempi[tempiC]=x;
		tempiC++;
	}
	
	void esegui() {
        Random random = new Random();
		int p=rep.length+4;
		int tCiascuno=tempoTot/tempi.length;
		for(int i=0;i<rep.length;i++) {
			rep[i]=tCiascuno/tempi[i];
		}
		int rTot=0;
		for(int i=0;i<rep.length;i++) {
			rTot=rTot+rep[i];
		}
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<rep[i];j++) {
				esec.add(c[i]);
			}
		}
		Collections.shuffle(esec);
		for(int i=0;i<esec.size();i++) {
				if(esec.get(i).equals(esec.get(i+1))) {
					Collections.swap(esec, i+1 , random.nextInt(esec.size() - i ));
					i=i-1;
				}else {
					System.out.println(esec.get(i));
				}
		}
			
		}

	}
