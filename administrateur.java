import java.util.ArrayList;

public class administrateur extends Utilisateur {

    private ArrayList<Enseignant> enseignants;
    private ArrayList<Etudiant> etudiants;
    // Constructeur
    public administrateur(String nom, String prenom, String ncin) {
        super(nom, prenom, ncin);
        this.enseignants=new ArrayList<>();
        this.etudiants=new ArrayList<>();
    }


    


    public ArrayList<Enseignant> getEnseignants() {
        return enseignants;
    }
    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }





    // Méthode pour afficher les informations de tous les enseignants
    public void afficherEnseignants() {
        if (enseignants.isEmpty()) {
            System.out.println("Il n'y a pas d'enseignants dans la liste.");
        } 
        else {
            System.out.println("Liste des enseignants :");
            // Utilisation de la boucle for classique
            for (int i = 0; i < enseignants.size(); i++) {
                Enseignant enseignant = enseignants.get(i); // Accès à l'enseignant par index
                System.out.println("Enseignant " + (i + 1) + ":");
                enseignant.afficherInfos();
            }
        }
    }


    // Méthode pour afficher les informations de tous les etudiants
    public void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Il n'y a pas d'etudiants dans la liste.");
        } 
        else {
            System.out.println("Liste des etudiants :");
            // Utilisation de la boucle for classique
            for (int i = 0; i < etudiants.size(); i++) {
                Etudiant etudiant = etudiants.get(i); // Accès à l'etudiant par index
                System.out.println("Etudiant " + (i + 1) + ":");
                etudiant.afficherInfos();
            }
        }
    }


    public void ajouterEnseignant(Enseignant enseignant) {
        if (enseignant != null && !enseignants.contains(enseignant)) {
            enseignants.add(enseignant);
            System.out.println("L'enseignant " + enseignant.getNom() + " " + enseignant.getPrenom() + " a été ajouté avec succès.");
        } else {
            System.out.println("L'enseignant est déjà dans la liste ou est invalide.");
        }
    }
    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiant != null && !etudiants.contains(etudiant)) {
            etudiants.add(etudiant);
            System.out.println("L'étudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + " a été ajouté avec succès.");
        } else {
            System.out.println("L'étudiant est déjà dans la liste ou est invalide.");
        }
    }


    public void supprimerEnseignant(String ncin) {
        int trouve = 0,i=0,pos=-1;
        while (i<enseignants.size() && trouve==0) {
            if (enseignants.get(i).getNcin().equals(ncin)) {
                trouve=1;
                pos=i;
            }
            else{
                i++;
            }
        }
        if (trouve==1) {
            enseignants.remove(enseignants.get(pos));
            System.out.println("L'enseignant avec le NCIN " + ncin + " a été supprimé.");
        } else {
            System.out.println("Aucun enseignant trouvé avec le NCIN " + ncin + ".");
        }
    }
    public void supprimerEtudiant(String ncin) {
        int trouve = 0,i=0,pos=-1;
        while (i<etudiants.size() && trouve==0) {
            if (etudiants.get(i).getNcin().equals(ncin)) {
                trouve=1;
                pos=i;
            }
            else{
                i++;
            }
        }
        if (trouve==1) {
            etudiants.remove(etudiants.get(pos));
            System.out.println("L'etudiant avec le NCIN " + ncin + " a été supprimé.");
        } else {
            System.out.println("Aucun etudiant trouvé avec le NCIN " + ncin + ".");
        }
    }





    // Méthode pour visualiser tous les quiz de tous les enseignants
    public void visualiserTousLesQuiz() {
        if (enseignants.isEmpty()) {
        System.out.println("Aucun enseignant n'a créé de quiz.");
        } 

        else {
            System.out.println("Liste des Quiz de tous les enseignants :");
            // Utilisation de la boucle for classique pour parcourir les enseignants
            for (int i = 0; i < enseignants.size(); i++) {
                enseignants.get(i).visualiserQuizsdecetEnseignant();
            }
        }
    }


} 