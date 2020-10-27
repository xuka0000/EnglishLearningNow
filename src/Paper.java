public class Paper {

    word[] word;
    String name ;

    public Paper(word[] word, String name) {
        this.word = word;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public word[] getWord() {
        return word;
    }

    public void setWord(word[] word) {
        this.word = word;
    }
}
