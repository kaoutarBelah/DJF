package fr.ubo.hello.bean;

public class Greeting{

    public Greeting() {
    }

    private String message;
    private String auteur;

    public Greeting(String message, String auteur) {
        this.message = message;
        this.auteur = auteur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}