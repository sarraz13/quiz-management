import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Création des administrateurs
        List<administrateur> administrateurs = new ArrayList<>();
        administrateur admin1= new administrateur("Abdelli", "Emna", "NCIN1");
        administrateurs.add(admin1);
        administrateur admin2= new administrateur("Admin2", "Nom2", "NCIN2");
        administrateurs.add(admin2);
        
        // Création des enseignants
        Enseignant enseignant1 = new Enseignant("Dupont", "Jean", "11111111");
        Enseignant enseignant2 = new Enseignant("Martin", "Sophie", "22222222");
        Enseignant enseignant3 = new Enseignant("Lefevre", "Paul", "33333333");

        // Ajout des enseignants dans la liste
        admin1.ajouterEnseignant(enseignant1);
        admin1.ajouterEnseignant(enseignant2);
        admin1.ajouterEnseignant(enseignant3);
        admin2.ajouterEnseignant(enseignant1);

        // Création des étudiants

        Etudiant etudiant1 = new Etudiant("Ali", "Ben Salah", "12345678", "G1");
        Etudiant etudiant2 = new Etudiant("Sara", "Mahjoub", "23456789", "G1");
        Etudiant etudiant3 = new Etudiant("Khaled", "Bouslama", "34567890", "G2");



        // Ajout des étudiants dans la liste
        admin1.ajouterEtudiant(etudiant1);
        admin1.ajouterEtudiant(etudiant2);
        admin1.ajouterEtudiant(etudiant3);
        admin2.ajouterEtudiant(etudiant1);



        // Création de quiz pour chaque enseignant
        /*enseignant1.creerQuiz("POO");
        enseignant2.creerQuiz("Algebre");*/

        //test de visualisation
        /*enseignant1.visualiserQuiz("Programmation Orientée Objet");
        enseignant2.visualiserQuiz("Programmation Orientée Objet");//ce n'est pas son test
        enseignant2.visualiserQuiz("Algèbre Linéaire");*/



        // creer un quiz sur la POO pour l'enseignant 1
        Quiz quiz1=new Quiz("POO", enseignant1.getNom());
        QCM quiz1question1 = new QCM(1, "Quelle est la différence entre une classe et un objet ?");
        Option opt1question1quiz1 = new Option("Une classe est une instance d’un objet, un objet est un modèle.", false);
        Option opt2question1quiz1 = new Option("Une classe est un modèle, un objet est une instance.", true);
        Option opt3question1quiz1 = new Option("Ils sont identiques dans le contexte POO.", false);
        quiz1question1.ajouterOption(opt1question1quiz1);  // Option incorrecte
        quiz1question1.ajouterOption(opt2question1quiz1); // Option correcte
        quiz1question1.ajouterOption(opt1question1quiz1);// Option incorrecte
        
        QCM quiz1question2 = new QCM(2, "Parmi les concepts suivants, lequel n’est pas un pilier de la POO ?");
        Option opt1question2quiz1 = new Option("Récursivité", true);
        Option opt2question2quiz1 = new Option("Polymorphisme", false);
        Option opt3question2quiz1 = new Option("Héritage", false);
        quiz1question2.ajouterOption(opt1question2quiz1);  // Option correcte
        quiz1question2.ajouterOption(opt2question2quiz1);  // Option incorrecte
        quiz1question2.ajouterOption(opt3question2quiz1);  // Option incorrecte

        quiz1.ajouterQuestion(quiz1question1);
        quiz1.ajouterQuestion(quiz1question2);
        enseignant1.ajouterQuiz(quiz1);
        

         // creer un quiz sur l'algebre' pour l'enseignant 2
         Quiz quiz2=new Quiz("Algebre", enseignant2.getNom());
         QCM quiz2question1 = new QCM(1, "Dans un espace vectoriel, que signifie \"être linéairement indépendant\" ?");
         Option opt1question1quiz2 = new Option("Les vecteurs forment une base.", false);
         Option opt2question1quiz2 = new Option("Aucun vecteur n’est combinaison linéaire des autres..", true);
         quiz2question1.ajouterOption(opt1question1quiz2);  // Option incorrecte
         quiz2question1.ajouterOption(opt2question1quiz2); // Option correcte
         quiz2.ajouterQuestion(quiz2question1);
         enseignant2.ajouterQuiz(quiz2);


        //creer deux quiz sur la physique pour l'enseignant 3
        Quiz quiz3=new Quiz("Physique Quantique", enseignant3.getNom());
        QCM quiz3question1 = new QCM(1, "Quelle est la nature de la fonction d'onde dans la physique quantique ?");
        Option opt1question1quiz3 = new Option("Une onde qui décrit l'état d'un système quantique", true);
        Option opt2question1quiz3 = new Option("Un champ magnétique", false);
        quiz3question1.ajouterOption(opt1question1quiz3);  // Option correcte
        quiz3question1.ajouterOption(opt2question1quiz3);  // Option incorrecte
        quiz3.ajouterQuestion(quiz3question1);

        QCM quiz3question2 = new QCM(2, "Quel principe est à la base de l'incertitude en physique quantique ?");
        Option opt1question2quiz3 = new Option("Le principe de superposition", false);
        Option opt2question2quiz3 = new Option("Le principe d'incertitude de Heisenberg", true);
        Option opt3question2quiz3 = new Option("La loi de Planck", false);
        quiz3question2.ajouterOption(opt1question2quiz3);  // Option incorrecte
        quiz3question2.ajouterOption(opt2question2quiz3);  // Option correcte
        quiz3question2.ajouterOption(opt3question2quiz3);  // Option incorrecte
        quiz3.ajouterQuestion(quiz3question2);
        enseignant3.ajouterQuiz(quiz3);


        Quiz quiz4=new Quiz("Chimie", enseignant3.getNom());
        QCM quiz4question1 = new QCM(1, "Quelle est la charge électrique d’un neutron ?");
        Option opt1question1quiz4 = new Option("Neutre", true);
        Option opt2question1quiz4 = new Option("Positive", false);
        quiz4question1.ajouterOption(opt1question1quiz4);  // Option correcte
        quiz4question1.ajouterOption(opt2question1quiz4);  // Option incorrecte
        quiz4.ajouterQuestion(quiz4question1);

        QCM quiz4question2 = new QCM(2, "Quelle réaction chimique est utilisée pour transformer un alcène en un alcane ?");
        Option opt1question2quiz4 = new Option("Substitution", false);
        Option opt2question2quiz4 = new Option("Oxydation", false);
        Option opt3question2quiz4 = new Option("Hydrogénation", true);
        quiz4question2.ajouterOption(opt1question2quiz4);  // Option incorrecte
        quiz4question2.ajouterOption(opt2question2quiz4);  // Option incorrecte
        quiz4question2.ajouterOption(opt3question2quiz4);  // Option correcte
        quiz4.ajouterQuestion(quiz4question2);
        enseignant3.ajouterQuiz(quiz4);
        

        admin1.visualiserTousLesQuiz();


        boolean continuer = true;
        int choixPrincipal=0;
        do{

            // Menu d'identification
            System.out.println("\n=== Identification ===");
            System.out.println("1. Administrateur");
            System.out.println("2. Enseignant");
            System.out.println("3. Étudiant");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            choixPrincipal = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            if (choixPrincipal == 4) {
                System.out.println("Au revoir !");
                continuer = false;
                break;
            }
            
            else{
                System.out.print("Entrez votre NCIN : ");
                String ncin = scanner.nextLine();
                if (choixPrincipal == 1) { // Menu Administrateur
                    int adminTrouve=0,j=0;
                    while (j<administrateurs.size() && adminTrouve==0) {
                        administrateur a1=administrateurs.get(j);
                        if (a1.getNcin().equals(ncin)) {
                            adminTrouve=1;
                            /*enseignantConnecte = e1;*/
                        }
                        else{
                            j++;
                        }
                    }
                    if (adminTrouve == 0) {
                        System.out.println("Erreur : Administrateur introuvable !");
                    }
                    else{
                        boolean adminMenu = true;
                        while (adminMenu) {
                            // Menu Administrateur
                            System.out.println("\n=== Menu Administrateur ===");
                            System.out.println("1. Ajouter un Enseignant");
                            System.out.println("2. Ajouter un Étudiant");
                            System.out.println("3. Supprimer un Enseignant");
                            System.out.println("4. Supprimer un Étudiant");
                            System.out.println("5. Visualiser les Enseignants");
                            System.out.println("6. Visualiser les Étudiants");
                            System.out.println("7. Retour");
                            System.out.print("Choisissez une option : ");
                            int choix = scanner.nextInt();
                            scanner.nextLine(); // Consommer le retour à la ligne
                            switch (choix) {
                                case 1: // Ajouter un Enseignant
                                    System.out.print("Entrez le nom de l'enseignant : ");
                                    String nomEnseignant = scanner.nextLine();
                                    System.out.print("Entrez le prénom de l'enseignant : ");
                                    String prenomEnseignant = scanner.nextLine();
                                    System.out.print("Entrez le NCIN de l'enseignant : ");
                                    String ncinEnseignant = scanner.nextLine();
                                    Enseignant enseignantAajouter=new Enseignant(nomEnseignant,prenomEnseignant,ncinEnseignant);
                                    administrateurs.get(j).ajouterEnseignant(enseignantAajouter);
                                    break;
                                case 2: // Ajouter un Étudiant
                                    System.out.print("Entrez le nom de l'étudiant : ");
                                    String nomEtudiant = scanner.nextLine();
                                    System.out.print("Entrez le prénom de l'étudiant : ");
                                    String prenomEtudiant = scanner.nextLine();
                                    System.out.print("Entrez le NCIN de l'étudiant : ");
                                    String ncinEtudiant = scanner.nextLine();
                                    System.out.print("Entrez le groupe de l'étudiant : ");
                                    String groupeEtudiant = scanner.nextLine();
                                    Etudiant nouvelEtudiant = new Etudiant(nomEtudiant, prenomEtudiant, ncinEtudiant, groupeEtudiant);
                                    administrateurs.get(j).ajouterEtudiant(nouvelEtudiant);
                                    break;
                                case 3: //Supprimer un enseignant
                                    System.out.print("Entrez le NCIN de l'enseigant à supprimer : ");
                                    String ncin1 = scanner.nextLine();
                                    admin1.supprimerEnseignant(ncin1);
                                    break;
                                case 4: //Supprimer un etudiant
                                    System.out.print("Entrez le NCIN de l'étudiant à supprimer : ");
                                    String ncin2 = scanner.nextLine();
                                    admin1.supprimerEtudiant(ncin2);
                                    break;
                                case 5: // Visualiser les Enseignants
                                    administrateurs.get(j).afficherEnseignants();
                                    break;
                                case 6: // Visualiser les Étudiants
                                    administrateurs.get(j).afficherEtudiants();
                                    break;
                                case 7: // Retour
                                    adminMenu = false;
                                    break;
                                default:
                                    System.out.println("Option invalide !");
                            }
                        }
                    }
                } 
                else if (choixPrincipal == 2) { // Menu Enseignant
                    /*Enseignant enseignantConnecte = new Enseignant();*/
                    int enseignantTrouve=0,j=0;
                    while (j<admin1.getEnseignants().size() && enseignantTrouve==0) {
                        Enseignant e1=admin1.getEnseignants().get(j);
                        if (e1.getNcin().equals(ncin)) {
                            enseignantTrouve=1;
                            /*enseignantConnecte = e1;*/
                        }
                        else{
                            j++;
                        }
                    }
                    if (enseignantTrouve == 0) {
                        System.out.println("Erreur : Enseignant introuvable !");
                    }
                    else{
                        boolean enseignantMenu = true;
                        while (enseignantMenu) {
                            // Menu Enseignant
                            System.out.println("\n=== Menu Enseignant ===");
                            System.out.println("1. Créer un nouveau Quiz");
                            System.out.println("2. Visualiser un Quiz");
                            System.out.println("3. Supprimer un Quiz");
                            System.out.println("4. Modifier un Quiz");
                            System.out.println("5. Visualiser les étudiants ayant passé un Quiz");
                            System.out.println("6. Visualiser les statistiques d'un Quiz");
                            System.out.println("7. Retour");
                            System.out.println("Choisissez une option : ");
                            int choix = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (choix) {
                                case 1: // Créer un Quiz
                                    System.out.println("Entrez le thème du Quiz : ");
                                    String theme = scanner.nextLine();
                                    admin1.getEnseignants().get(j).creerQuiz(theme);
                                    break;
                                case 2: // Visualiser un Quiz
                                    System.out.println("Entrez le thème du Quiz : ");
                                    String themeVisualiser = scanner.nextLine();
                                    admin1.getEnseignants().get(j).visualiserQuiz(themeVisualiser);
                                    break;
                                case 3: // Supprimer un Quiz
                                    System.out.println("Entrez le thème du Quiz à supprimer : ");
                                    String themeSupprimer = scanner.nextLine();
                                    admin1.getEnseignants().get(j).supprimerQuiz(themeSupprimer);
                                    break;

                                case 4: // Modifier un Quiz
                                    System.out.println("Entrez le thème du Quiz à modifier : ");
                                    String themeModifier = scanner.nextLine();
                                    admin1.getEnseignants().get(j).modifierQuiz(themeModifier);
                                    break;
                                case 5: // Visualiser les étudiants ayant passé un Quiz
                                    System.out.println("Entrez le thème du Quiz à consulter : ");
                                    String themeCons = scanner.nextLine();
                                    admin1.getEnseignants().get(j).visualiserEtudiantsEtScores(themeCons, admin1.getEtudiants());
                                    break;
                                case 6: // Visualiser les stats
                                    System.out.println("Entrez le thème du Quiz dont vous voulez consulter les statistiques : ");
                                    String themeStat = scanner.nextLine();
                                    admin1.getEnseignants().get(j).visualiserTauxReponses(themeStat,admin1.getEtudiants());;
                                    break;
                                case 7: // Retour
                                    enseignantMenu = false;
                                    break;
                                default:
                                    System.out.println("Option invalide !");
                            }
                        }
                    }
                } 
                else if (choixPrincipal == 3) { // Menu Étudiant
                    int etudiantTrouve=0,j=0;
                    while (j<admin1.getEtudiants().size() && etudiantTrouve==0) {
                        Etudiant e1=admin1.getEtudiants().get(j);
                        if (e1.getNcin().equals(ncin)) {
                            etudiantTrouve=1;
                            /*enseignantConnecte = e1;*/
                        }
                        else{
                            j++;
                        }
                    }
                    if (etudiantTrouve == 0) {
                        System.out.println("Erreur : Etudiant introuvable !");
                    }
                    else{
                        boolean etudiantMenu = true;
                        while (etudiantMenu) {
                            // Menu Étudiant
                            System.out.println("\n=== Menu Étudiant ===");
                            System.out.println("1. Visualiser les quiz disponibles");
                            System.out.println("2. Répondre à un quiz");
                            System.out.println("3. Consulter les scores");
                            System.out.println("4. Consulter la correction d'un quiz");
                            System.out.println("5. Retour");
                            System.out.print("Choisissez une option : ");
                            int choix = scanner.nextInt();
                            scanner.nextLine(); 
                            switch (choix) {
                                case 1: // Visualiser les quiz disponibles
                                    System.out.println("Voici la liste des quiz disponibles :");
                                    for(int i=0;i<admin1.getEnseignants().size();i++){
                                        Enseignant ens2=admin1.getEnseignants().get(i);
                                        System.out.println("test "+(i+1));
                                        admin1.getEtudiants().get(j).visualiserQuizDisponibles(ens2.getQuizzes());
                                    }
                                    break;
    
                                case 2: // Répondre à un quiz
                                    System.out.println("Saisir le thème du quiz que vous voulez passer :");
                                    String themeQuiz=scanner.nextLine();
                                    Quiz quizApasser=new Quiz();
                                    for(int i=0;i<admin1.getEnseignants().size();i++){
                                        Enseignant ens2=admin1.getEnseignants().get(i);
                                        int trouve1=ens2.chercherQuiz(themeQuiz);
                                        if(trouve1!=-1){
                                            quizApasser=ens2.getQuizzes().get(trouve1);
                                        }
                                    }
                                    admin1.getEtudiants().get(j).repondreQuiz(quizApasser);
                                    break;
                                case 3: // Consulter les scores
                                    admin1.getEtudiants().get(j).consulterScores();
                                    break;
                                case 4: // Consulter la correction d'un quiz
                                    System.out.println("Saisir le thème du quiz dont vous voulez consulter la correction :");
                                    String themeQuizCorrige=scanner.nextLine();
                                    Quiz quizCorrige=new Quiz();
                                    for(int i=0;i<admin1.getEnseignants().size();i++){
                                        Enseignant ens2=admin1.getEnseignants().get(i);
                                        int trouve1=ens2.chercherQuiz(themeQuizCorrige);
                                        if(trouve1!=-1){
                                            quizApasser=ens2.getQuizzes().get(trouve1);
                                        }
                                    }
                                    admin1.getEtudiants().get(j).consulterCorrection(themeQuizCorrige);
                                    break;
                                case 5://retour
                                    etudiantMenu = false;
                                    break;
                                default:
                                    System.out.println("Option invalide !");
                            }
                        }
                    }
                } 
                else {
                    System.out.println("Option invalide !");
                }
            }
        }while(choixPrincipal!=4);
        scanner.close();
    }

}