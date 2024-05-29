package macchinetta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Macchinetta{
	
	Boolean admin=false;
	Boolean owner=false;
	Boolean user=false;
	Double moneyIn=0.0;
	ArrayList<Products> products = new ArrayList<Products>();
	public void readProducts() {
		BufferedReader lettoreDiRighe;
		FileReader flussoCaratteri;
		try {
			flussoCaratteri = new FileReader("/Users/classe4I/Desktop/WorkSpaceTPSIT/Tpsit/src/macchinetta/products.txt");
			lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String read="";
			while(read!=null) {
				read=lettoreDiRighe.readLine();
				if(read!=null) {
					String testo[]=read.split(",");
					double price=Double.parseDouble(testo[1]); 
					int q=Integer.parseInt(testo[2]); 
					products.add(new Products(testo[0],price,q));
				}
			}
			lettoreDiRighe.close();
			flussoCaratteri.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public double buyProduct(int id) {
		double costo=products.get(id).price;
		double resto=0.0;
		if(moneyIn>=costo) {
			resto=moneyIn-costo;
			System.out.println("Acquistato con successo! Con resto di "+resto);
			moneyIn=0.0;
		}else {
			System.out.println("Non bastano i soldi!");
		}
		return resto;
	}
	
	public void insertMoney(double money){
		moneyIn=money;
	}
	
	public String infoProduct(int id) {
		return products.get(id).name+" col il costo di: "+products.get(id).price;
	}

	
	public void login(String username,String password) {
		if(username.equals("user") && password.equals("user")) {
			user=true;
			admin=false;
			owner=false;
		}
		if(username.equals("admin") && password.equals("12345678")) {
			admin=true;
			owner=false;
		}
		if(username.equals("owner") && password.equals("87654321")) {
			owner=true;
		}
		
	} 
	public void addProduct(String name,double price,int quantity) {
		String testo="Questa è una riga";
		try {
			FileWriter flussoCaratteri = new FileWriter("/Users/classe4I/Desktop/WorkSpaceTPSIT/Tpsit/src/macchinetta/products.txt");
			for(int i=0;i<products.size();i++) {
				flussoCaratteri.write(products.get(i).name+","+products.get(i).price+","+products.get(i).quantity+"\n");
			}
			flussoCaratteri.write(name+","+price+","+quantity);
			flussoCaratteri.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void removeProduct(int id) {
		products.remove(id);
		String testo="Questa è una riga";
		try {
			FileWriter flussoCaratteri = new FileWriter("/Users/classe4I/Desktop/WorkSpaceTPSIT/Tpsit/src/macchinetta/products.txt");
			for(int i=0;i<products.size();i++) {
				flussoCaratteri.write(products.get(i).name+","+products.get(i).price+","+products.get(i).quantity+"\n");
			}
			flussoCaratteri.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Macchinetta x=new Macchinetta();
		x.readProducts();
		x.login("user", "user");
		x.addProduct("z", 10, 10);
		System.out.println(x.infoProduct(4));
		
	}
}
