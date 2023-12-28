package com.ldts.mythsmists.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> entries;
    private int curEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("Start", "Options", "Exit");
    }

    public void nextEntry() {
        curEntry++;
        if (curEntry > this.entries.size() - 1) {
            curEntry = 0;
        }
    }

    public void previousEntry() {
        curEntry--;
        if (curEntry < 0) {
            curEntry = this.entries.size() - 1;
        }
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return curEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

}
