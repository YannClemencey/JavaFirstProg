import java.util.regex.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static int DemanderAge() {
        /*
         * 1. On crée une instance de la classe Scanner, permettant à un utilisateur de
         * nous communiquer de la donnée via un input.
         * 2. Ensuite, on initialise l'âge à 0 dans une variable que l'on peut utiliser
         * dans un bloc enfant. Ces blocs seront contenus dans une boucle while.
         * 3. La boule while permet au programme de continuer TANT QUE l'âge est supérieur
         * ou égal à zéro, à noter que cette condition est également un cas d'erreur qui sera
         * géré dans une condition IF.
         * 4. Le try/catch est une gestion des exceptions, permettant de lancer un message d'erreur
         * à l'utilisateur.
         * 5. On retourne une valeur à la fonction qui pourra être utilisée par la suite. Si cette
         * dernière ne retourne rien, le type de la classe doit être "void".
         */
        Scanner scanner = new Scanner(System.in);
        byte age = 0;
        while (age <= 0) {
            System.out.println("Donnez votre âge maintenant :");
            try {
                age = scanner.nextByte();
                if (age <= 0) {
                    System.out.println("ERREUR: Veuillez rentrer un âge au-dessus de 0 !");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERREUR : Veuillez rentrer un nombre correct !");
                scanner.nextLine();
            }
        }
        return age;
    }

    public static String DemanderNom() {
        /*
         * 1. On crée une instance de la classe Scanner, permettant à un utilisateur de nous 
         * communiquer de la donnée via un input.
         * 2. On initialise la variable "name" à une "String" vide.
         * On utilise la fonction "matches" de la classe "Pattern" du package "regex", en indiquant que
         * "TANT QUE la regex ne correspond pas à l'input, CONTINUEZ le programme".
         * 3. On indique que SI le nom est vide, qu'il contient des espaces ou des chiffes on renvoi une
         * erreur avec les détails précis de cette dernière. 
         * 4. Enfin, on retourne une valeur à la fonction.
         */
        Scanner scanner = new Scanner(System.in);
        // Demande le nom de la personne :
        String name = "";
        while (!Pattern.matches("^[a-zA-Z]+$", name)) {
            System.out.println("Bonjour Monsieur ! Veuillez rentre un nom :");
            name = scanner.nextLine();

            if (name.isEmpty()) {
                System.out.println("ERREUR : Le nom ne doit pas être une chaine de caractères vide");
            } else if (name.contains(" ")) {
                System.out.println("ERREUR : Le nom ne doit pas contenir d'espace !");
            } else if (name.matches(".*[0-9].*")) {
                System.out.println("ERREUR: Le nom ne doit pas contenir de chiffre !");
            }
        }
        return name;
    }

    public static void main(String[] args) {
        // Demande le nom de la personne :
        String name = DemanderNom();

        // Demande l'âge de la personne :
        int age = DemanderAge();
        System.out.println("Vous vous appellez " + name + ", et vous avez " + age + " ans !");

    }
}
