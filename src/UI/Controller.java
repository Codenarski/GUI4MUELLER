package UI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import org.controlsfx.control.textfield.TextFields;


public class Controller implements Initializable {

    @FXML private TextField commandInput;
    @FXML private TextArea commandHistory;

    public void close(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void ParseString(ActionEvent actionEvent) {

    }

    public void EnterPressed(ActionEvent actionEvent) {

        if (commandHistory.getText().isEmpty()) {
            commandHistory.appendText(commandInput.getText());
        } else {
            commandHistory.appendText("\n" + commandInput.getText());
        }


        //Todo: Inhalt des Textfeldes löschen, in eine Liste oder einen Stack speichern damit man mit Hoch runter alte commands zurückholen kann


    }

    public void initialize(URL location, ResourceBundle resources) {
        String commands[] = {
                "execute airplane build [A350 | A380]\n",
                "execute airport build\n",
                "execute airport assign airplane to gate [random | <id>]\n",
                "execute airport service waster water for gate <id>\n",
                "execute airport check-in\n",
                "execute airport bulky baggage\n",
                "execute airport security check\n",
                "execute airport passport control\n",
                "execute airport customs\n",
                "execute airport aircargo for gate <id>\n",
                "execute airport baggage-sorting-unit for gate <id>\n",
                "execute airport service-base for gate <id>\n",
                "execute airport service-fresh-water for gate <id>\n",
                "execute airport service-nitrogen-oxygen for gate <id>\n",
                "execute airport sky-tanking for gate <id>\n",
                "execute airport boarding-control for gate <id>\n",
                "execute airport pushback for gate <id>\n",
                "execute airport groundops-logging\n",
                "execute airplane startup\n",
                "execute airplane taxi\n",
                "execute airplane take-off-[normal | engine-fire]\n",
                "execute airplane climbing\n",
                "execute airplane right-turn\n",
                "execute airplane left-turn\n",
                "execute airplane pfd-show"

        };
        TextFields.bindAutoCompletion(commandInput,commands);
    }
}
