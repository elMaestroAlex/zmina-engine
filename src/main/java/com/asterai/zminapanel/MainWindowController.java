package com.asterai.zminapanel;

import com.asterai.zmina.engine.ZminaEngine;
import com.asterai.zmina.organism.BaseOrganism;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainWindowController {

    private ZminaEngine zminaEngine;

    @FXML
    ListView m_organismList;

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
    @FXML
    protected void handleOrganismListClick() {
        System.out.print("List click : ");
        System.out.print(m_organismList.getSelectionModel().getSelectedItem());
        System.out.print("\n");
    }

    private void preparareInitialOrganisms() {
        zminaEngine.addOrganism(new BaseOrganism("Vasyl"));
        zminaEngine.addOrganism(new BaseOrganism("Petro"));
        zminaEngine.addOrganism(new BaseOrganism("Poul"));
        zminaEngine.addOrganism(new BaseOrganism("Jasmine"));
        zminaEngine.addOrganism(new BaseOrganism("Kaya"));

        for (var item : zminaEngine.getOrganismList()) {
            m_organismList.getItems().add( String.format("%s : %d", item.getName(), item.getState()));
        }
    }
}