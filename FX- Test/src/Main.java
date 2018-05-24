import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends Application {

    private static final Image IMAGE = new Image("http://upload.wikimedia.org/wikipedia/commons/7/73/The_Horse_in_Motion.jpg");

    private static final int COLUMNS  =   4;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  18;
    private static final int OFFSET_Y =  25;
    private static final int WIDTH    = 374;
    private static final int HEIGHT   = 243;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws FileNotFoundException {

        FileInputStream inputstream = new FileInputStream("D:\\Schule\\ITP_FOES\\Matheaffen\\Matheaffen\\Projektspezifisch\\Bilder\\Photoshop_Mathematikaffe\\biene_ohne.png");
        Image image = new Image(inputstream);


        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitHeight(100);
        iv2.setFitWidth(100);

        final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(new ImagePattern(image));

        Path path2 = new Path();
        path2.getElements().add(new MoveTo(20,20));
        path2.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path2.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        path2.getElements().add(new CubicCurveTo(660, 240, 660, 240, 660, 360));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path2);
        pathTransition.setNode(rectPath);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        primaryStage.setScene(new Scene(new Group(rectPath)));
        primaryStage.show();
    }
}