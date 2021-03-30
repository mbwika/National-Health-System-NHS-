package nhs.gov.ke;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Collins Mbwika <elitetech.com>
 */

public class Main extends Application {
    
    private static BorderPane primaryLayout, mainLayout;
    private static Stage primaryStage, mainStage;
    
    @Override
    public void start(Stage stage) {
        Parent loaderRoot = null;
        try {
            loaderRoot = FXMLLoader.load(getClass().getResource("view/home.fxml"));
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene loadScene = new Scene(loaderRoot);
        stage.setScene(loadScene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/blue_h.png")));

        stage.show();


        primaryStage = new Stage(StageStyle.TRANSPARENT);
        primaryStage.setTitle("NATIONAL HEALTH SYSTEM");
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/blue_h.png")));
        setStage(primaryStage);
        
        mainStage = new Stage(StageStyle.TRANSPARENT);
        mainStage.setTitle("NATIONAL HEALTH SYSTEM");
        mainStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/blue_h.png")));
        setMainStage(mainStage);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> {
                try {
                    Thread.sleep(1000);
                    try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/login.fxml"));
                    primaryLayout = loader.load();
                    Parent root = primaryLayout;

                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    stage.hide();
                    
                    //when screen is dragged, translate it accordingly
                primaryLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        primaryStage.setX(me.getScreenX() - initX);
                        primaryStage.setY(me.getScreenY() - initY);
                    }
                });
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            });
        }   catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }).start();
            
    }
    
    
    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

        public static void setRoot() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/login.fxml"));
        primaryLayout = loader.load();
    }
    
    public static void showLogin() throws IOException{
                    try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/login.fxml"));
                    primaryLayout = loader.load();
                    Parent root = primaryLayout;

                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    mainStage.hide();
                    
                    //when screen is dragged, translate it accordingly
                primaryLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        primaryStage.setX(me.getScreenX() - initX);
                        primaryStage.setY(me.getScreenY() - initY);
                    }
                });
                    
                      
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }          
            
    }
    
    
        public static void showLanding() throws IOException{
        
         try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/landing.fxml"));
                    mainLayout = loader.load();
                    Parent root = mainLayout;

                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                    primaryStage.hide();
                    //when mouse button is pressed, save the initial position of screen
                mainLayout.setOnMousePressed(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        initX = me.getScreenX() - mainStage.getX();
                        initY = me.getScreenY() - mainStage.getY();
                    }
                });
 
                //when screen is dragged, translate it accordingly
                mainLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        mainStage.setX(me.getScreenX() - initX);
                        mainStage.setY(me.getScreenY() - initY);
                    }
                });
                    

                        
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
                


