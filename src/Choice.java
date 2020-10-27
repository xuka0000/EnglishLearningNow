public class Choice {
    word word;
    boolean isRight;

    public Choice(word word, boolean isRight) {
        this.word = word;
        this.isRight = isRight;
    }

    public word getWord() {
        return word;
    }

    public void setWord(word word) {
        this.word = word;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
