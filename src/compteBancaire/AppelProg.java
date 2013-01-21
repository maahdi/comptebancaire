package compteBancaire;
import java.util.Scanner;
import java.util.regex.Pattern;


public class AppelProg{
    
    static Pattern patternNumCompte ;
    //----------------------------------------MENU--------------------------------------//
    public static void menuBanque(FichierCompte F, ListeCompte listeCompte){
        boolean t = true;
        byte choix ;
        while (t){
            Scanner msc = new Scanner(System.in);
            System.out.println("===================Banque=======================");
            System.out.println(" 1. Créer un compte");
            System.out.println(" 2. Modifier un compte");
            System.out.println(" 3. Rechercher un compte");
            System.out.println(" 4. Supprimer un compte");
            System.out.println(" 5. Afficher tous les comptes");
            System.out.println(" 6. Afficher les comptes par type");
            System.out.println(" 7. Sortir du programme");
            choix = msc.nextByte();
            switch (choix){
                case 1 :
                    listeCompte.saisieNewCompte();
                    Fonctions.attente();
                    break;
                    
                case 2 :
                    Scanner menc = new Scanner(System.in);
                    String numcompte ="";
                    
                    System.out.println("Numéro de compte recherché :");
                    numcompte = menc.nextLine();
                    while (!(Fonctions.testNumCpt(numcompte))){
                        System.out.println("Mauvaise saisie !!!");
                        System.out.println("Numéro de compte recherché :");
                        numcompte = menc.nextLine();
                    }
                    while (!(listeCompte.controleCompteExiste(numcompte))){
                        System.out.println("Compte existe pas !!!");
                        System.out.println("Numéro de compte recherché :");
                        numcompte = menc.nextLine();
                    }
                    menuCompte(numcompte, listeCompte ,F);
                    break;
                    
                case 3:
                    Scanner u = new Scanner(System.in);
                    System.out.println("Numéro de compte recherché :");
                    String h  = u.nextLine();
                    while (!(Fonctions.testNumCpt(h))){
                        System.out.println("Mauvais format de numéro !!!");
                        System.out.println("Numéro de compte recherché :");
                        h = u.nextLine();
                    }
                    listeCompte.rechercher(h);
                    Fonctions.attente();
                    break;
                    
                case 4:
                    Scanner r = new Scanner(System.in);
                    System.out.println("Numéro de compte recherché :");
                    String s = r.nextLine();
                    
                    while (!(Fonctions.testNumCpt(s))){
                        System.out.println("Mauvais format de numéro !!!");
                        System.out.println("Numéro de compte recherché :");
                        s = r.nextLine();
                    }
                    System.out.println(s);
                    listeCompte.supprimerCompte(s);
                    Fonctions.attente();
                    break;
                    
                case 5:
                    listeCompte.afficherLescomptes();
                    Fonctions.attente();
                    break;
                    
                case 6:
                    Scanner f = new Scanner(System.in);
                    String type = "";
                    boolean testType= false;
                    while (!(testType)){
                        System.out.println("Entrez le type : ");
                        type = f.next();
                        type = Fonctions.controleTypeCompte(type);
                        if (type != null){
                            testType = true;
                        }else{
                            System.out.println("Mauvaise saisie !!!");
                        }
                    }
                    listeCompte.afficherLescomptesParType(type);
                    Fonctions.attente();
                    break;
                    
                case 7:
                    F.ouvrir("Ecriture");
                    F.ecrire(listeCompte);
                    F.fermer();
                    t = false;
                    System.exit(0);
                    break;
                    
            }
        }
    }
    
    public boolean lire(){
        return false;
    }
    
    public static void menuCompte(String numcompte, ListeCompte listeCompte, FichierCompte F){
        boolean fin = true;
        Scanner sc = new Scanner(System.in);
        while (fin){
            System.out.println("=====================Compte=======================");
            System.out.println(" 1. Afficher les opérations");
            System.out.println(" 2. Nouvelle opération comptable");
            System.out.println(" 3. Recherche");
            System.out.println(" 4. Revenir au menu 'Banque'");
            System.out.println(numcompte);
            int o = sc.nextInt();
            switch (o){
                case 1:
                    listeCompte.afficherLignes(numcompte);
                    Fonctions.attente();
                    break;
                case 2:
                    listeCompte.ajouteUneLigne(numcompte);
                    Fonctions.attente();
                    listeCompte.afficherLignes(numcompte);
                    Fonctions.attente();
                    break;
                    
                case 3:
                    break;
                    
                case 4 :
                    fin = false;
                    menuBanque(F,listeCompte);
                    break;
                    
            }
        }
    }
    
    
    //------------------------------MAIN-----------------------------------------//
    public static void main(String [] args){
        ListeCompte listeCompte = new ListeCompte();
        FichierCompte F = new FichierCompte();
        if (F.ouvrir("lecture")){
            ListeCompte C;
            //Recrée les objets dans l'ordre de l'enregistrement
            while ((C = F.lire()) != null){
                listeCompte = C;
            }
            F.fermer();
        }
        menuBanque(F,listeCompte);
        
        
        
    }
    

}
