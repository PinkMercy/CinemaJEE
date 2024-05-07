package modele.entities;

public class Film {
    private int id;
    private String titre;
    private String realisateur;
    private String description;
    private String dateSortie;
    private String duree;
    private String image;
    private int idCategorie;

    public Film() {
        super();
    }

    public Film(int id, String titre, String realisateur, String description, String dateSortie, String duree, String image,
            int idCategorie) {
        super();
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
        this.description = description;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.image = image;
        this.idCategorie = idCategorie;
    }

    public Film(String titre, String realisateur, String description, String dateSortie, String duree, String image,
            int idCategorie) {
        super();
        this.titre = titre;
        this.realisateur = realisateur;
        this.description = description;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.image = image;
        this.idCategorie = idCategorie;
    }

    public Film(String titre, String realisateur, String description, String dateSortie, String duree, String image) {
        super();
        this.titre = titre;
        this.realisateur = realisateur;
        this.description = description;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.image = image;
    }

    public Film(int id, String titre, String realisateur, String description, String dateSortie, String duree, String image) {
        super();
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
        this.description = description;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.image = image;
    }

    public Film(int id, String titre, String realisateur, String description, String dateSortie, String duree) {
        super();
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
        this.description = description;
        this.dateSortie = dateSortie;
        this.duree = duree;
    }

    public Film(String titre, String realisateur, String description, String dateSortie, String duree) {
        super();
        this.titre = titre;
        this.realisateur = realisateur;
        this.description = description;
        this.dateSortie = dateSortie;
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public String getDescription() {
        return description;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public String getDuree() {
        return duree;
    }

    public String getImage() {
        return image;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
}
