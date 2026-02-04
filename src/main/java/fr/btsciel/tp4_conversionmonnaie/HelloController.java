package fr.btsciel.tp4_conversionmonnaie;


import javafx.animation.RotateTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Button buttonconvers;
    public TextField entreconvers;
    public TextField sortieconvers;
    public Label labelbas;
    public Label labelhaut;
    public ComboBox comboSelection;

    DecimalFormat df = new DecimalFormat("0.0000");
    public RotateTransition rotate;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       remplirCombo();
       labelhaut.setText("Euro");
       labelbas.setText("USD");
       comboSelection.setOnAction((e) -> {
           switch (comboSelection.getSelectionModel().getSelectedIndex()) {
               case 0:
                   buttonconvers.setOnAction(event -> {
                       try{
                           conveurousd(Double.parseDouble(entreconvers.textProperty().getValue().replace(",",".")));
                       } catch (Exception ex){
                           erreur(ex.getMessage());
                       }
                   });
                   break;
               case 1:
                   buttonconvers.setOnAction(event -> {
                       try{
                           convusdeuro(Double.parseDouble(entreconvers.textProperty().getValue().replace(",",".")));
                       } catch (Exception ex){
                           erreur(ex.getMessage());
                       }
                   });
                   break;
               case 2:
                   buttonconvers.setOnAction(event -> {
                       try{
                           conveuroyen(Double.parseDouble(entreconvers.textProperty().getValue().replace(",",".")));
                       } catch (Exception ex){
                           erreur(ex.getMessage());
                       }
                   });

                   break;
               case 3:
                   buttonconvers.setOnAction(event -> {
                       try{
                           convyeneuro(Double.parseDouble(entreconvers.textProperty().getValue().replace(",",".")));
                       } catch (Exception ex){
                           erreur(ex.getMessage());
                       }
                   });
                   break;
               case 4:
                   buttonconvers.setOnAction(event -> {
                       try{
                           conveurolivre(Double.parseDouble(entreconvers.textProperty().getValue().replace(",",".")));
                       } catch (Exception ex){
                           erreur(ex.getMessage());
                       }
                   });
                   break;
               case 5:
                   buttonconvers.setOnAction(event -> {
                       try{
                           convlivreeuro(Double.parseDouble(entreconvers.textProperty().getValue().replace(",",".")));
                       } catch (Exception ex){
                           erreur(ex.getMessage());
                       }
                   });
                   break;
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

    public void rotation(){
        rotate = new RotateTransition(Duration.seconds(2), buttonconvers);
        rotate.setByAngle(180);
        rotate.play();
    }

    public void conveurousd(double nombre){
        labelhaut.setText("Euro");
        labelbas.setText("USD");
        String nombreSortie =df.format(nombre * 1.179);
        sortieconvers.setText(nombreSortie);
    }

    public void convusdeuro(double nombre){
        labelhaut.setText("USD");
        labelbas.setText("Euro");
        String nombreSortie =df.format(nombre / 1.179);
        sortieconvers.setText(nombreSortie);
    }

    public void conveuroyen(double nombre){
        labelhaut.setText("Euro");
        labelbas.setText("Yen");
        String nombreSortie =df.format(nombre * 184.87);
        sortieconvers.setText(nombreSortie);
    }

    public void convyeneuro(double nombre){
        labelhaut.setText("Yen");
        labelbas.setText("Euro");
        String nombreSortie =df.format(nombre / 184.87);
        sortieconvers.setText(nombreSortie);
    }

    public void conveurolivre(double nombre){
        labelhaut.setText("Euro");
        labelbas.setText("Livre Sterling");
        String nombreSortie =df.format(nombre * 0.86);
        sortieconvers.setText(nombreSortie);
    }

    public void convlivreeuro(double nombre){
        labelhaut.setText("Livre Sterling");
        labelbas.setText("Euro");
        String nombreSortie =df.format(nombre / 0.86);
        sortieconvers.setText(nombreSortie);
    }
    public void remplirCombo(){
        ArrayList lista = new ArrayList();
        lista.add("Euro -> USD");
        lista.add("USD -> Euro");
        lista.add("Euro -> Yen");
        lista.add("Yen -> Euro");
        lista.add("Euro -> Livre Sterling");
        lista.add("Livre Sterling -> Euro");
        lista.forEach(event ->{
            comboSelection.getItems().add(event);
        });
    }
}