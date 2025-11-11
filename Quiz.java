import java.util.ArrayList;

public class Quiz {
	private String theme; 
    private String auteur; 
    private ArrayList<QCM> questions;
    public Quiz(){
       theme="";
       auteur="";
       questions=new ArrayList<>();
    }
    public Quiz(String theme, String auteur) {
        this.theme = theme;
        this.auteur = auteur;
        this.questions = new ArrayList<>();
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public ArrayList<QCM> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<QCM> questions) {
        this.questions = questions;
    }
    public void ajouterQuestion(QCM question) {
        questions.add(question);
    }
    public void supprimerQuestion(int numero) {
        questions.removeIf(question -> question.getNumero() == numero);
    }
    public void afficherQuiz() {
        System.out.println("Thème du Quiz : " + theme);
        System.out.println("Auteur du Quiz : " + auteur);
        System.out.println("Liste des questions :");
        for (int i=0;i<questions.size();i++) {
            questions.get(i).afficherQuestion();
        }
    }
} 