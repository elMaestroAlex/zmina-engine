package com.asterai.zminapanel;

import com.asterai.zmina.engine.ZminaEngine;
import com.asterai.zmina.logic.MindModel;
import com.asterai.zmina.organism.BaseOrganism;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class MainWindowController {

    private ZminaEngine zminaEngine;

    @FXML
    ListView m_organismList;
    @FXML
    TextField m_inputValue;
    @FXML
    TextField m_expectedValue;

    public MainWindowController() {
        super();

        zminaEngine = EngineProvider.getInstance().getEngine();
    }

    @FXML
    public void initialize() {
        preparareInitialOrganisms();
    }

    @FXML
    protected void handleEvolutionStartAction() {
        Map<String, Integer> inputModel = new HashMap<>();
        inputModel.put("input", Integer.parseInt(m_inputValue.getText()));
        inputModel.put("expected", Integer.parseInt(m_expectedValue.getText()));

        zminaEngine.run(inputModel);

        updateOrganismsList();
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
        zminaEngine.loadMindset("/Users/alexbaranezky/projects/zmina-panel/mind-src/main.mind");
        zminaEngine.addOrganism(new BaseOrganism("Vasyl"));
        zminaEngine.addOrganism(new BaseOrganism("Petro"));
        zminaEngine.addOrganism(new BaseOrganism("Poul"));
        zminaEngine.addOrganism(new BaseOrganism("Jasmine"));
        zminaEngine.addOrganism(new BaseOrganism("Aurelia"));

        updateOrganismsList();
    }

    void updateOrganismsList() {
        m_organismList.getItems().clear();

        for (var item : zminaEngine.getOrganismList()) {
            m_organismList.getItems().add(String.format("%s : %d", item.getName(), item.getState()));
        }
    }

}