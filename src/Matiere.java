public class Matiere {

    private String code;
    private String nom;
    private int coef;

    public Matiere(String code, String nom, int coef){
        this.code = code;
        this.nom = nom;
        this.coef = coef;
    }

    public String getCode(){
        return code;
    }

    public String getNom(){
        return nom;
    }

    public int getCoefficient(){
        return coef;
    }
}
