

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FichierCompte {
	private ObjectOutputStream ofW;
	private ObjectInputStream ofR;
	private String nomDuFichier = "Compte.dat";
	private char mode;
	
	public boolean ouvrir(String s){
		try{
			mode = (s.toUpperCase()).charAt(0);
			if (mode == 'W' || mode == 'E')
				ofW = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
			else if  (mode == 'L' || mode == 'R')
				ofR = new ObjectInputStream(new FileInputStream(nomDuFichier));
			
			return true;
		}catch(IOException e){
			return false;
		}
	}
	
	public void ecrire(ListeCompte tmp){
		try{
			if (tmp != null){
				ofW.writeObject(tmp);
			}
		}catch(IOException e){
			System.out.println("Erreur d'écriture dans : "+nomDuFichier);
		}
		
	}
	//Renvoi la collection d'objet HashMap
	public ListeCompte lire(){
		try{
			ListeCompte tmp = (ListeCompte) ofR.readObject();
				return tmp;
			
		}catch(IOException e){
			System.out.println(nomDuFichier+" : Erreur de lecture");
		}catch(ClassNotFoundException e){
			System.out.println(nomDuFichier+" : n'est pas du bon format");
		}
		return null;
	}
	
	public boolean fermer(){
		try{
			if (mode == 'W' || mode =='E')
				ofW.close();
			else if  (mode == 'L' || mode == 'R')
				ofR.close();
			return true;
		}catch (IOException e){
			return false;
		}
	}
	
}
