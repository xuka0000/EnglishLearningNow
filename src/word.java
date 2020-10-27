public class word {
    String spell;
    String mean;
    String partOfSpeech;

    public word(String spell, String mean , String partOfSpeech) {
        this.spell = spell;
        this.mean = mean;
        this.partOfSpeech = partOfSpeech;
    }

    public String getPartOfSpeech() { return partOfSpeech; }

    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }

    public String getSpell() {
        return spell;
    }

    public String getMean() {
        return mean;
    }

    public void setSpell(String spell) { this.spell = spell; }

    public void setMean(String mean) {
        this.mean = mean;
    }
}


