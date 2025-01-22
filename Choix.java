import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Choix {
    public static void choix_Menu() {
        Scanner scan = new Scanner(System.in);
        String choix = scan.nextLine();
        {
            // Rappele la fonction si le choix est different d'une lettre, exemple chiffre ou caractère spéciale
            if (choix.matches(".*[\\d-_&'(@ç!;:/?,+].*")) {
                System.out.println("Bien essayé Clément");
                System.out.println(" ");
            }

            // Choix pour jouer
            else if (choix.equals("P") || choix.equals("p")) {
                Menu.Jouer();
            }
            // Choix pour Regles
            else if (choix.equals("R") || choix.equals("r")) {
                regles_Menu();
            }
            // Choix pour Quitter
            else if (choix.equals("L") || choix.equals("l")) {
                Menu.Quitter();
            }
            // Rappele la fonction si le choix est different de /R/Q
            else {
                System.out.println("Veuillez bien relire les options possibles : ");
                System.out.println(" ");
            }
        }
    }


    // Fonction pour lire les regles
    public static void regles_Menu() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Bienvenue dans notre jeu de societe de stratégie sur plateau dans lequel vous pourrez piégés vos amis !!\n" +
                "Le jeu se joue de 2 a 4 joueur car jouer tous seul c'est triste.\n" +
                "Pour gagner il suffit d'enfermer votre adversaire, vous avez 1 deplacement et 1 case a bloquer par tour.\n" +
                "Le deplacement se fait avec Z Q S D, et les cases a bloquer avec des coordonnés exemple L5.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--- B pour quitter les regles et retourner au Menu (les regles c'est relou) --- ");
        System.out.println("--- L Quitter le jeu (sa a l'air nul)---");
        Scanner scan = new Scanner(System.in);
        String Regles = scan.nextLine();
        if (Regles.matches(".*[\\d-_&'(@ç!;:/?,+].*")) {
            System.out.println("Bien essayé Clément");
            System.out.println(" ");
        }
        // Choix pour retourner au menu
        else if (Regles.equals("B") || Regles.equals("b")) {
            Menu.Debut();
        }
        // Choix pour quitter le jeu dans les regles
        else if (Regles.equals("L") || Regles.equals("l")) {
            Menu.Quitter();
        }
    }

    // Fonction pour lire les regles
    public static void regles_Jeu(String[][] grille) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Bienvenue dans notre jeu de societe de stratégie sur plateau dans lequel vous pourrez piégés vos amis !!\n" +
                "Le jeu se joue de 2 a 4 joueur car jouer tous seul c'est triste.\n" +
                "Pour gagner il suffit d'enfermer votre adversaire, vous avez 1 deplacement et 1 case a bloquer par tour.\n" +
                "Le deplacement se fait avec Z Q S D, et les cases a bloquer avec des coordonnés exemple L5.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--- P pour quitter les regles et retourner au Jeu(les regles c'est relou) --- ");
        System.out.println("--- L Quitter le jeu---");
        Scanner scan = new Scanner(System.in);
        String Regles = scan.nextLine();
        if (Regles.matches(".*[\\d-_&'(@ç!;:/?,+].*")) {
            System.out.println("Bien essayé Clément");
            System.out.println(" ");
        }
        // Choix pour retourner au menu
        else if (Regles.equals("P") || Regles.equals("p")) {
            Generation.Affichage(grille);
        }
        // Choix pour quitter le jeu dans les regles
        else if (Regles.equals("L") || Regles.equals("l")) {
            Menu.Quitter();
        }
    }
}