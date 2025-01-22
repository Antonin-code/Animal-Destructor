import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        boolean AGagne = false;
        int NbTour = 0;
        while(!AGagne){
            //Prochain Joueur
            String JoueurActuel = Joueurs[NbTour%nbjoueurs];
            Object PseudoActuel = listeJoueurs.get(NbTour % nbjoueurs);
            System.out.println(JoueurActuel);

            //Condition de défaite
            if (VictoireDefaite.Defaite(PositionJoueurs[NbTour%nbjoueurs],Terrain)){

                //Si un joueur meurt, retirer son icône et ses coordonnées des listes correspondantes
                Joueurs = RetirerJoueur(Joueurs,(short)(NbTour%nbjoueurs));
                PositionJoueurs = RetirerCoords(PositionJoueurs,(short)(NbTour%nbjoueurs));

                //Mise à jour du joueur actuel et réduction du nombre de joueurs total
                JoueurActuel = Joueurs[NbTour%nbjoueurs];
                nbjoueurs--;

                //S'il ne reste qu'un seul joueur, renvoyer la victoire
                if (nbjoueurs==1)
                {
                    Generation.Affichage(Terrain);
                    System.out.println("gg "+Joueurs[0]+" tu es le plus fort");
                    AGagne = true;
                    continue;
                }
            }

            //Déplacement et attaque du joueur
            Deplacement.DeplacementJoueur(JoueurActuel,NbTour+1,PositionJoueurs[NbTour%nbjoueurs],Terrain,PseudoActuel);
            DestructionCase.Destruction(Terrain);
            NbTour++;
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
    Fonction appelée quand un joueur meurt pour retirer ses coordonnées de la liste des coordonnées
    Cette fonction récupère l'index d'un joueur et la liste des coordonnées et renvoie une nouvelle liste sans
    les coordonnées de ce joueur
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
        return NouvelleListe;
    }
}