package entity;



public class Chat {
    private String nom;
    private String race;
    private String repaFav;
    private String dateNaissance;

    public Chat(String nom, String race, String repaFav, String dateNaissance) {
        this.nom = nom;
        this.race = race;
        this.repaFav = repaFav;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getRepaFav() {
        return repaFav;
    }
    public void setRepaFav(String repaFav) {
        this.repaFav = repaFav;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    @Override
    public String toString() {
        return "Chat = nom :" + nom + " race : " + race + " dateNaissance : " + dateNaissance;
    }
}
