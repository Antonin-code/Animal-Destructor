import java.util.Objects;

/*
  Fonction qui permet de verifier si autour d'un joueur il y a pas de case verte le joueur des éliminer.
  Puis s'il ne reste qu'un joueur celui-ci gagne la partie
   */
public class VictoireDefaite {

    public static boolean Defaite(short[] coord, String[][] grille) {
        //mise en place des coordonee
        short coordx = coord[0];
        short coordy = coord[1];

        //regarder si il y a encore une case verte autour
        if (!Objects.equals(grille[coordx + 1][coordy], "🟩") && !Objects.equals(grille[coordx - 1][coordy], "🟩") && !Objects.equals(grille[coordx][coordy + 1], "🟩") && !Objects.equals(grille[coordx][coordy - 1], "🟩")) {
            //si oui on continue si non on le tue
            if (Objects.equals(grille[coordx][coordy], "🐰")) {
                grille[coordx][coordy] = "🍖";
            }
            if (Objects.equals(grille[coordx][coordy], "🐷")) {
                grille[coordx][coordy] = "\uD83E\uDD53";
            }
            if (Objects.equals(grille[coordx][coordy], "🐔")) {
                grille[coordx][coordy] = "\uD83C\uDF57";
            }
            if (Objects.equals(grille[coordx][coordy], "🦊")) {
                grille[coordx][coordy] = "\uD83E\uDD69";
            }
            return true;
        }
        return false;
    }

        public static int score() {
        int cpt = 0;
        if (cpt==0){
            cpt--;
        }
        else {
            cpt++;
            System.out.println("cpt");
        }
        return cpt;
    }
}


