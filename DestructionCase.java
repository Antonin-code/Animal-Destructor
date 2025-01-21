import java.util.Scanner;

public class DestructionCase {
    //Fonction pour demander des coordonnées à l'utilisateur et détruire la case correspondante
    public static void Destruction(String[][] grille) {
        //Variables pour texte en couleurs
        final String ROUGE = "\u001B[31m";
        final String BLEU = "\u001B[36m";
        final String RESET = "\u001B[0m";

        short ColonneCoord = 0;
        short LigneCoord = 0;

        boolean isvalid = false;
        //Boucle pour vérifier si les coordonnées données sont valides
        while(!isvalid) {

            //Récupérer les coordonnées
            System.out.println("Veuillez rentrer les coordonnées (exemple: "+ BLEU +"1"+ROUGE+"A"+RESET+" ) :");
            Scanner sc = new Scanner(System.in);
            String Coordonnees = sc.nextLine();

            //Séparer le numéro de la colonne et la lettre de la ligne
            String Colonne = Coordonnees.substring(0, Coordonnees.length()-1);
            String Ligne = Coordonnees.substring(Coordonnees.length()-1);

            //Transformer les index en shorts
            try {
                ColonneCoord = Short.parseShort(Colonne);
                //Récupérer l'instance de la lettre ligne en ASCII et soustraire 64 pour obtenir l'index correspondant
                LigneCoord = (short)(Ligne.toUpperCase().charAt(0) - 64);
            }
            catch(Exception _) {
            }
            //Vérifier si les coordonnées sont dans le terrain
            if (ColonneCoord > 11 || ColonneCoord < 1 || LigneCoord > 10 || LigneCoord < 1) {
                System.out.println("Coordonnées Invalides");
            }
            else {
                isvalid = true;
            }
        }
        grille[LigneCoord][ColonneCoord] = "🔥";
        Generation.Affichage(grille);
    }
}
