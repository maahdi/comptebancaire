package compteBancaire;

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
		listeCompte = new HashMap<String, Compte>();
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
        
        public boolean controleCompteExiste(String numcompte){
            if (listeCompte.get(numcompte) != null){
                return true;
            }else{
                return false;
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

	public void supprimerCompte(String numcompte){
			
			if (listeCompte.remove(numcompte) != null){
				System.out.println("Supression réussie !!!");
			}else if (listeCompte.get(numcompte) != null){
				System.out.println("Suppression échoué !!!");
			}
		
		
	}
	
	public void saisieNewCompte(){

		Scanner lc = new Scanner(System.in);
		String type="";
		String numcompte = " ";
		double solde = 0;
                
		System.out.println("==============Création de compte=====================");
                boolean numcompteTest = false;
                while (!(numcompteTest)){
                    System.out.println("Numéro de compte : ");
                    numcompte = lc.nextLine();
                    if (!(Fonctions.testNumCpt(numcompte))){
                        System.out.println("Mauvais format !!!!!");
                        numcompteTest = true;
                    }
                }		
                
		System.out.println("Type de compte : ");
		System.out.println("   (Courant, Epargne, Joint) ");
		String s = lc.nextLine();
                Fonctions.attente();
                        
                boolean soldeTest = false;
                while (!(soldeTest)){
                    System.out.println("Solde initial :");
                    solde = lc.nextDouble();
                    if (Fonctions.controleSoldeInitial(solde)){
                        soldeTest = true;
                    }
                }
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
