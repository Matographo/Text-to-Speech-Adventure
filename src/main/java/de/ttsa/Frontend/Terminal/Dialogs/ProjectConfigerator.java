package de.ttsa.Frontend.Terminal.Dialogs;

import java.io.File;
import java.util.Scanner;

import de.ttsa.Logic.Compiler.Functions.Properties.GameProperty;

public class ProjectConfigerator {

    private boolean exit = false;
    private GameProperty gameProperty;
    private Scanner scanner = new Scanner(System.in);
    private File file;

    public void configurate(String path) {
        file = new File(path);
        if (file.exists() && file.isDirectory()) {
            System.out.println("Configuration project: " + file.getName());
        } else {
            System.err.println("Error: The path is not a directory.");
            return;
        }
        gameProperty = new GameProperty(file, true);
        while (!exit) {
            showMenu();
            chooseMenu();
        }
    }

    private void showMenu() {
        System.out.println("1) change Game Title");
        System.out.println("2) change Game Description");
        System.out.println("3) change Game Author");
        System.out.println("4) change Game Language");
        System.out.println("5) change Game Genre");
        System.out.println("6) Save");
        System.out.println("7) Exit");
        System.out.println("0) Save and Exit");
    }

    private void chooseMenu() {
        System.out.print("Choose: ");
        String choose = "";
        choose = readInput();
        switch (choose) {
            case "1" -> changeGameTitle();
            case "2" -> changeGameDescription();
            case "3" -> changeGameAuthor();
            case "4" -> changeGameLanguage();
            case "5" -> changeGameGenre();
            case "6" -> save();
            case "7" -> exit = true;
            case "0" -> {
                save();
                exit = true;
            }
            default -> System.out.println("Error: Invalid choose.");
        }
    }

    private void changeGameTitle() {
        boolean isSaved = false;
        String input = "";
        System.out.println("\nOld Game Title: " + gameProperty.getGameTitle());
        while (!isSaved) {
            System.out.print("New Game Title: ");
            String title = readInput();
            System.out.println("Change Game Title to: " + title + "? (y/n)");
            input = readInput();
            if (input.equals("y") || input.equals("yes")) {
                gameProperty.setGameTitle(title);
                isSaved = true;
            } else if (input.equals("n") || input.equals("no")) {
                isSaved = true;
            }
        }
    }

    private void changeGameDescription() {
        boolean isSaved = false;
        String input = "";
        System.out.println("\nOld Game Description: " + gameProperty.getGameDescription());
        while (!isSaved) {
            System.out.print("New Game Description: ");
            String description = readInput();
            System.out.println("Change Game Description to: " + description + "? (y/n)");
            input = readInput();
            if (input.equals("y") || input.equals("yes")) {
                gameProperty.setGameDescription(description);
                isSaved = true;
            } else if (input.equals("n") || input.equals("no")) {
                isSaved = true;
            }
        }
    }

    private void changeGameAuthor() {
        boolean isSaved = false;
        String input = "";
        System.out.println("\nOld Game Author: " + gameProperty.getGameAuthor());
        while (!isSaved) {
            System.out.print("New Game Author: ");
            String author = readInput();
            System.out.println("Change Game Author to: " + author + "? (y/n)");
            input = readInput();
            if (input.equals("y") || input.equals("yes")) {
                gameProperty.setGameAuthor(author);
                isSaved = true;
            } else if (input.equals("n") || input.equals("no")) {
                isSaved = true;
            }
        }
    }

    private void changeGameLanguage() {
        boolean isSaved = false;
        String input = "";
        System.out.println("\nOld Game Language: " + gameProperty.getGameLanguage());
        while (!isSaved) {
            getLanguageList();
            System.out.print("New Game Language: ");
            String language = readInput();
            if (language.length() != 2) {
                System.out.println("Error: Invalid Language.");
                continue;
            }
            System.out.println("Change Game Language to: " + language + "? (y/n)");
            input = readInput();
            if (input.equals("y") || input.equals("yes")) {
                gameProperty.setGameLanguage(language);
                isSaved = true;
            } else if (input.equals("n") || input.equals("no")) {
                isSaved = true;
            }
        }
    }

    private void getLanguageList() {
        System.out.println("Language List:");
        System.out.println("en - English");
        System.out.println("de - German");
        System.out.println("fr - French");
        System.out.println("es - Spanish");
        System.out.println("it - Italian");
        System.out.println("pt - Portuguese");
        System.out.println("ru - Russian");
        System.out.println("zh - Chinese");
        System.out.println("ja - Japanese");
        System.out.println("ko - Korean");
        System.out.println("ar - Arabic");
        System.out.println("hi - Hindi");
        System.out.println("kn - Kannada");
        System.out.println("th - Thai");
        System.out.println("vi - Vietnamese");
        System.out.println("id - Indonesian");
    }

    private void changeGameGenre() {
        boolean isSaved = false;
        String input = "";
        String output = "";
        for(String genre : gameProperty.getGameGenre()) {
            output = output + genre + ", ";
        }
        System.out.println("\nOld Game Genre: " + output.substring(0, output.length() - 2));
        output = "";
        while (!isSaved) {
            System.out.println("seperate your genres with a comma.");
            System.out.print("New Game Genre: ");
            String genre = readInput();
            String[] genres = genre.split(",");
            for (int i = 0; i < genres.length; i++) {
                genres[i] = genres[i].strip().replaceAll("\\s+", " ");
                output = output + genres[i] + ", ";
            }
            output = output.substring(0, output.length() - 2);
            System.out.println("Change Game Genre to: " + output + "? (y/n)");
            input = readInput();
            if (input.equals("y") || input.equals("yes")) {
                gameProperty.setGameGenre(genres);
                isSaved = true;
            } else if (input.equals("n") || input.equals("no")) {
                isSaved = true;
            }
        }
    }

    private void save() {
        gameProperty.save();
        File project = new File(file.getParent() + "/" + gameProperty.getGameTitle());
        file.renameTo(project);
        file = project;
        gameProperty.setPropertiesPath(file);
    }

    private String readInput() {
        return scanner.nextLine();
    }

    public void showProperties(String path) {
        gameProperty = new GameProperty(new File(path), true);
        System.out.println("Title: " + gameProperty.getGameTitle());
        System.out.println("Description: " + gameProperty.getGameDescription());
        System.out.println("Author: " + gameProperty.getGameAuthor());
        System.out.println("Language: " + gameProperty.getGameLanguage());
        System.out.println("Genre: ");
        if(gameProperty.getGameGenre().length == 0 || gameProperty.getGameGenre() == null || gameProperty.getGameGenre()[0].isBlank()) {
            System.out.println("  - No Genre");
            return;
        }
        for (String genre : gameProperty.getGameGenre()) {
            System.out.println("  - " + genre);
        }
    }
}
