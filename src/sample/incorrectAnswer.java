package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class incorrectAnswer {
    public static void display(Stage a1) {
        Stage window = new Stage();//creating new Stage
        window.initModality(Modality.APPLICATION_MODAL);//does not allow an action on the background window

        window.setTitle("Incorrect input");//Giving the window a title
        window.setMinWidth(250);//setting the size
        window.setMinHeight(125);

        Label label1 = new Label();//creating labels
        label1.setText("The password your entered is incorrect");//Giving a text to the labels

        Button b1 = new Button("Try again?");//creating the buttons and the texts they hold
        Button b2 = new Button("Quit");

        b1.setOnAction(e->{window.close();});//in case they click on yes they are allowed to try again
        b2.setOnAction(e-> {window.close();a1.close();});//in case they click no they exit the sign in prompt and return to the main menu

        VBox layout = new VBox(10);//Creating a new Layout(VBOX->verticak arrangement)
        layout.getChildren().addAll(label1,b1,b2);
        layout.setAlignment(Pos.BOTTOM_CENTER);//position of the objects within the layout

        Scene scene = new Scene(layout);//creating a new scene that his particular layout
        window.setScene(scene);//putting this scene within the particular stage

        window.showAndWait();//wait until the scene is closed
    }
}
