import java.util.Objects;

/*
  Fonction qui permet de verifier si autour d'un joueur il y a pas de case verte le joueur des éliminer.
  Puis s'il ne reste qu'un joueur celui-ci gagne la partie
   */
public class VictoireDefaite {
    /**
     * Vérifie si un joueur est éliminé en fonction des cases disponibles autour de lui.
     * Si le joueur est entouré de cases non accessibles (autres que "🟩"), il est considéré
     * comme éliminé.
     *
     * @param coord les coordonnées du joueur sous forme d'un tableau de shorts où :
     *              - `coord[0]` représente la position x du joueur.
     *              - `coord[1]` représente la position y du joueur.
     * @param grille la grille de jeu représentée par un tableau 2D de chaînes de caractères.
     *               Chaque case de la grille contient une valeur représentant l'état du terrain :
     *               - "🟩" : case accessible.
     *               - Autre : case inaccessible.
     * @return `true` si le joueur est éliminé (aucune case verte autour de lui), `false` sinon.
     */

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
    }



