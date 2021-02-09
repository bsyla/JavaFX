package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CredentialsEnter {

    public static void display() {
        String rightPassword = "admin";
        Stage window = new Stage();//creating new Stage

        window.setTitle("Enter your credentials");//Giving the window a title

        Button closeButton = new Button("Log In");//Creating a button and the text it will contain

        window.setOnCloseRequest(e -> {e.consume();windowCloser.display(window);} );//in the case user clicks on the red button to close the window

        Label label1 = new Label("Username");//creating labels
        Label label2 = new Label("Password");
        TextField nameInput = new TextField("admin");//creating textfields(by default the credentials will be admin;admin
        TextField passInput = new TextField();
        passInput.setPromptText("Password");//this makes the written text to be greyed out and possible to be overwritten

        closeButton.setOnAction(e -> {//what happens when they click on "Log In"
            String answer = passInput.getText();//the text entered is stored in a local variable called answer
            int a = compareAnswer.stringCompare(rightPassword,answer);//a method belonging to another class is called using the local variable as parameter
            if (a != 0){//if the returned value is not equal to 0 then the use will be notified he entered an incorrect password and that he can either try again or quit
                incorrectAnswer.display(window);
            }
            else {
                tableForTesting caller = new tableForTesting();
            caller.display1();}
            passInput.clear();//clears the content within the password field
        });

        GridPane grid = new GridPane();//createing a new gridPane(type of layout)
        grid.setPadding(new Insets(30,30,30,30));//bland space from corners
        grid.setVgap(8);
        grid.setHgap(10);//blank space horizontal and vertical

        GridPane.setConstraints(label1,0,0);//positioning each one of the object at the exact cell of the grid
        GridPane.setConstraints(label2,0,1);
        GridPane.setConstraints(closeButton,1,4);
        GridPane.setConstraints(nameInput,3,0);
        GridPane.setConstraints(passInput,3,1);

        grid.getChildren().addAll(label1,nameInput,label2,passInput,closeButton);//putting all objects into the grid

        Scene scene = new Scene(grid,400,200);//creating a new scene that his particular layout
        window.setScene(scene);//putting this scene within the particular stage
        window.show();//show scene
    }
}
