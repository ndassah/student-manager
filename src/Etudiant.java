public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private int age;

    public Etudiant(String matricule,String nom, String prenom, int age){
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getMatricule(){
        return matricule;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public int getAge(){
        return age;
    }

}
