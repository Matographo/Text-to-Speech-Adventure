package de.ttsa;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SetInput {

    private InputStream originalIn = System.in;

    private void init() {
        originalIn = System.in;
    }

    public void reinit() {
        System.setIn(originalIn);
    }

    public void makeInput(String input) {
        init();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}