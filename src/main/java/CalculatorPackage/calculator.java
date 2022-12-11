package CalculatorPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class calculator extends Application {
    // Create variables to store the current number and operation
    String currentNumber = "";
    String currentOperation = "";
    double storedNumber;
    double result;
    String displayEquation = "";
    Boolean isDone = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the text field where the result will be displayed
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // Set result to 0 as default
        resultField.setText("0");

        // Create the buttons for the CalculatorPackage.calculator
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button btnAdd = new Button("+");
        Button btnSubtract = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        Button btnEquals = new Button("=");
        Button btnClear = new Button("C");

        // Create the layout for the buttons
        GridPane gridPane = new GridPane();
        gridPane.add(btn1, 0, 0);
        gridPane.add(btn2, 1, 0);
        gridPane.add(btn3, 2, 0);
        gridPane.add(btn4, 0, 1);
        gridPane.add(btn5, 1, 1);
        gridPane.add(btn6, 2, 1);
        gridPane.add(btn7, 0, 2);
        gridPane.add(btn8, 1, 2);
        gridPane.add(btn9, 2, 2);
        gridPane.add(btn0, 0, 3);
        gridPane.add(btnAdd, 3, 0);
        gridPane.add(btnSubtract, 3, 1);
        gridPane.add(btnMultiply, 3, 2);
        gridPane.add(btnDivide, 3, 3);
        gridPane.add(btnEquals, 2, 3);
        gridPane.add(btnClear, 1, 3);

        // Fill space with the buttons
        GridPane.setHgrow(btn0, Priority.ALWAYS);
        GridPane.setHgrow(btn1, Priority.ALWAYS);
        GridPane.setHgrow(btn2, Priority.ALWAYS);
        GridPane.setHgrow(btn3, Priority.ALWAYS);
        GridPane.setHgrow(btn4, Priority.ALWAYS);
        GridPane.setHgrow(btn5, Priority.ALWAYS);
        GridPane.setHgrow(btn6, Priority.ALWAYS);
        GridPane.setHgrow(btn7, Priority.ALWAYS);
        GridPane.setHgrow(btn8, Priority.ALWAYS);
        GridPane.setHgrow(btn9, Priority.ALWAYS);

        GridPane.setVgrow(btn0, Priority.ALWAYS);
        GridPane.setVgrow(btn1, Priority.ALWAYS);
        GridPane.setVgrow(btn2, Priority.ALWAYS);
        GridPane.setVgrow(btn3, Priority.ALWAYS);
        GridPane.setVgrow(btn4, Priority.ALWAYS);
        GridPane.setVgrow(btn5, Priority.ALWAYS);
        GridPane.setVgrow(btn6, Priority.ALWAYS);
        GridPane.setVgrow(btn7, Priority.ALWAYS);
        GridPane.setVgrow(btn8, Priority.ALWAYS);
        GridPane.setVgrow(btn9, Priority.ALWAYS);


        // Create the main layout and add the result field and button grid
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(resultField);
        mainPane.setCenter(gridPane);

// Create the scene and add the main layout
        Scene scene = new Scene(mainPane, 401, 400);

// Create the event handler for the number buttons
        EventHandler<ActionEvent> numberHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Solve second equation
                if (isDone) {
                    // Clear the result field and reset the storage
                    resultField.clear();
                    currentNumber = "";
                    storedNumber = 0;
                    displayEquation = "";

                    // Indicate that equation is reset
                    isDone = false;
                }

                // Get the button that was clicked
                Button btn = (Button) event.getSource();

                // Add button to displayEquation
                displayEquation += btn.getText();
                resultField.setText(displayEquation);

                // Append the button's text to the current number string
                currentNumber += btn.getText();

            }
        };

// Set the event handler for each of the number buttons
        btn1.setOnAction(numberHandler);
        btn2.setOnAction(numberHandler);
        btn3.setOnAction(numberHandler);
        btn4.setOnAction(numberHandler);
        btn5.setOnAction(numberHandler);
        btn6.setOnAction(numberHandler);
        btn7.setOnAction(numberHandler);
        btn8.setOnAction(numberHandler);
        btn9.setOnAction(numberHandler);
        btn0.setOnAction(numberHandler);

// Create the event handler for the operation buttons
        EventHandler<ActionEvent> operationHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get the button that was clicked
                Button btn = (Button) event.getSource();

                // Store the current number in a variable
                storedNumber = Double.parseDouble(currentNumber);

                // Set the current number string to be empty
                currentNumber = "";

                // Set the current operation to the button's text
                currentOperation = btn.getText();

                // Add operation to the display text
                displayEquation += btn.getText();

                // Display new value
                resultField.setText(displayEquation);
            }
        };

// Set the event handler for each of the operation buttons
        btnAdd.setOnAction(operationHandler);
        btnSubtract.setOnAction(operationHandler);
        btnMultiply.setOnAction(operationHandler);
        btnDivide.setOnAction(operationHandler);

// Create the event handler for the equals button
        EventHandler<ActionEvent> equalsHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Parse the current number as a double
                double current = Double.parseDouble(currentNumber);

                // Perform the operation on the stored number and the current number
                if (currentOperation.equals("+")) {
                    result = storedNumber + current;
                } else if (currentOperation.equals("-")) {
                    result = storedNumber - current;
                } else if (currentOperation.equals("*")) {
                    result = storedNumber * current;
                } else if (currentOperation.equals("/")) {
                    result = storedNumber / current;
                }

                // Format the result as a string with two decimal places
                String resultString = String.format("%.2f", result);

                // Set the current number string to be the result
                currentNumber = resultString;

                // Add resultString to display
                displayEquation += ("=" + resultString);

                // Display new value
                resultField.setText(displayEquation);

                // Indicate equation is finished, prep clear command
                isDone = true;

            }
        };

// Set the event handler for the equals button
        btnEquals.setOnAction(equalsHandler);

// Create the event handler for the clear button
        EventHandler<ActionEvent> clearHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Clear the result field and reset the storage
                resultField.clear();
                currentNumber = "";
                storedNumber = 0;
                displayEquation = "";

                // Indicate that equation is reset
                isDone = false;
            }
        };

// Set the event handler for the clear button
        btnClear.setOnAction(clearHandler);

// Add the scene to the stage and show
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
}
