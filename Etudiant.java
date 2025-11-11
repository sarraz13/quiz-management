import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;
public class Etudiant extends Utilisateur {
    private String groupe;
    private HashMap<Quiz, Integer> scores;
    public Etudiant(String nom, String prenom, String ncin, String groupe) {
        super(nom, prenom, ncin);
        this.groupe = groupe;
        this.scores = new HashMap<>();
    }
    // getters et setters
    public String getGroupe() {
        return groupe;
    }
    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
    public HashMap<Quiz, Integer> getScores() {
        return scores;
    }
    public void setScores(HashMap<Quiz, Integer> scores) {
        this.scores = scores;
    }

    // 1. Visualiser la liste des quiz disponibles
    public void visualiserQuizDisponibles(ArrayList<Quiz> quizzes) {
        System.out.println("Liste des Quiz disponibles de l'enseignant "+quizzes.get(0).getAuteur()+" :");
        for (int i=0;i<quizzes.size();i++) {
            if (scores.containsKey(quizzes.get(i))) {
                System.out.println("-Quiz : " + quizzes.get(i).getTheme() + " (Déjà passé)");
            } else {
                System.out.println("-Quiz : " + quizzes.get(i).getTheme()+ " (Non passé)");
            }
        }
    }

    // 2. Répondre à un quiz
    public void repondreQuiz(Quiz quiz) {
        if (scores.containsKey(quiz)) {
            System.out.println("Vous avez déjà répondu à ce Quiz : " + quiz.getTheme());
            return;
        }
        System.out.println("Quiz : " + quiz.getTheme());
        int score = 0;
        // Assurez-vous qu'il y a des questions dans le quiz
        ArrayList<QCM> questions = quiz.getQuestions();
        if (questions.isEmpty()) {
            System.out.println("Ce quiz ne contient pas de questions.");
            return;
        }
        // Parcours des questions du quiz
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).afficherQuestion(); // Affiche la question
            System.out.print("Votre réponse (numéro de l'option) : ");
            int choix = lireReponseUtilisateur(questions.get(i).getOptions().size());//donne la position de l'option
            // Vérification de la réponse
            if (reponsevrai(questions.get(i).getOptions(), choix)) {
                score += 10; // Exemple de notation
                quiz.getQuestions().get(i).modifierNombreRepCorrectes();
            } else {
                System.out.println("Mauvaise réponse à la question " + (i + 1));
                quiz.getQuestions().get(i).modifierNombreRepIncorrectes();
            }
        }
        // Ajouter le score au HashMap
        scores.put(quiz, score);
        System.out.println("Vous avez terminé le Quiz. Votre score est : " + score+"/"+(quiz.getQuestions().size()*10));
    }

    private boolean reponsevrai(ArrayList<Option> options, int choix) {
        return options.get(choix).isCorrecte(); // Vérifie si l'option choisie est correcte
    }

    // Méthode auxiliaire pour lire une réponse valide de l'utilisateur
    private int lireReponseUtilisateur(int nombreOptions) {
        Scanner sc = new Scanner(System.in);
        int choix = -1; // Initialisation à une valeur invalide
        boolean reponseValide = false;
        
        while (!reponseValide) {
            System.out.print("Entrez votre réponse (1-" + nombreOptions + "): ");
            if (sc.hasNextInt()) { // Vérifie si l'entrée est un entier
                choix = sc.nextInt();
                if (choix >= 1 && choix <= nombreOptions) {
                    reponseValide = true; // Une réponse valide a été donnée
                } else {
                    System.out.println("Veuillez entrer un numéro valide entre 1 et " + nombreOptions);
                }
            } 
            else {
                System.out.println("Veuillez entrer un nombre valide.");
                sc.next(); // Consomme l'entrée invalide pour éviter une boucle infinie
            }
        }
        return choix - 1; // Retourne l'index de l'option (index basé sur 0)
    }

    // 3. Consulter les scores obtenus
    public void consulterScores() {
        if (scores.isEmpty()) {
            System.out.println("Vous n'avez pas encore passé de Quiz.");
        } else {
            System.out.println("Vos scores obtenus :");
            for (Quiz quiz : scores.keySet()) {
                System.out.println("- " + quiz.getTheme() + " : " + scores.get(quiz)+"/"+((quiz.getQuestions().size())*10) );
            }
        }
    }

    // 4. Consulter la correction d’un quiz
    public void consulterCorrection(String themeCorr) {
    	super.afficherInfos();
        Quiz q=new Quiz();
        int quizTrouve=0,i=0;
        Set<Quiz> E=scores.keySet();
        Object[] T=E.toArray();
        while(i<(T.length) && quizTrouve==0){
            if(((Quiz)T[i]).getTheme().equals(themeCorr)){
                quizTrouve=1;
                q=(Quiz)T[i];
            }
            else{
                i++;
            }
        }
        if(quizTrouve==0){
            System.out.println("Vous n'avez pas encore passé ce Quiz : " + themeCorr);
        }
        else {
            System.out.println("Correction du Quiz : " + themeCorr);
            for (int j=0;j<q.getQuestions().size();j++) {
                q.getQuestions().get(j).afficherQuestion();
                System.out.println("Réponse(s) correcte(s) :");
                for (int k=0;k<q.getQuestions().get(j).getOptions().size();k++) {
                    if (q.getQuestions().get(j).getOptions().get(k).isCorrecte()) {
                        System.out.println("  - " + q.getQuestions().get(j).getOptions().get(k).getTexte());
                    }
                }
            }
        }
    }
} 