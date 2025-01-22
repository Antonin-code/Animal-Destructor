import java.awt.desktop.QuitHandler;
import java.util.Scanner;

public class Menu {

    // Fonction pour lancer le menu avec les options
    public static void Debut(){
        System.out.println("Bonjour bienvenue dans Animal-Destructor !! ");
        System.out.println("Voici les options possibles : ");
        System.out.println("--- P pour lancer une partie --- ");
        System.out.println("--- R pour lire les règles du jeu ---");
        System.out.println("--- Q pour quitter le jeu (mauvaise idée) ---");
        Scanner scan = new Scanner(System.in);
        String choix = scan.nextLine();

        // Rappele la fonction si le choix est different d'une lettre, exemple chiffre ou caractère spéciale
        if (choix.matches(".*[\\d-_&'(@ç!;:/?,+].*")) {
            System.out.println("Bien essayé Clément");
            System.out.println(" ");
            Debut();
        }
        // Choix pour jouer
        else if (choix.equals("P") || choix.equals("p")) {
            Jouer();
        }
        // Choix pour Regles
        else if (choix.equals("R") || choix.equals("r")) {
            Regles();
        }
        // Choix pour Quitter
        else if (choix.equals("Q") || choix.equals("q")) {
            Quitter();
        }
        // Rappele la fonction si le choix est different de P/R/Q
        else{
            System.out.println("Veuillez bien relire les options possibles : ");
            System.out.println(" ");
            Debut();
        }
    }

    // Fonction pour lancer le jeu
    public static void Jouer(){
        System.out.println("Jouer");
    }

    // Fonction pour lire les regles
    public static void Regles(){
        System.out.println("Regles : ");
        System.out.println(" ");
    }

    // Fonction pour quitter le jeu
    public static void Quitter(){
        System.exit(0);
    }

}
