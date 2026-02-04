package fr.btsciel.tp4_conversionmonnaie;


import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Button buttonconvers;
    public TextField entreconvers;
    public TextField sortieconvers;
    DecimalFormat df = new DecimalFormat("0.0000");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            buttonconvers.setOnAction(e -> {
                try{
                    double nombre = Double.parseDouble(entreconvers.textProperty().getValue().replace(",","."));
                    String nombreSortie =df.format(nombre * 1.179);
                    System.out.println(nombreSortie);
                    sortieconvers.setText(nombreSortie);

                } catch (Exception ex){
                   erreur(ex.getMessage());
                }




            });
    }

    public void erreur(String champ){
        Alert dialog = new Alert(Alert.AlertType.WARNING);

        dialog.setTitle("Erreur");
        dialog.setHeaderText(null);
        dialog.setContentText(champ);
        dialog.showAndWait();
    }
}