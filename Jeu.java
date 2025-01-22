import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Jeu {
    /*Fonction pour lancer le jeu
    Cette fonction va initialiser le terrain, les joueurs, les coordonnées et va ensuite lancer une boucle
    while jusqu'à ce qu'un joueur gagne
    Cette fonction change les coordonnées d'apparition des joueurs selon le nombre de joueurs
     */
    public static void LancerJeu(short nbjoueurs) {
        //Création du terrain
        String[][] Terrain = Generation.CreationTerrain();


        //Listes des icônes et des coordonnées de chaque joueur
        String[] Joueurs = {"🐰","🐷","🐔","🦊"};
        short[][] PositionJoueurs = {{5,5},{6,5},{6,7},{5,7}};

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
        for (int i = 0; i < 100; i++) {
            //Prochain Joueur
            String JoueurActuel = Joueurs[i%nbjoueurs];

            //Condition de défaite
            if (VictoireDefaite.Defaite(PositionJoueurs[i%nbjoueurs],Terrain)){
                Joueurs = RetirerJoueur(Joueurs,(short)(i%nbjoueurs));
                PositionJoueurs = RetirerCoords(PositionJoueurs,(short)(i%nbjoueurs));
                System.out.println(Joueurs.length);
                JoueurActuel = Joueurs[i%nbjoueurs];
                nbjoueurs--;
                if (nbjoueurs==1)
                {
                    System.out.println("gg "+Joueurs[0]+" tu es le plus fort");
                }
            }


            //Déplacement et attaque du joueur
            Deplacement.DeplacementJoueur(JoueurActuel,i+1,PositionJoueurs[i%nbjoueurs],Terrain);
            DestructionCase.Destruction(Terrain);




        }
    }

    /*
    Fonction appelée quand un joueur meurt pour le retirer de la liste des joueurs
    Cette fonction récupère l'index d'un joueur et la liste des joueurs et renvoie une nouvelle liste sans
    ce joueur
     */
    public static String[] RetirerJoueur(String[] ListeJoueurs, short indexJoueur) {
        String[] NouvelleListe = new String[ListeJoueurs.length -1] ;
        short NouvelIndex = 0;
        for (short i = 0; i < ListeJoueurs.length; i++) {
            if (i!=indexJoueur){
                NouvelleListe[NouvelIndex] = ListeJoueurs[i];
                NouvelIndex++;
            }
        }
        return NouvelleListe;
    }

    /*
    Fonction appelée quand un joueur meurt pour le retirer de la liste des joueurs
    Cette fonction récupère l'index d'un joueur et la liste des joueurs et renvoie une nouvelle liste sans
    ce joueur
     */
    public static short[][] RetirerCoords(short[][] ListeCoords, short indexCoords) {
        short[][] NouvelleListe = new short[ListeCoords.length -1][] ;
        short NouvelIndex = 0;
        for (short i = 0; i < ListeCoords.length; i++) {
            if (i!=indexCoords){
                NouvelleListe[NouvelIndex] = ListeCoords[i];
                NouvelIndex++;
            }
        }
        System.out.println(NouvelleListe[1][0]);
        return NouvelleListe;
    }
}
