public class Option {
    private String texte; 
    private boolean correcte; // Si l'option est correcte ou non
    public Option(String texte, boolean correcte) {
        this.texte = texte;
        this.correcte = correcte;
    }
    public String getTexte() {
        return texte;
    }
    public void setTexte(String texte) {
        this.texte = texte;
    }
    public boolean isCorrecte() {
        return correcte;
    }
    public void setCorrecte(boolean correcte) {
        this.correcte = correcte;
    }
}