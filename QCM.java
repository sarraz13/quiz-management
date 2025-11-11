import java.util.ArrayList;

public class QCM {
    private int numero; 
    private String texte;
    private int nombreDeReponsesCorrectes;
    private int nombreDeReponsesIncorrectes;
    private ArrayList<Option> options; 
    public QCM(int numero1, String texte1) {
        numero = numero1;
        texte = texte1;
        nombreDeReponsesCorrectes=0;
        nombreDeReponsesIncorrectes=0;
        options = new ArrayList<>();
    }
    public int getNombreRepCorrectes() {
        return nombreDeReponsesCorrectes;
    }
    public int getNombreRepIncorrectes() {
        return nombreDeReponsesIncorrectes;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTexte() {
        return texte;
    }
    public void setTexte(String texte) {
        this.texte = texte;
    }
    public void modifierNombreRepCorrectes(){
        nombreDeReponsesCorrectes++;
    }
    public void modifierNombreRepIncorrectes(){
        nombreDeReponsesIncorrectes++;
    }
    public void ajouterOption(Option option) {
        options.add(option);
    }
    public void afficherQuestion() {
        System.out.println("Question " + numero + ": " + texte);
        for(int i=0;i<options.size();i++) {
            System.out.println(((char)(97+i))+")"+options.get(i).getTexte());
        }   
    }
	public ArrayList<Option> getOptions() {
		return options;
	}	
}