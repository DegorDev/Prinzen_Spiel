import java.util.Scanner;
import java.awt.Point;

public class Prinz {
	public static void main(String[] args) {
		
		Scanner sc = new java.util.Scanner(System.in);
		
		//Parameter
		int on 		= 1;		
		int gather 	= 0;
		int rescue 	= 0;
		
		//Figuren + Position
		Point spieler 	 = new Point((int) (Math.random()*40+1), (int) (Math.random()*50+1));
		Point schlange	 = new Point((int) (Math.random()*40+1), (int) (Math.random()*50+1));
		Point schatz 	 = new Point((int) (Math.random()*40+1), (int) (Math.random()*50+1));
		Point prinzessin = new Point((int) (Math.random()*40+1), (int) (Math.random()*50+1));
		Point tuer 		 = new Point((int) (Math.random()*40+1), (int) (Math.random()*50+1));
		Point p 		 = new Point(0,0);
		
		//Spielfeld
		do {						
			for (int y = 1; y <= 40; y++) {
				System.out.println();
				for (int x = 1; x <= 50; x++) {					
					p.setLocation(x,y);					
					if (spieler.equals(p)) {
							System.out.print("S");} 						//Spieler
					else if (schlange.equals(p)) {
							System.out.print("Z");}  						//Schlange
					else if (schatz.equals(p)) {
							System.out.print("$");}  						//Schatz
					else if (prinzessin.equals(p)) {
							System.out.print("P");} 						//Prinzessin
					else if (tuer.equals(p)) {
							System.out.print("T");} 						//T�re
					else {
						System.out.print(".");}				
				}
			}
			
			System.out.println();
			System.out.println("Truhe gesammelt: " + gather + "/1 | Prinzessin gerettet: " + rescue + "/1");
			System.out.println("Was willst du machen?");
		
			//Bewegungen Spieler
			switch (sc.next()) {
			case "a": //links
				spieler.x = spieler.x - 1;
				break;
			case "s"://runter
				spieler.y = spieler.y + 1;
				break;
			case "d"://rechts
				spieler.x = spieler.x + 1;
				break;
			case "w"://hoch
				spieler.y = spieler.y - 1;
				break;
			case "q"://Links/Hoch
				spieler.x = spieler.x - 1;
				spieler.y = spieler.y - 1;
				break;
			case "e"://Rechts/Hoch
				spieler.x = spieler.x + 1;
				spieler.y = spieler.y - 1;
				break;
			case "c"://Rechts/Runter
				spieler.x = spieler.x + 1;
				spieler.y = spieler.y + 1;
				break;
			case "x"://Links/Runter
				spieler.y = spieler.y + 1;
				spieler.x = spieler.x - 1;
				break;
			}
			
			
			//Bewegung Schlange
			if (schlange.x > spieler.x) {
				schlange.x--;} 
			else if (schlange.x < spieler.x) {
				schlange.x++;}
			
			if (schlange.y > spieler.y) {
				schlange.y--;} 
			else if (schlange.y < spieler.y) {
				schlange.y++;}
			
			//Spielregeln
			if (spieler.equals(schatz)){
				gather = 1;
				schatz.setLocation(-1, -1);}
			
			if (spieler.equals(prinzessin) && gather == 1){
				rescue = 1;
				prinzessin.setLocation(-1, -1);}
			
			if (spieler.equals(schlange)){
				System.out.println("Du hast verloren!");
				break;}
			
			if (spieler.equals(tuer) && gather == 1 && rescue == 1){
				System.out.println("Du hast gewonnen!");
				break;}
			
		} while (on == 1);	
		
		sc.close();		
	}
}
