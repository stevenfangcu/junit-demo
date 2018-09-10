package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Random;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HomeScreen extends Application{
	Button solnBtn;
	TextField leftOperandTxtBox,rightOperandTxtBox, ansField;
	ComboBox<String> operatorDropDown;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}
	private void initUI(Stage primaryStage){
		Pane canvas = new Pane();
		
		addControlsToCanvas(canvas);
		setupCardsAnimation(canvas);
		
		Scene scene = new Scene(canvas, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator App");
		primaryStage.show();
	}

	private void setupCardsAnimation(Pane canvas) {
		Image img = null;
		try {
			img = new Image(new FileInputStream("src/main/resources/cores/cards/aceS.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageView imgView = new ImageView();
		imgView.setImage(img);
		imgView.relocate(20, 180);
		
		canvas.getChildren().addAll(imgView);
	}

	private void addControlsToCanvas(Pane canvas) {
		int row1 = 20;
		int row2 = 60;
		int txtBox = 50;
		
		Label label = new Label("Simple Calculator using JavaFX");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
		label.relocate(20, row1);
		
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(txtBox);
		leftOperandTxtBox.relocate(20, row2);
		
		operatorDropDown = new ComboBox<String>();
		operatorDropDown.getItems().addAll("+", "-", "*", "/", "%");
		operatorDropDown.setValue("+");
		operatorDropDown.relocate(80, row2);
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(txtBox);
		rightOperandTxtBox.relocate(150, row2);
		
		
		ansField = new TextField();
		ansField.setMaxWidth(txtBox);
		ansField.setEditable(false);
		ansField.relocate(250, row2);
		
		solnBtn = new Button("=");
		solnBtn.relocate(210, row2);
		
		solnBtnClickerHandler();
		
		canvas.getChildren().addAll(label,
				leftOperandTxtBox,rightOperandTxtBox, 
				operatorDropDown, solnBtn, ansField);
	}

	private void solnBtnClickerHandler() {
		solnBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				String operator = operatorDropDown.getValue();
				
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator, leftOperand, rightOperand));
				
				ansField.setText(answer);
			}
			
		});
		
	}
}
