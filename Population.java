import java.util.Scanner;
import java.text.DecimalFormat;

public class Population {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner keyb = new Scanner(System.in);

        int anneeInitiale = 2011;        // annee initiale
        double tauxCroissance = 1.2;     // taux de croissance, en %
        double populationInitiale = 7.0; // population initiale, en milliard d'humains

        double populationCourante = populationInitiale; // population mondiale pour l'annee courante
        int anneeCourante = anneeInitiale;              // annee de calcul

        System.out.println("====---- PARTIE 1 ----====");
        System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante));

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        //Declare la variable : annee finale entree par l'utilisateur
        int anneeFinale; 
        //Loop tant que l'utilisateur entre une annee finale < a l annee initiale
        do {
            System.out.print("Quelle année (> " + anneeInitiale + ") ? ");   // utilisez cette instruction pour poser votre question :
   	        anneeFinale = keyb.nextInt();
           }   while (anneeFinale <= anneeInitiale);
        //calcule et affiche la population atteinte en annee Finale
        double populationFinale = (populationInitiale * Math.exp ((anneeFinale - anneeInitiale) * 0.012));
        System.out.println("Population en " + anneeFinale   + " : " + df.format(populationFinale)); 
	

        // ===== PARTIE 2 =====
        System.out.println("\n====---- PARTIE 2 ----====");
		
		//Declare la variable :  PopulationCible entree par l'utilisateur
        double populationCible; 
                      
        //Loop tant que l'utilisateur entre une annee PopulationCible < PopulationInitiale
        do {
		System.out.print("Combien de milliards (> 7.0) ?");
   		populationCible = keyb.nextDouble();
           }     while (populationCible < populationInitiale);

        int nb = anneeCourante - anneeInitiale;
        
        do {
        	anneeInitiale += 1;   
        	++nb;
            populationFinale = (populationInitiale  * Math.exp (( nb) * 0.012));
            System.out.println("Population en " + anneeInitiale  + " : " + df.format(populationFinale));
	        anneeCourante +=1;
            }     while (populationFinale < populationCible);

        // ===== PARTIE 3 =====
        System.out.println("\n====---- PARTIE 3 ----====");
        int anneeInitiale2 = 2011;        // annee initiale
        int anneeCourante2 = anneeFinale;
        double populationCourante2 = populationInitiale; // population mondiale pour l'annee courante
        double populationCible2 = populationCible;
        int nb2 = anneeCourante2 - anneeInitiale2;
        int n = 2;
		
		do {
           	 anneeInitiale2 += 1;   
        	 ++nb2;
             populationFinale = (populationInitiale  * Math.exp (( nb2) * 0.012));
        	 populationCourante2 = populationCourante2 * Math.exp (tauxCroissance / 100) ;
        	 anneeCourante2  += 1;
        	 double populationCouranteDouble = Math.floor(populationCourante2);
        	
        	 if (populationCouranteDouble == (n) * populationInitiale) {
         		tauxCroissance/=2;
         		n*=2;
           	  }
        	 System.out.println("Population en " + anneeInitiale2 + " : " + df.format(populationCourante2) + " ; " + "taux de croissance : " + tauxCroissance + "%");
        	 anneeCourante2  += 1;
        	 
           } while (populationCourante2 < populationCible2);
        
        keyb.close();


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
    }
}
