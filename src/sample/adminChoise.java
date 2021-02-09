package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class adminChoise {
    public static void display() {
        Stage window = new Stage();//creating new Stage
        //window.initModality(Modality.APPLICATION_MODAL);//does not allow an action on the background window

        window.setTitle("Choose Action");//Giving the window a title
        window.setMinWidth(250);//setting the size
        window.setMinHeight(125);

        window.setOnCloseRequest(e -> {e.consume();windowCloser.display(window);} );//in the case user clicks on the red button to close the window

        Label label1 = new Label();//creating labels
        label1.setText("What do you want to do?");//Giving a text to the labels

        Button b1 = new Button("Continue");

        ChoiceBox<String> choice = new ChoiceBox<>();
        choice.getItems().addAll("Add Book","Remove Book");
        choice.setValue("Add Book");

        b1.setOnAction( e -> getChoice(choice));

        VBox layout = new VBox(10);//Creating a new Layout(VBOX->verticak arrangement)
        layout.getChildren().addAll(label1,choice,b1);
        layout.setAlignment(Pos.BOTTOM_CENTER);//position of the objects within the layout
        Scene scene = new Scene(layout);//creating a new scene that his particular layout
        window.setScene(scene);//putting this scene within the particular stage
        window.show();
    }

    private static void getChoice(ChoiceBox<String> choice){
        String a="Add Book";
        String b="Remove Book";
        String test = choice.getValue();
        int c =compareAnswer.stringCompare(a,test);
        if (c!=0){
            System.out.println("You will remove a book ");
        }
        else {System.out.println("You will remove a book ");}
    }
}
