package dad;

import dad.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmailApp extends Application  {

  private final RootController rootController = new RootController();

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Mis amigos");
    primaryStage.setScene(new Scene(rootController.getRoot()));
    primaryStage.show();
  }

}
