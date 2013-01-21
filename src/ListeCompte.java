

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ListeCompte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Compte> listeCompte;
	

	public ListeCompte(){
		listeCompte = new HashMap<>();
	}

	public void ajouteUneLigne(String numcompte){
		Compte tmp;
		tmp = (Compte) listeCompte.get(numcompte);
		if (tmp != null) {
                tmp.creerLigneComptable();
            }
		else {
                System.out.println("Pas de compte associé au numéro !!!");
            }
	}
	
	public void afficherLignes(String numcompte){
		Compte tmp;
		tmp = (Compte) listeCompte.get(numcompte);
		tmp.afficherLignes();
	}

	public void afficherLescomptes(){
		Collection<Compte> C = listeCompte.values();
		for (Compte tmp : C) {
                System.out.println(tmp.toString());
            }
	}
	
	public void afficherLescomptesParType(String t){
		Collection<Compte> C = listeCompte.values();
		for (Compte tmp : C) {
			String o = tmp.getType();
			if (o.equalsIgnoreCase(t) ){
				System.out.println(tmp.toString());
			}
		}
	}


	public void rechercher(String n){
		Compte C;
		String cle = n;
		C = (Compte) listeCompte.get(cle);
		if (C != null){
                    System.out.println(C.toString());
		}else {
                    System.out.println("Le compte n'existe pas !!!");
                }
	}
	
	
	public boolean testNumCpt(String numcompte){
//		Pattern patternNumCompte;
//		patternNumCompte = Pattern.compile("[0-1]{3}-222-[0-9]{3}");
		if (numcompte.matches("[0-1]{3}-222-[0-9]{3}")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void supprimerCompte(String numcompte){
			
			if (listeCompte.remove(numcompte) != null){
				System.out.println("Supression réussie !!!");
			}else if (listeCompte.get(numcompte) != null){
				System.out.println("Suppression échoué !!!");
			}
	}
        
        public void AffichePourcentage(String numCompte){
            Compte C = (Compte) listeCompte.get(numCompte);
            C.affichePourcentage();
        }
	
	public void saisieNewCompte(){

		Scanner lc = new Scanner(System.in);
		String type="";
		String numcompte = " ";
		double solde = 0;
		

		System.out.println("==============Création de compte=====================");
		System.out.println("Numéro de compte : ");
		numcompte = lc.nextLine();
//		while (!(lc.hasNext(patternNumCompte))){
		while (!(testNumCpt(numcompte))){
			System.out.println("Mauvais format !!!!!");
			System.out.println("Entrez un nouveau numéro de compte : ");
			numcompte = lc.nextLine();
		}		
		System.out.println(numcompte);
		System.out.println("Type de compte : ");
		System.out.println("   (Courant, Epargne, Joint) ");
		String s = lc.nextLine();

		System.out.println("Solde initial :");
		solde = lc.nextDouble();

		switch (s.toUpperCase().charAt(0)){
		case 'C':
			type = "Courant";
			listeCompte.put(numcompte, new Compte(numcompte,type,solde));
			if (listeCompte.get(numcompte) != null){
				System.out.println("Nouveau compte créer !!! ");
				System.out.println(listeCompte.get(numcompte).toString());
			}
			else {
				System.out.println("Echec création de compte ");
			}
			break;

		case 'E':
			type = "Epargne";
			listeCompte.put(numcompte, new CptEpargne(numcompte,type,solde));
			if (listeCompte.get(numcompte) != null){
				System.out.println("Nouveau compte créer !!! ");
				System.out.println(listeCompte.get(numcompte).toString());
			}else {
				System.out.println("Echec création de compte ");
			}
			break;

		case 'J':
			type = "Joint";
			listeCompte.put(numcompte, new Compte(numcompte,type,solde));
			if (listeCompte.get(numcompte) != null){
				System.out.println("Nouveau compte créer !!! ");
				System.out.println(listeCompte.get(numcompte).toString());
			}
			else {
				System.out.println("Echec création de compte ");
			}			
			break;
		}
                
                


	}
}
