//package seedu.address.ui;
//
//import org.junit.jupiter.api.Test;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//class ResultDisplayTest extends Application {
//
//    private ResultDisplay resultDisplay;
//
//    @Test
//    public void testA() throws InterruptedException {
//
//        Thread thread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                //new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        try {
//                            new ResultDisplayTest().start(new Stage());
//                            assertNotNull(resultDisplay);
//
//                            assertEquals("", resultDisplay.getResultDisplayTextAreaText());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        // initialize
//                        // your app.
//
//                    }
//                });
//            }
//        });
//        thread.start(); // Initialize the thread
//        Thread.sleep(1000); // Time to use the app, with out this, the thread
//        // will be killed before you can tell.
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        resultDisplay = new ResultDisplay();
//        primaryStage.setScene(new Scene(resultDisplay.getRoot(), 100, 100));
//        primaryStage.show();
//    }
//}
