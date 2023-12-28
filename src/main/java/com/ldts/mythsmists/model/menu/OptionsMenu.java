package com.ldts.mythsmists.model.menu;

import java.util.Arrays;
import java.util.List;

public class OptionsMenu {

    private final List<String> entries;
    private int curEntry = 0;

    public OptionsMenu() {
        this.entries = Arrays.asList("Volume up", "Volume down", "Mute music", "Change music", "Return to main menu");
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
