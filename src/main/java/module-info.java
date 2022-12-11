module com.example.partfivecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.partfivecalculator to javafx.fxml;
    exports CalculatorPackage;
    opens CalculatorPackage to javafx.fxml;
}