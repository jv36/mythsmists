package com.ldts.mythsmists.model.textsections;
import java.util.List;

public class TextSection {
    private List<String> sentences;

    public TextSection() {
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }


    public int getNumberOfSentences() {
        return this.sentences.size();
    }

    public String getSentence(int i) {
        return sentences.get(i);
    }
}
