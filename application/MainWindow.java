package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the main UI window that is displayed at the start of the program. It
 * is the main point of interaction with the user. It allows the user to
 * add/load questions, generate quizes, and analyze information about the
 * currently available quiz database.
 * 
 * @author Robert Keedick
 *
 */
public class MainWindow extends Application {
	private BorderPane root;
//---------------------------------------------------------

	private Label numQuestionL;
	private Label numQuestionValueL;
	private Label numQuestionEntryL;
	private Label topicL;

	private Button addQuestionB;
	private Button loadFileB;
	private Button exitB;
	private Button generateB; // button to generate quiz

	private TextField numQuestionsTF;

	private ComboBox/* < TODO: insert generic type here> */ topicCB;
	private ListView<String> topicListView;
	private ObservableList<String> topicListItems;
	
	private VBox rightPane;
	private VBox leftPane;
	private HBox leftBottomPane;
	private HBox rightBottomPane;
	private HBox leftQuestionInfoPane;
	private HBox leftButtonPane;
	private HBox rightButtonPane;
	private HBox rightNumQuestionPane;
	private HBox rightTopicSelectPane;
	private HBox bottomPane;
	private Scene mainScene;
	
	
	@Override
	public void init() {
		this.root = new BorderPane();
		this.topicListItems = FXCollections.observableArrayList("Topic 1", "Topic 2", "Topic 3");
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			this.setupComponentLayout();
			this.mainScene = new Scene(this.root);
			this.mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
			primaryStage.setScene(this.mainScene);
			primaryStage.setResizable(true);
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void setupComponentLayout() {
		// instantiate control objects
		this.numQuestionL = new Label("Number of questions in database:  ");
		this.numQuestionEntryL = new Label("Number of questions:  ");
		this.numQuestionValueL = new Label("0");
		this.topicL = new Label("Topics:  ");

		this.addQuestionB = new Button("Add Question");
		this.loadFileB = new Button("Load Questions");
		this.exitB = new Button("Exit");
		this.generateB = new Button("Generate Quiz");

		this.numQuestionsTF = new TextField();
		this.numQuestionsTF.setPrefColumnCount(3);
		
		this.topicListView = new ListView<>();
		this.topicListView.setItems(this.topicListItems);
		topicListView.setPrefWidth(100);
		topicListView.setPrefHeight(80);
		
		/*
		 * instantiate combo box and text field
		 */

		// instantiate internal layout containers
		this.rightPane = new VBox();
		this.leftPane = new VBox();
		this.leftQuestionInfoPane = new HBox();
		this.leftButtonPane = new HBox();
		this.rightButtonPane = new HBox();
		this.rightNumQuestionPane = new HBox();
		this.rightTopicSelectPane = new HBox();
		this.bottomPane = new HBox();
		this.rightBottomPane = new HBox();

		// fill right pane
		this.rightNumQuestionPane.getChildren().addAll(this.numQuestionEntryL, this.numQuestionsTF);
		this.rightTopicSelectPane.getChildren().addAll(this.topicL, this.topicListView); // plus topicCB
		this.rightButtonPane.getChildren().add(this.generateB);
		this.rightPane.getChildren().addAll(this.rightTopicSelectPane, this.rightNumQuestionPane);
		this.root.setRight(this.rightPane);

		// fill left pane
		this.leftQuestionInfoPane.getChildren().addAll(this.numQuestionL, this.numQuestionValueL);
		this.leftButtonPane.getChildren().addAll(this.addQuestionB, this.loadFileB);
		this.leftPane.getChildren().addAll(this.leftQuestionInfoPane);
		this.root.setLeft(this.leftPane);
		
		// fill bottom pane
		this.rightBottomPane.getChildren().add(this.rightButtonPane);
		this.bottomPane.getChildren().addAll(this.leftButtonPane, this.rightBottomPane);
		this.root.setBottom(this.bottomPane);
		
		this.leftPane.setPadding(new Insets(5, 25, 5, 5));
		this.rightPane.setPadding(new Insets(5, 5, 5, 25));
		this.rightTopicSelectPane.setPadding(new Insets(5, 5, 5, 5));
		this.rightNumQuestionPane.setPadding(new Insets(5, 5, 5, 5));
		this.rightButtonPane.setPadding(new Insets(5, 5, 5, 25));
		this.leftButtonPane.setPadding(new Insets(5, 5, 5, 5));
		this.rightTopicSelectPane.setAlignment(Pos.TOP_RIGHT);
		this.rightNumQuestionPane.setAlignment(Pos.CENTER_RIGHT);
		//this.generateB.setAlignment(Pos.BOTTOM_RIGHT);
		this.rightButtonPane.setAlignment(Pos.BASELINE_RIGHT);
		this.rightBottomPane.setAlignment(Pos.BASELINE_RIGHT);
		this.leftButtonPane.setAlignment(Pos.BOTTOM_LEFT);
		
		this.bottomPane.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
