package de.ttsa.Frontend.Terminal.Dialogs;

import de.ttsa.Logic.Compiler.Functions.ProjectBuilder;

public class ProjectCreator {
    
    
    private String[] args;

    public ProjectCreator(String[] args) {
        this.args = args;
    }
    
    public void create() {
        try {
            String projectName;
            String projectPath;

            if(args.length == 2) {
                if(!args[1].contains("/")) {
                    projectName = args[1];
                    projectPath = System.getProperty("user.dir");
                } else {
                    projectName = "New Game";
                    projectPath = args[1];
                }
            } else {
                if(args[1].contains("/") || args[1].contains("\\")) {
                    projectName = args[2];
                    projectPath = args[1];
                } else {
                    projectName = args[1];
                    projectPath = args[2];
                }
            }

            projectPath = projectPath + "/" + projectName;

            new ProjectBuilder(projectPath).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
