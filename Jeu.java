import java.util.Arrays;

public class Jeu {
    public static void LancerJeu() {
        String[][] Terrain = Generation.CreationTerrain();
        Generation.Affichage(Terrain);
        String[] Joueurs = {"🐰","🐷","🐔","🦊"};
        short nbjoueurs = 4;
        short[][] PositionJoueurs = {{5,5},{6,5},{5,7},{6,7}};
        Joueurs = Arrays.copyOfRange(Joueurs, 0, nbjoueurs);
        for (int i = 0; i < nbjoueurs; i++) {
            Terrain[PositionJoueurs[i][0]][PositionJoueurs[i][1]] = Joueurs[i];
        }
        for (int i = 0; i < 5; i++) {
            String JoueurActuel = Joueurs[i%nbjoueurs];
            System.out.println(JoueurActuel);
            Deplacement.DeplacementJoueur(JoueurActuel,i+1,PositionJoueurs[i%nbjoueurs],Terrain);
            DestructionCase.Destruction(Terrain);
        }
    }
}
