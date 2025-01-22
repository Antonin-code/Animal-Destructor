import java.util.Objects;

/*
  Fonction qui permet de verfier si autour d'un joueur il y a pas de case verte le joueur des eliminer.
  Puis si il ne reste que un joueur celui-ci gagne la partie
   */
public class VictoireDefaite
{

    public static boolean Defaite (short[] coord, String[][] grille)
    {
        //mise en place des coordonee
        short coordx = coord[0];
        short coordy = coord[1];

        //regarder si il y a encore une case verte autour
        if (!Objects.equals(grille[coordx + 1][coordy], "🟩") && !Objects.equals(grille[coordx - 1][coordy], "🟩") && !Objects.equals(grille[coordx][coordy + 1], "🟩") && !Objects.equals(grille[coordx][coordy - 1], "🟩"))
        {
            //si oui on continue si non on le tue
            return true;
        }
        return false;

    }


}
