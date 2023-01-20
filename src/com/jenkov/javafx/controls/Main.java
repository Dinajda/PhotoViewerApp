
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.scene.layout.StackPane;


public class Main extends Application  {

Image currentImage;
int currentNumber;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ImageView Experiment 1");

        List<Image> images = new ArrayList<>();

        FileInputStream input = new FileInputStream("lokiconfused.jpg");
        Image image = new Image(input);

        FileInputStream input2 = new FileInputStream("lokihat.jpg");
        Image image2 = new Image(input2);

        FileInputStream input3 = new FileInputStream("lokisitting.jpg");
        Image image3 = new Image(input3);

        FileInputStream input4 = new FileInputStream("lokiingrass.jpg");
        Image image4 = new Image(input4);

        FileInputStream input5 = new FileInputStream("sleepyloki.jpg");
        Image image5 = new Image(input5);

        images.add(image);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(540.5);
        imageView.setFitWidth(453.75);
        imageView.setLayoutX(200);
        imageView.setLayoutY(200);

        Button button = new Button("Next");
        button.setLayoutX(10);
        button.setLayoutY(10);
        button.setOnAction(actionEvent -> {
            System.out.println(currentNumber);
            if (currentNumber < 4) {
                currentNumber = currentNumber + 1;
        } else {
            currentNumber = 0;
        }
            imageView.setImage(images.get(currentNumber));

        });

        TextArea textArea = new TextArea();

        StackPane stackPane = new StackPane(imageView, textArea);

        VBox vbox = new VBox(imageView, button);
        vbox.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(vbox, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
