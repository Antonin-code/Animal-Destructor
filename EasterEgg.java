import java.util.Objects;
import java.util.Random;

public class EasterEgg {
    /*
    Fonction qui choisit un endroit aléatoire et crée une croix pour prévenir l'arrivée d'une bombe.
    Elle renvoie la localisation de la bombe.
    La bombe ne peut pas apparaitre sur un joueur.
     */
    public static short[] PreventionBombe(String[][] grille) {
        boolean BombeOk = false;
        short BombLigne;
        short BombColonne;
        do {
            Random RandBombLigne = new Random();
            Random RandBombColonne = new Random();
            BombLigne = (short)RandBombLigne.nextInt(11);
            BombColonne = (short)RandBombColonne.nextInt(12);
            if (Objects.equals(grille[BombLigne][BombColonne], "🟩")) {
                BombeOk = true;
            }
        } while (!BombeOk);
        grille[BombLigne][BombColonne] = "\uD83D\uDCA3";
        return new short[]{BombLigne,BombColonne};
    }

    public static void PreventionAttention(String[][] grille,short[] BombCoords) {
        short BombLigne = BombCoords[0];
        short BombColonne = BombCoords[1];
        if (Objects.equals(grille[BombLigne + 1][BombColonne], "🟩")) {
            grille[BombLigne + 1][BombColonne] = "⚠️";}
        if (Objects.equals(grille[BombLigne - 1][BombColonne], "🟩")) {
            grille[BombLigne - 1][BombColonne] = "⚠️";}
        if (Objects.equals(grille[BombLigne][BombColonne + 1], "🟩")) {
            grille[BombLigne][BombColonne + 1] = "⚠️";}
        if (Objects.equals(grille[BombLigne][BombColonne - 1], "🟩")) {
            grille[BombLigne][BombColonne - 1] = "⚠️";}
    }

    public static void Explosion(String[][] grille,short[] BombCoords) {
        try {
            grille[BombCoords[0]][BombCoords[1]] = "🔥";
            grille[BombCoords[0] + 1][BombCoords[1]] = "🔥";
            grille[BombCoords[0] - 1][BombCoords[1]] = "🔥";
            grille[BombCoords[0]][BombCoords[1] + 1] = "🔥";
            grille[BombCoords[0]][BombCoords[1] - 1] = "🔥";
        }
        catch (Exception _) {}
    }

    public static boolean EECondition(String[][] grille) {
        return Objects.equals(grille[1][1], "🔥") && Objects.equals(grille[10][1], "🔥") && Objects.equals(grille[1][11], "🔥") && Objects.equals(grille[10][11], "🔥");
    }
}
