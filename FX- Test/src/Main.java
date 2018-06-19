import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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

        FileInputStream inputstream = new FileInputStream("D:\\Schule\\ITP_FOES\\Matheaffen\\Matheaffen\\Projektspezifisch\\Bilder\\Photoshop_Mathematikaffe\\biene_ohne_gespiegelt.png");
        Image image = new Image(inputstream);

        FileInputStream inputstreamRev = new FileInputStream("D:\\Schule\\ITP_FOES\\Matheaffen\\Matheaffen\\Projektspezifisch\\Bilder\\Photoshop_Mathematikaffe\\biene_180Grad.png");
        Image imageRev = new Image(inputstreamRev);


        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitHeight(100);
        iv1.setFitWidth(100);

        final Rectangle rectPath = new Rectangle (0, 0, 80, 80);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(new ImagePattern(image));

        ImageView iv2 = new ImageView();
        iv2.setImage(imageRev);
        iv2.setFitHeight(100);
        iv2.setFitWidth(100);
        iv2.setRotate(iv2.getRotate() + 180);

        Path path2 = new Path();
        path2.getElements().add(new MoveTo(0,250));
        //Anfang der Biene
        path2.getElements().add(new CubicCurveTo(0, 250, 200, 280, 200, 280));
        path2.getElements().add(new CubicCurveTo(210, 280, 300, 260, 300, 260));
        path2.getElements().add(new CubicCurveTo(310, 260, 400, 240, 400, 240));
        path2.getElements().add(new CubicCurveTo(410, 240, 500, 250, 500, 250));
        path2.getElements().add(new CubicCurveTo(510, 250, 600, 280, 600, 280));
        path2.getElements().add(new CubicCurveTo(610, 280, 700, 250, 700, 250));
        path2.getElements().add(new CubicCurveTo(710, 250, 800, 270, 800, 270));
        path2.getElements().add(new CubicCurveTo(810, 270, 900, 300, 900, 300));
        path2.getElements().add(new CubicCurveTo(910, 300, 1000, 330, 1000, 330));
        path2.getElements().add(new CubicCurveTo(1010, 300, 1100, 330, 1100, 330));
        path2.getElements().add(new CubicCurveTo(1110, 330, 1200, 360, 1200, 360));
        path2.getElements().add(new CubicCurveTo(1210, 360, 1300, 390, 1300, 390));
        path2.getElements().add(new CubicCurveTo(1310, 390, 1400, 420, 1400, 420));
        path2.getElements().add(new CubicCurveTo(1410, 420, 1500, 450, 1500, 450));
        path2.getElements().add(new CubicCurveTo(1510, 420, 1600, 450, 1600, 450));
        path2.getElements().add(new CubicCurveTo(1610, 420, 1700, 450, 1700, 450));
        path2.getElements().add(new CubicCurveTo(1710, 450, 1800, 480, 1800, 480));
        path2.getElements().add(new CubicCurveTo(1810, 480, 1900, 510, 1900, 510));
        path2.getElements().add(new CubicCurveTo(1910, 510, 2000, 480, 2000, 480));
        path2.getElements().add(new CubicCurveTo(2010, 480, 2100, 450, 2100, 450));
        path2.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));
        path2.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));
        path2.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));



        final Rectangle rectPathRev = new Rectangle (0, 0, 80, 80);
        rectPathRev.setArcHeight(10);
        rectPathRev.setArcWidth(10);
        rectPathRev.setFill(new ImagePattern(imageRev));

        Path pathRev = new Path();
        pathRev.getElements().add(new MoveTo(2000,250));
        pathRev.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));
        pathRev.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));
        pathRev.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));
        pathRev.getElements().add(new CubicCurveTo(3010, 480, 2100, 450, 2100, 450));
        pathRev.getElements().add(new CubicCurveTo(2000, 500, 800, 500, 800, 500));
        pathRev.getElements().add(new CubicCurveTo(500, 1000, 0, 1500, 0, 1500));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(18000));
        pathTransition.setPath(path2);
        pathTransition.setNode(rectPath);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.play();

        PathTransition pathTransitionRev = new PathTransition();

        pathTransitionRev.setDuration(Duration.millis(18000));
        pathTransitionRev.setPath(pathRev);
        pathTransitionRev.setNode(rectPathRev);
        pathTransitionRev.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionRev.setCycleCount(Timeline.INDEFINITE);
        pathTransitionRev.play();


        // new Image(url)
        FileInputStream inputstream3 = new FileInputStream("D:\\Schule\\ITP_FOES\\Matheaffen\\Matheaffen\\Projektspezifisch\\Bilder\\Photoshop_Mathematikaffe\\children_background.png");
        Image imagebackground = new Image(inputstream);
        ImageView background = new ImageView(imagebackground);
        /*
// new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(primaryStage.getMaxWidth(), primaryStage.getMaxWidth(), true, true, true, false);
// new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(imagebackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
// new Background(images...)
        Background background = new Background(backgroundImage);
        VBox v1 = new VBox(rectPath,rectPathRev);
        v1.setBackground(background);
        Scene s1=new Scene(new Group(v1));
        primaryStage.setScene(s1);
        */

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                rectPath,rectPathRev,
                background
        );
        VBox.setVgrow(background, Priority.ALWAYS);
        layout.setStyle("-fx-background-image: url(https://imgur.com/gallery/VYANX6C);");
        primaryStage.setTitle("Image Loading Tracker");
        primaryStage.setScene(new Scene(layout, 1315, 1000));
        primaryStage.show();

    }
}