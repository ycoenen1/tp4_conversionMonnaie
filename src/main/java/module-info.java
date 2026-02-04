module fr.btsciel.tp4_conversionmonnaie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.btsciel.tp4_conversionmonnaie to javafx.fxml;
    exports fr.btsciel.tp4_conversionmonnaie;
}