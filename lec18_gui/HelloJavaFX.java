import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Minimal JavaFX demo of button-click event handling, shown three equivalent ways:
 * a named inner class (active), an anonymous inner class, and a lambda.
 * <p>
 * The unifying concept is the <b>callback</b>. We hand the framework an object whose
 * {@code handle} method JavaFX will invoke later, when the button fires an
 * {@link ActionEvent}. We never call {@code handle} ourselves — this is
 * <i>inversion of control</i>. Java has no first-class functions, so the callback is
 * delivered as an object whose single method <i>is</i> the callback (the
 * listener / observer pattern; Swing called these "listeners", JavaFX renamed them
 * "handlers", the GoF book calls the underlying pattern "Observer").
 */
public class HelloJavaFX extends Application
{
    /**
     * Callback type for the button's action event.
     * <p>
     * Implements {@link EventHandler}, a <b>functional interface</b> — an interface with
     * exactly one abstract method ({@code handle}). That single-method shape is what
     * lets the same callback be expressed as an anonymous inner class or a lambda; see
     * the commented-out alternatives in {@link #start(Stage)}. All three forms produce
     * an {@code EventHandler<ActionEvent>} that JavaFX invokes identically.
     * <p>
     * As a non-static inner class, every instance also carries an implicit reference to
     * its enclosing {@code HelloJavaFX} instance.
     */
    private class CustomEventHandler implements EventHandler<ActionEvent>
    {
        /**
         * The callback method. JavaFX invokes this on the JavaFX Application Thread when the
         * button fires an {@link ActionEvent} (mouse click, or Space/Enter when focused) —
         * registered via {@link Button#setOnAction(EventHandler)}.
         * <p>
         * This is the <i>asynchronous event</i> flavor of callback: registered now, called
         * back at some later time, possibly never. Contrast with synchronous callbacks like
         * {@code Comparator.compare} being invoked during {@code Collections.sort}.
         *
         * @param event metadata about the firing (source, target, etc.); ignored here
         */
        @Override
        public void handle(ActionEvent event)
        {
            System.out.println("Hello World!");
        }
    }

    @Override
    public void start(Stage mainStage) // main entry point to JavaFX applications
    {
        mainStage.setTitle("Hello World Program"); // stage: UI window

        // ref: https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/ui_controls.htm
        Button btn = new Button();
        btn.setText("Print Hello World!");

        // register an instance of CustomEventHandler as a listener of events that are fired by the button
        btn.setOnAction(new CustomEventHandler()); // register component(s) to event handler(s)

        // --- Anonymous Inner Class ---
        // EventHandler<ActionEvent> handler = new EventHandler<>()
        // {
        //     public void handle(ActionEvent event)
        //     {
        //         System.out.println("Hello World!");
        //     }
        // };
        // btn.setOnAction(handler);

        // --- Lambda Expression ---
        // btn.setOnAction((ActionEvent event) -> {
        //     System.out.println("Hello World!");
        // });

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
