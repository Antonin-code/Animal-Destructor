import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Jeu {
    /*Fonction pour lancer le jeu
    Cette fonction va initialiser le terrain, les joueurs, les coordonnées et va ensuite lancer une boucle
    while jusqu'à ce qu'un joueur gagne
    Cette fonction change les coordonnées d'apparition des joueurs selon le nombre de joueurs
     */
    public static void LancerJeu(short nbjoueurs, List listeJoueurs) {
        //Création du terrain
        String[][] Terrain = Generation.CreationTerrain();

        //Listes des icônes et des coordonnées de chaque joueur
        String[] Joueurs = {"🐰","🐷","🐔","🦊"};
        short[][] PositionJoueurs = {{5,5},{6,5},{6,7},{5,7}};

        //Réduction de la liste d'icônes selon le nombre des joueurs
        Joueurs = Arrays.copyOfRange(Joueurs, 0, nbjoueurs);

        //Changement de la position des joueurs selon leur nombre
        if (nbjoueurs==2){
            PositionJoueurs[0]= new short[]{5, 6};
            PositionJoueurs[1]= new short[]{6, 6};
        }
        else if (nbjoueurs==3){
            PositionJoueurs[0]= new short[]{5, 6};
        }

        //Initialisation des joueurs sur le terrain
        for (int i = 0; i < nbjoueurs; i++) {
            Terrain[PositionJoueurs[i][0]][PositionJoueurs[i][1]] = Joueurs[i];
        }

        //Boucle de gameplay
        for (int i = 0; i < 5; i++) {
            String JoueurActuel = Joueurs[i%nbjoueurs];
            Object PseudoActuel = listeJoueurs.get(i % nbjoueurs);
            System.out.println(JoueurActuel);
            Deplacement.DeplacementJoueur(JoueurActuel,i+1,PositionJoueurs[i%nbjoueurs],Terrain,PseudoActuel);
            DestructionCase.Destruction(Terrain);
        }
    }
}
