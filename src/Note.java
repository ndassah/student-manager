public class Note {
    private Etudiant etudiant;
    private Matiere matiere;
    private double valeur;

    public Note(Etudiant etudiant, Matiere matiere, double valeur){
        this.etudiant = etudiant;
        this.matiere = matiere;
        this.valeur =valeur;
    }

    public Etudiant getEtudiant(){
        return etudiant;
    }
    public Matiere getMatiere(){
        return matiere;
    }
    public double getValeur(){
        return valeur;
    }
}
