import java.util.ArrayList;
import java.util.Scanner;

public class Enseignant extends Utilisateur{
	private ArrayList<Quiz> quizzes;
	public Enseignant() {
	    this.quizzes = new ArrayList<>();    }
    public Enseignant(String nom, String prenom, String ncin) {
        super(nom, prenom, ncin);
        this.quizzes = new ArrayList<>();
    }
    public void afficherInfos() {
    	super.afficherInfos();
    	
    }
    public String getNom() {
        return super.getNom(); 
    }
    public String getPrenom() {
        return super.getPrenom(); 
    }
    public String getNcin() {
        return super.getNcin(); 
    }
    public ArrayList<Quiz> getQuizzes() {
        return this.quizzes;
    }
    public void ajouterQuiz(Quiz q1){
        String th=q1.getTheme();
        int trouve=0,i=0;
        while(i<quizzes.size() && trouve==0){
            if(quizzes.get(i).getTheme().equals(th)){
                trouve=1;
            }
            else{
                i++;
            }
        }
        if(trouve==1){
            System.out.println("Ce quiz existe déjà.");
        }
        else{
            quizzes.add(q1);
            System.out.println("Quiz ajouté pour l'enseignant "+getNom()+" "+getPrenom()+"!");
        }
    }
    public void creerQuiz(String theme) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz(theme, getNom()); 
        System.out.println("Création du Quiz pour le thème : " + theme);
        System.out.print("Combien de questions voulez-vous ajouter ? ");
        int nombreQuestions = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 1; i <= nombreQuestions; i++) {
            System.out.println("Question " + i + ":");
            System.out.print("Entrez le texte de la question : ");
            String texteQuestion = scanner.nextLine();
            QCM question = new QCM(i, texteQuestion);
            System.out.print("Combien d'options pour cette question ? ");
            int nombreOptions = scanner.nextInt();
            scanner.nextLine(); 
            for (int j = 1; j <= nombreOptions; j++) {
                System.out.print("Option " + j + ": ");
                String texteOption = scanner.nextLine();
                int estCorrect = -1;
                do {
                    System.out.print("Est-ce la bonne réponse ? (1 pour oui, 0 pour non) : ");
                    String input = scanner.nextLine();
                    if (input.equals("1") || input.equals("0")) {
                        estCorrect = Integer.parseInt(input);
                    } else {
                        System.out.println("Erreur : Vous devez entrer 1 (oui) ou 0 (non).");
                    }
                } while (estCorrect != 1 && estCorrect != 0);
                question.ajouterOption(new Option(texteOption, estCorrect == 1));
            }
            quiz.ajouterQuestion(question);
        }
        quizzes.add(quiz); // Ajouter le quiz à la liste des quiz de l'enseignant
        System.out.println("Quiz créé avec succès : " );
        quiz.afficherQuiz();
    }
    public void visualiserQuiz(String theme) {
        boolean quizTrouve = false;
        for (int i=0;i<quizzes.size();i++) {
            if (quizzes.get(i).getTheme().equals(theme)) {
                quizTrouve = true;
                System.out.println("Quiz trouvé : " + quizzes.get(i).getTheme());
                System.out.println("Auteur : " + quizzes.get(i).getAuteur());
                for (int j=0;j<quizzes.get(i).getQuestions().size();j++ ){
                    System.out.println("\nQuestion " + quizzes.get(i).getQuestions().get(j).getNumero() + ": " + quizzes.get(i).getQuestions().get(j).getTexte());
                    for (int k=0;k<quizzes.get(i).getQuestions().get(j).getOptions().size();k++) {
                        System.out.println("  Option " + (k+1) + ": " 
                                + quizzes.get(i).getQuestions().get(j).getOptions().get(k).getTexte() + (quizzes.get(i).getQuestions().get(j).getOptions().get(k).isCorrecte() ? " (Correcte)" : ""));
                    }
                }
                break;
            }
        }
        if (!quizTrouve) {
            System.out.println("Aucun quiz trouvé pour le thème : " + theme);
        }
    }
    public int chercherQuiz(String theme) {//retourne la position du quiz si trouvé et 1 sinon
        int res = -1;
	    if (quizzes.isEmpty()) {
	        System.out.println("Aucun quiz disponible pour cet enseignant.");
	        res= -1;
	    }
	    int i = 0;
        int trouve=0;
	    while (i < quizzes.size() && trouve==0) {
	        if (quizzes.get(i).getTheme().equals(theme)) { // Comparaison avec equals
	            System.out.println("Quiz trouvé pour le thème : " + theme);
                trouve=1;
	            res= i;
	        }
            else{
                i++;
            }
	    }
        if(trouve==0){
            System.out.println("Aucun quiz trouvé pour le thème : " + theme);
	        res= -1; // Aucun quiz trouvé
        }
        return res;
	}

     public void supprimerQuiz(String theme) {
        int pos = chercherQuiz(theme);
        if (pos != -1) {
            quizzes.remove(quizzes.get(pos));
            System.out.println("Quiz supprimé : " + theme);
        } 
        else {
            System.out.println("Aucun Quiz trouvé pour le module : " + theme);
        }
    }
 public void modifierQuiz(String theme) {
	    // Recherche du quiz
        Scanner sc1=new Scanner(System.in);
	    int pos = chercherQuiz(theme); 
	    if (pos != -1) {
	        System.out.println("Modification du Quiz pour le module : " + theme);
	        for (int i=0;i<quizzes.get(pos).getQuestions().size();i++) {
	            System.out.println("Question existante : " + quizzes.get(pos).getQuestions().get(i).getNumero() + " - " + quizzes.get(pos).getQuestions().get(i).getTexte());
	            System.out.println("Options actuelles : ");
	            for (int j = 0; j < quizzes.get(pos).getQuestions().get(i).getOptions().size(); j++) {
	                Option option = quizzes.get(pos).getQuestions().get(i).getOptions().get(j);
	                System.out.println(((char)(97+j))+ ") " + option.getTexte() + (option.isCorrecte() ? " (Correcte)" : ""));
	            }

	            System.out.print("Voulez-vous ajouter des options à cette question ? (oui/non) : ");
	            String reponse = sc1.nextLine().trim().toLowerCase();
	            if (reponse.equals("oui")) {
	                System.out.print("Combien d'options voulez-vous ajouter ? : ");
	                int nombreOptions = sc1.nextInt();
	                sc1.nextLine();
	                for (int j = 0; j < nombreOptions; j++) {
	                    System.out.print("Texte de la nouvelle option : ");
	                    String texteOption = sc1.nextLine(); 

	                    boolean cntrl = false;
                        boolean rep;
                        int reponseCorrecte;
                        do {
                            System.out.print("Est-ce une option correcte ? (1 pour oui, 0 pour non) : ");
                            reponseCorrecte = sc1.nextInt();
                            sc1.nextLine(); 
                            if (reponseCorrecte == 1 || reponseCorrecte == 0) {
                                cntrl = true;

                            } else {
                                System.out.println("Réponse invalide. Veuillez entrer 1 pour oui ou 0 pour non.");
                            }
                        } while (!cntrl);//controle de saisie sur 0 et 1
                        if(reponseCorrecte==1){
                            rep=true;
                        }
                        else{
                            rep=false;
                        }
	                    quizzes.get(pos).getQuestions().get(i).ajouterOption(new Option(texteOption, rep));
	                }
	                System.out.println("Nouvelles options ajoutées avec succès !");
	            }
	            System.out.print("Voulez-vous modifier le texte de cette question ? (oui/non) : ");
	            String reponse2 = sc1.nextLine().trim().toLowerCase();
	            if (reponse2.equals("oui")) {
                    System.out.print("Saisir le nouveau texte : ");
	                String newtext = sc1.nextLine();
                    quizzes.get(pos).getQuestions().get(i).setTexte(newtext);
                }
	        }
	        System.out.println("Modification du Quiz terminée.");
	    } 
        else {
	        System.out.println("Aucun Quiz trouvé pour le module : " + theme);
	    }
	}
 

    public void visualiserEtudiantsEtScores(String theme, ArrayList<Etudiant> etudiants) {
        int pos = chercherQuiz(theme); // Chercher le quiz correspondant au thème
        if (pos == -1) {
            System.out.println("Aucun Quiz trouvé pour le module : " + theme);
            return;
        }
        System.out.println("Liste des étudiants ayant passé le quiz du module : " + theme);
        boolean aucunEtudiant = true;
        // Parcourir tous les étudiants pour vérifier ceux qui ont passé le quiz
        for (int i=0;i<etudiants.size();i++) {
            if (etudiants.get(i).getScores().containsKey(quizzes.get(pos))) {
                aucunEtudiant = false;
                int score = etudiants.get(i).getScores().get(quizzes.get(pos)); // Obtenir le score pour le quiz
                System.out.println("- " + etudiants.get(i).getNom() + " " + etudiants.get(i).getPrenom() + " : " + score + "/"+((quizzes.get(pos).getQuestions().size())*10));
            }
        }
        if (aucunEtudiant) {
            System.out.println("Aucun étudiant n'a encore passé ce quiz.");
        }
    }

    public void visualiserQuizsdecetEnseignant(){
        if(quizzes.size()==0){
            System.out.println("Cet enseignant n'a aucun quiz à son actif.");
        }
        else{
            for(int i=0;i<quizzes.size();i++){
                quizzes.get(i).afficherQuiz();
            }
        }
    }

    public void visualiserTauxReponses(String th,ArrayList<Etudiant> etudiants) {
        int i=0,quizTrouve=0,pos=-1;
        while(i<quizzes.size() && quizTrouve==0){
            if(quizzes.get(i).getTheme().equals(th)){
                quizTrouve=1;
                pos=i;
            }
            else{
                i++;
            }
        }
        if(pos==-1){
            System.out.println("Quiz non trouvé .");
        }
        else{
            for (int j=0;j<quizzes.get(pos).getQuestions().size();j++) {//parcours des questions du quiz
                int nbrQuestionsCorrectes = 0;
                int nbrQuestionsIncorrectes = 0;
                int totalAnswers = 0;
                QCM quest=quizzes.get(pos).getQuestions().get(j);
                nbrQuestionsCorrectes=quest.getNombreRepCorrectes();
                nbrQuestionsIncorrectes=quest.getNombreRepIncorrectes();
                totalAnswers=nbrQuestionsCorrectes+nbrQuestionsIncorrectes;
                double pourcentageDequestCorrectes = ((double) nbrQuestionsCorrectes / totalAnswers) * 100;
                double pourcentageDequestIncorrectes = ((double) nbrQuestionsIncorrectes / totalAnswers) * 100;
                System.out.println("Question : " + quest.getTexte());
                System.out.println("Taux de réponses correctes : " + pourcentageDequestCorrectes + "%");
                System.out.println("Taux de réponses incorrectes : " + pourcentageDequestIncorrectes + "%");
            }
        }
    }
    
}