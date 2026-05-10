import javafx.application.Application;
import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloJavaFX extends Application
{
    // Functional Interface: an interface that has only one abstract method.
    // private class CustomEventHandler implements EventHandler<ActionEvent>
    // {
    //     @Override
    //     public void handle(ActionEvent event)
    //     {
    //         System.out.println("Hello World!");
    //     }
    // }

    @Override
    public void start(Stage mainStage) // main entry point to JavaFX applications
    {
        mainStage.setTitle("Hello World Program"); // stage: UI window

        // ref: https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/ui_controls.htm
        Button btn = new Button();
        btn.setText("Print Hello World!");

        // register an instance of CustomEventHandler as a listener of events that are fired by the button
        // btn.setOnAction(new CustomEventHandler()); // register component(s) to event handler(s)

        // EventHandler<ActionEvent> handler = new EventHandler<>()
        // { // anonymous inner class
        //     public void handle(ActionEvent event)
        //     {
        //         System.out.println("Hello World!");
        //     }
        // };
        // btn.setOnAction(handler);

        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        }); // a lambda expression

        // layout defines the arrangement of UI components on a container (like the scene of our stage)
        // ref: https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
        StackPane root = new StackPane(); // layout for a scene
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 300); // scene: content inside the UI window
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
