package de.ttsa.GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessDialog {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    int loadingTime = 850;
    ProcessBuilder processBuilder;
    Process process;
    BufferedReader output = null;
    BufferedWriter input = null;
    BufferedReader error = null;
    Queue<String> outputQueue = new LinkedList<>();
    long startTime;



// ---------------------------------------------- Constructors ------------------------------------------------- //



    public ProcessDialog(String programm, String[] commands) throws IOException, InterruptedException {
        this(programm, new ArrayList<>(Arrays.asList(commands)));
    }

    public ProcessDialog(String programm, List<String> commands) throws IOException, InterruptedException {
        commands.add(0, programm);
        this.processBuilder = new ProcessBuilder(commands);
    }

    public ProcessDialog(String... commands) throws IOException, InterruptedException {
        this(Arrays.asList(commands));
    }

    public ProcessDialog(List<String> command) throws IOException, InterruptedException {
        LinkedList<String> commands = new LinkedList<>(command);
        String programmName = ProcessData.getTerminalName();
        if(ProcessData.isWindows()) commands.addFirst("/c");
        commands.addFirst(programmName);
        processBuilder = new ProcessBuilder(commands);
    }


// ---------------------------------------------- Start -------------------------------------------------- //

    public void start() throws IOException, InterruptedException {
        process = processBuilder.start();
        output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        input = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // Asynchrone Verarbeitung der Ausgabe
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Lesen der Ausgabe
        executorService.submit(() -> {
            try {
                String line;
                while ((line = output.readLine()) != null) {
                    outputQueue.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Lesen der Fehlerausgabe
        executorService.submit(() -> {
            try {
                String line;
                while ((line = error.readLine()) != null) {
                    System.err.println("Error: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Warten, bis beide Threads beendet sind
        executorService.shutdown();
        startTime = System.currentTimeMillis();
    }



// ---------------------------------------------- Methods ---------------------------------------------------- //



    public void input(String input) throws IOException {
        if (process != null) {
            this.input.write(input);
            this.input.newLine();
            this.input.flush();
        }
    }

    public List<String> output() throws InterruptedException {
        long timeLeft = System.currentTimeMillis() - startTime;
        if (timeLeft >= loadingTime) {
            Thread.sleep(2);
        } else {
            Thread.sleep(loadingTime - timeLeft);
        }
        List<String> outputLines = new ArrayList<>();
        // Lesen der Daten aus der Warteschlange
        while (!outputQueue.isEmpty()) {
            outputLines.add(outputQueue.poll());
        }
        return outputLines;
    }

    public List<String> errors() throws IOException {
        List<String> errorLines = new ArrayList<>();
        // Hier keine Fehler sammeln, da bereits in einem anderen Thread verarbeitet
        return errorLines;
    }

    public boolean isRunning() {
        return process.isAlive();
    }

    public void close() {
        try {
            if (output != null) output.close();
            if (input != null) input.close();
            if (error != null) error.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            process.destroy();
        }
    }


    
}