import java.util.ArrayList;
import java.util.Scanner;

// Classe principale
public class GestionNotes {
    private static ArrayList<Etudiant> etudiants = new ArrayList<>();
    private static ArrayList<Matiere> matieres = new ArrayList<>();
    private static ArrayList<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Menu Principal :");
            System.out.println("1. Saisir les informations de la classe");
            System.out.println("2. Afficher les résultats par ordre de mérite");
            System.out.println("3. Afficher le premier et le dernier de la classe");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    saisirInformations(scanner);
                    break;
                case 2:
                    afficherResultats();
                    break;
                case 3:
                    afficherPremierEtDernier();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 4);

        scanner.close();
    }

    private static void saisirInformations(Scanner scanner) {
        System.out.print("Nombre d'étudiants : ");
        int effectif = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < effectif; i++) {
            System.out.println("Étudiant " + (i + 1) + ":");
            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();
            System.out.print("Âge : ");
            int age = scanner.nextInt();
            scanner.nextLine();
            etudiants.add(new Etudiant(matricule, nom, prenom, age));
        }

        System.out.print("Nombre de matières : ");
        int nbMatieres = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nbMatieres; i++) {
            System.out.println("Matière " + (i + 1) + ":");
            System.out.print("Code : ");
            String code = scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Coefficient : ");
            int coefficient = scanner.nextInt();
            scanner.nextLine();
            matieres.add(new Matiere(code, nom, coefficient));
        }

        for (Etudiant etudiant : etudiants) {
            for (Matiere matiere : matieres) {
                System.out.print("Note de " + etudiant.getNom() + " en " + matiere.getNom() + ": ");
                double valeur = scanner.nextDouble();
                notes.add(new Note(etudiant, matiere, valeur));
            }
        }
    }

    private static void afficherResultats() {
        ArrayList<String[]> resultats = new ArrayList<>();

        for (Etudiant etudiant : etudiants) {
            double totalNotes = 0;
            int totalCoef = 0;

            for (Note note : notes) {
                if (note.getEtudiant().equals(etudiant)) {
                    totalNotes += note.getValeur() * note.getMatiere().getCoefficient();
                    totalCoef += note.getMatiere().getCoefficient();
                }
            }

            double moyenne = totalCoef > 0 ? totalNotes / totalCoef : 0;
            resultats.add(new String[]{etudiant.getNom(), etudiant.getMatricule(), String.format("%.2f", moyenne)});
        }

        resultats.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));

        System.out.println("Résultats par ordre de mérite :");
        for (String[] res : resultats) {
            System.out.println("Nom : " + res[0] + ", Matricule : " + res[1] + ", Moyenne : " + res[2]);
        }
    }

    private static void afficherPremierEtDernier() {
        if (etudiants.isEmpty() || notes.isEmpty()) {
            System.out.println("Aucun étudiant ou note enregistrée !");
            return;
        }

        ArrayList<String[]> resultats = new ArrayList<>();

        for (Etudiant etudiant : etudiants) {
            double totalNotes = 0;
            int totalCoef = 0;

            for (Note note : notes) {
                if (note.getEtudiant().equals(etudiant)) {
                    totalNotes += note.getValeur() * note.getMatiere().getCoefficient();
                    totalCoef += note.getMatiere().getCoefficient();
                }
            }

            double moyenne = totalCoef > 0 ? totalNotes / totalCoef : 0;
            resultats.add(new String[]{etudiant.getNom(), etudiant.getMatricule(), String.format("%.2f", moyenne)});
        }

        resultats.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));

        System.out.println("Premier de la classe :");
        System.out.println("Nom : " + resultats.get(0)[0] + ", Matricule : " + resultats.get(0)[1] + ", Moyenne : " + resultats.get(0)[2]);

        System.out.println("Dernier de la classe :");
        System.out.println("Nom : " + resultats.get(resultats.size() - 1)[0] + ", Matricule : " + resultats.get(resultats.size() - 1)[1] + ", Moyenne : " + resultats.get(resultats.size() - 1)[2]);
    }
}
