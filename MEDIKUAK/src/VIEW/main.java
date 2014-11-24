package VIEW;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import KONTROLADOREA.Kontroladorea;

public class main {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (true){
			try {
				aukeratu();
			}catch(Exception e){
				if (e.getMessage()!="Zero"){
					e.printStackTrace();
				}
				break;
			}
		}
		sc.close();
		System.out.println("Agur!!");

	}
	
	private static void aukeratu() throws Exception {
		int aukera;
		aukera = aukerak();
		if (aukera == 0) throw new Exception("Zero");
		switch (aukera){
		case 1:
			zitakEzeztatu();
			break;
		default:
			System.out.println("Aukera ez egokia");
		}
	}
	
	private static int aukerak(){
		System.out.println("0: Exit\n1: zitakEzeztatu");
		try{
			int auk = sc.nextInt();
			return auk;
		}catch(InputMismatchException e){
			sc.next();
			return -1;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private static void zitakEzeztatu(){
		int zenb = -1;
		while (zenb == -1) {
			try {
				System.out.println("Sartu medikuaren ID zenbakia:");
				zenb = sc.nextInt();
				sc.nextLine();
			}catch(Exception e){
				zenb = -1;
			}
		}
		Date d = null;
		String dat;
		String[] ss;
		while (d == null){
			System.out.println("Sartu zitaren data: (UUUU/HH/EE)");
			dat = sc.nextLine();
			ss = dat.split("/");
			try {
				d = new Date(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]));
			}catch (Exception e){
				d = null;
			}
		}
		try {
			int id = Kontroladorea.getInstantzia().medikuarenZitakEzeztatu(zenb, d);
			System.out.println(id + " medikuari esleitu zaio");
		}catch(Exception e){
			System.out.println("Ezin izan da operazioa egin");
		}
	}

}
