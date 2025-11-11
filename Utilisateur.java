public class Utilisateur {

	private String nom;
	private String prenom;
	private String ncin;
	public Utilisateur() {
		nom ="";
		prenom = "";
	    ncin = "";
	}
	public Utilisateur(String nom, String prenom, String ncin) {
	    this.nom = nom;
		this.prenom = prenom;
		this.ncin = ncin;
	}
	public String getNom() {
	   return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getNcin() {
		return ncin;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNcin(String ncin) {
		this.ncin = ncin;
	}
	// Méthode redéfinie par les sous-classes
	   public  void afficherInfos() {
			 System.out.println("\nNom: " +nom );
			 System.out.println("Prénom: "+ prenom);
			 System.out.println("NCIN: " + ncin);
	   }
}