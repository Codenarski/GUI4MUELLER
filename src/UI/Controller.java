package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;



public class Controller extends Application implements Initializable {

    @FXML private TextField commandInput;
    @FXML private TextArea commandHistory;

    private LinkedList<String> commandList = new LinkedList<>();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        primaryStage.setTitle("Airport");
        Scene scene = new Scene(root, 700, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> handle(event));
    }

    private void handle(KeyEvent event) {

        if(!commandList.isEmpty()) {
            if (event.getCode() == javafx.scene.input.KeyCode.UP) {
                commandInput.setText(commandList.getFirst());
                commandList.addLast(commandList.getFirst());
                commandList.removeFirst();
            }
        }

        System.out.println("Pressed: " + event.getCode());
    }

    public static void main(String[] args) {
        launch(args);
    }

    private boolean parseString(String input) {

        //TODO: Write Parser
        return true;
    }

    public void enterPressed(ActionEvent actionEvent) {
        String input = commandInput.getText();

        if(parseString(input)) {
            addCommandToHistory(input);
            commandList.add(input);
            System.out.println(commandList.getFirst());
            commandInput.setText("");
        }
        else {
            addCommandToHistory("input is no command");
        }



        //Todo: Inhalt des Textfeldes löschen, in eine Liste oder einen Stack speichern damit man mit Hoch runter alte commands zurückholen kann


    }

    private void addCommandToHistory(String input) {
        if (commandHistory.getText().isEmpty()) {
            commandHistory.appendText(input);
        } else {
            commandHistory.appendText("\n" + input);
        }
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
