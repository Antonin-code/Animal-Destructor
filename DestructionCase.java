import java.util.Objects;
import java.util.Scanner;

public class DestructionCase {
    /*Fonction pour demander des coordonnées à l'utilisateur et détruire la case correspondante
    Cette fonction récupère une grille et demande au joueur des coordonnées en un nombre et une lettre
    SI la coordonnée est bien écrite et SI la case choisie est valide, elle se transformera en feu
    Les cases valides sont les cases herbe uniquement
     */
    public static void Destruction(String[][] grille) {
        //Affichage du terrain
        Generation.Affichage(grille);

        //Variables pour texte en couleurs
        final String ROUGE = "\u001B[31m";
        final String BLEU = "\u001B[36m";
        final String RESET = "\u001B[0m";

        short ColonneCoord = 0;
        short LigneCoord = 0;

        boolean estvalide = false;
        //Boucle pour vérifier si les coordonnées données sont valides
        while(!estvalide) {

            //Récupérer les coordonnées
            System.out.println("Veuillez rentrer les coordonnées (exemple: "+ BLEU +"1"+ROUGE+"A"+RESET+" ) :");
            Scanner sc = new Scanner(System.in);
            String Coordonnees = sc.nextLine();

            if (Objects.equals(Coordonnees, "R") || Objects.equals(Coordonnees, "r")) {
                Choix.regles_Jeu(grille);
            }
            if (Objects.equals(Coordonnees, "L") || Objects.equals(Coordonnees, "l")) {
                Menu.Quitter();
            }


            //Séparer le numéro de la colonne et la lettre de la ligne
            String Colonne = Coordonnees.substring(0, Coordonnees.length()-1);
            String Ligne = Coordonnees.substring(Coordonnees.length()-1);

            //Transformer les index en shorts
            try {
                ColonneCoord = Short.parseShort(Colonne);
                //Récupérer l'instance de la lettre ligne en ASCII et soustraire 64 pour obtenir l'index correspondant
                LigneCoord = (short)(Ligne.toUpperCase().charAt(0) - 64);
            }
            catch(Exception e) {
            }

            if (!Objects.equals(Coordonnees, "R") && !Objects.equals(Coordonnees, "r")){
                //Vérifier si les coordonnées sont dans le terrain
                if ((ColonneCoord > 11 || ColonneCoord < 1 || LigneCoord > 10 || LigneCoord < 1) || !Objects.equals(grille[LigneCoord][ColonneCoord] , "🟩")) {
                    System.out.println("Coordonnées Invalides");
                }
            else {
                estvalide = true;
            }
        }
        }
        grille[LigneCoord][ColonneCoord] = "🔥";
    }
}
