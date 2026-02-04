package fr.btsciel.tp4_conversionmonnaie;

public class ConversionDevise {
    private  String prompt;
    private  double taux;
    private  String source;
    private  String cible;

    public ConversionDevise(String prompt, String source, String cible, double taux) {
        this.prompt = prompt;
        this.source = source;
        this.cible = cible;
        this.taux = taux;

    }
    public ConversionDevise(){

    }


    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }
}
