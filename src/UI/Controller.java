package UI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

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
}
