package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Button button1, button2;//declaring the objects
    @Override
    public void start(Stage window) throws Exception{
        window.setTitle("Type of User");//Create Title of the Scene
        Label label1= new Label("Select the type of user");
        button1 = new Button("Standard");
        button2 = new Button("Admin");

        button1.setOnAction(e -> System.out.println("Test"));//lambda expression
        button2.setOnAction(e -> CredentialsEnter.display());

        window.setOnCloseRequest(e -> {
            e.consume();//confirms that the proceedure followed will be the one we direct
            windowCloser.display(window);
        } );//if the attempt to close they will be asked to confirm the action

        GridPane grid = new GridPane();//using a different type of layout
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(label1,5,0);
        GridPane.setConstraints(button1,4,3);
        GridPane.setConstraints(button2,6,3);

        grid.getChildren().addAll(label1,button1,button2);//adding all the objects within the layout
        Scene scene1 = new Scene(grid,430,200);//creating a new scene with this particular layout

        window.setScene(scene1);//begin the execution with this scene
        window.show();//shows the window
    }
}
