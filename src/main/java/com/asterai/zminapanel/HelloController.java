package com.asterai.zminapanel;

import javafx.fxml.FXML;

public class HelloController {

    @FXML
    protected void handleFileNewProjectAction() {
        System.out.println("New project");
    }

    @FXML
    protected void handleEvolutionStartAction() {
        System.out.println("Start evolution");
    }

    @FXML
    protected void handleFileExitAction() {
        System.exit(0);
    }

}