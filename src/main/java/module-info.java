module com.example.partfivecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.partfivecalculator to javafx.fxml;
    exports com.example.partfivecalculator;
    exports CalculatorPackage;
    opens CalculatorPackage to javafx.fxml;
}