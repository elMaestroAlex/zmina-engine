package com.asterai.zminapanel;

import com.asterai.zmina.engine.ZminaEngine;
import com.asterai.zmina.organism.BaseOrganism;
import javafx.fxml.FXML;

public class MainWindowController {

    private ZminaEngine zminaEngine;
    public MainWindowController() {
        super();

        zminaEngine = EngineProvider.getInstance().getEngine();


    }

    @FXML
    public void initialize() {
        preparareInitialOrganisms();
    }

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

    private void preparareInitialOrganisms() {
        zminaEngine.addOrganism(new BaseOrganism());
        zminaEngine.addOrganism(new BaseOrganism());
        zminaEngine.addOrganism(new BaseOrganism());
        zminaEngine.addOrganism(new BaseOrganism());
        zminaEngine.addOrganism(new BaseOrganism());
    }
}