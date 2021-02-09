package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tableForTesting{
    Stage window;
    TableView<Product> table;
    TextField titleInput,authorInput,genreInput;

    public void display1(){
        window.setTitle("Table of Books");

        TableColumn<Product,String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Product,String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(200);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Product,String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setMinWidth(200);
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        titleInput = new TextField();
        titleInput.setPromptText("Title");
        titleInput.setMinWidth(100);

        authorInput = new TextField();
        authorInput.setPromptText("Author");

        genreInput = new TextField();
        genreInput.setPromptText("Title");

        Button addButton = new Button("Add button");
        addButton.setOnAction(e->addButtonClicked());
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(titleInput,authorInput,genreInput,addButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(titleColumn,authorColumn,genreColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked(){
        Product product = new Product();
        product.setTitle(titleInput.getText());
        product.setAuthor(authorInput.getText());
        product.setGenre(genreInput.getText());
        table.getItems().add(product);
        titleInput.clear();
        authorInput.clear();
        genreInput.clear();
    }

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Potter","JK Rowling","Fantasy"));
        products.add(new Product("potter2","Rowling","Fantasy"));
        return products;
    }
}

