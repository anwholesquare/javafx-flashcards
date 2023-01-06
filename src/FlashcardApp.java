import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FlashcardApp extends Application {

  private int currentCardIndex = 0;
  private List<Flashcard> flashcards = new ArrayList<>();

  @Override
  public void start(Stage primaryStage) {
    // Create the main layout
    VBox root = new VBox(10);
    root.setPadding(new Insets(10));
    root.setAlignment(Pos.CENTER);

    // Create the label to display the flashcard's question
    Label questionLabel = new Label();

    // Create the button to show the answer
    Button showAnswerButton = new Button("Show Answer");
    showAnswerButton.setOnAction(event -> {
      // Update the label to show the answer
      questionLabel.setText(flashcards.get(currentCardIndex).getAnswer());
    });

    // Create the button to move to the next flashcard
    Button nextButton = new Button("Next");
    nextButton.setOnAction(event -> {
      // Increment the current card index and wrap around if necessary
      currentCardIndex = (currentCardIndex + 1) % flashcards.size();

      // Update the label to show the next flashcard's question
      questionLabel.setText(flashcards.get(currentCardIndex).getQuestion());
    });

    // Add the components to the layout
    root.getChildren().addAll(questionLabel, showAnswerButton, nextButton);

    // Create the scene and set the stage
    Scene scene = new Scene(root, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Flashcard App");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

class Flashcard {
  private String question;
  private String answer;

  public Flashcard(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}
