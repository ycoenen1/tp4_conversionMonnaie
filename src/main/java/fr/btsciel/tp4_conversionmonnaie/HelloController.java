package fr.btsciel.tp4_conversionmonnaie;


import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.util.Duration;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button buttonConvertion;
    @FXML
    private TextField textField_Init;
    @FXML
    private TextField textField_Final;
    @FXML
    private Label label_Final;
    @FXML
    private Label label_Init;
    @FXML
    private ComboBox comboSelection;
    private final double taux_Euro_Livre = 0.86;
    private final double taux_Euro_Dollar = 1.179;
    private final double taux_Euro_Yen = 184.8;
    private ArrayList<ConversionDevise> conversionDevise;
    private final DecimalFormat df = new DecimalFormat("0.0000");
    public RotateTransition rotate;
    private double valeur_Final;
    private double valeur_Conversion;
    private double valeur_Init;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        comboSelection();
        fabriqueDonnees();
        label_Init.setText("Euro");
        label_Final.setText("USD");
        comboSelection.setOnAction((e) -> {
            switch (comboSelection.getSelectionModel().getSelectedIndex()) {
                case 0:
                    buttonConvertion.setOnAction(event -> {
                        try {
                            conveurousd(Double.parseDouble(textField_Init.textProperty().getValue().replace(",", ".")));
                        } catch (Exception ex) {
                            alerteFormat(ex.getMessage());
                        }
                    });
                    break;
                case 1:
                    buttonConvertion.setOnAction(event -> {
                        try {
                            convusdeuro(Double.parseDouble(textField_Init.textProperty().getValue().replace(",", ".")));
                        } catch (Exception ex) {
                            alerteFormat(ex.getMessage());
                        }
                    });
                    break;
                case 2:
                    buttonConvertion.setOnAction(event -> {
                        try {
                            conveuroyen(Double.parseDouble(textField_Init.textProperty().getValue().replace(",", ".")));
                        } catch (Exception ex) {
                            alerteFormat(ex.getMessage());
                        }
                    });

                    break;
                case 3:
                    buttonConvertion.setOnAction(event -> {
                        try {
                            convyeneuro(Double.parseDouble(textField_Init.textProperty().getValue().replace(",", ".")));
                        } catch (Exception ex) {
                            alerteFormat(ex.getMessage());
                        }
                    });
                    break;
                case 4:
                    buttonConvertion.setOnAction(event -> {
                        try {
                            conveurolivre(Double.parseDouble(textField_Init.textProperty().getValue().replace(",", ".")));
                        } catch (Exception ex) {
                            alerteFormat(ex.getMessage());
                        }
                    });
                    break;
                case 5:
                    buttonConvertion.setOnAction(event -> {
                        try {
                            convlivreeuro(Double.parseDouble(textField_Init.textProperty().getValue().replace(",", ".")));
                        } catch (Exception ex) {
                            alerteFormat(ex.getMessage());
                        }
                    });
                    break;
            }
        });
    }

    public void alerteFormat(String champ) {
        Alert dialog = new Alert(Alert.AlertType.WARNING);
        dialog.setTitle("Erreur");
        dialog.setHeaderText(null);
        dialog.setContentText(champ);
        dialog.showAndWait();
    }

    public void rotation() {
        rotate = new RotateTransition(Duration.seconds(2), buttonConvertion);
        rotate.setByAngle(180);
        rotate.play();
    }

    public void conveurousd(double nombre) {
        label_Init.setText("Euro");
        label_Final.setText("USD");
        String nombreSortie = df.format(nombre * 1.179);
        textField_Final.setText(nombreSortie);
    }

    public void convusdeuro(double nombre) {
        label_Init.setText("USD");
        label_Final.setText("Euro");
        String nombreSortie = df.format(nombre / 1.179);
        textField_Final.setText(nombreSortie);
    }

    public void conveuroyen(double nombre) {
        label_Init.setText("Euro");
        label_Final.setText("Yen");
        String nombreSortie = df.format(nombre * 184.87);
        textField_Final.setText(nombreSortie);
    }

    public void convyeneuro(double nombre) {
        label_Init.setText("Yen");
        label_Final.setText("Euro");
        String nombreSortie = df.format(nombre / 184.87);
        textField_Final.setText(nombreSortie);
    }

    public void conveurolivre(double nombre) {
        label_Init.setText("Euro");
        label_Final.setText("Livre Sterling");
        String nombreSortie = df.format(nombre * 0.86);
        textField_Final.setText(nombreSortie);
    }

    public void convlivreeuro(double nombre) {
        label_Init.setText("Livre Sterling");
        label_Final.setText("Euro");
        String nombreSortie = df.format(nombre / 0.86);
        textField_Final.setText(nombreSortie);
    }

    public void comboSelection() {
        ArrayList lista = new ArrayList();
        lista.add("Euro -> USD");
        lista.add("USD -> Euro");
        lista.add("Euro -> Yen");
        lista.add("Yen -> Euro");
        lista.add("Euro -> Livre Sterling");
        lista.add("Livre Sterling -> Euro");
        lista.forEach(event -> {
            comboSelection.getItems().add(event);
        });
    }

    public void initConvertion(ConversionDevise cd) {

    }

    private void convertion() {

    }

    private void comboSelection(Event event) {

    }

    private void fabriqueDonnees() {
        conversionDevise = new ArrayList();
        conversionDevise.add(new ConversionDevise("Euro -> USD", "Euro", "USD", 1.179));
        conversionDevise.add(new ConversionDevise("USD -> Euro", "USD", "Euro", 1.179));
        conversionDevise.add(new ConversionDevise("Euro -> Yen", "Euro", "Yen", 184.87));
        conversionDevise.add(new ConversionDevise("Yen -> Euro", "Yen", "Euro", 184.87));
        conversionDevise.add(new ConversionDevise("Euro -> Livre Sterling", "Euro", "Livre Sterling", 0.86));
        conversionDevise.add(new ConversionDevise("Livre Sterling -> Euro", "Livre Sterling", "Euro", 0.86));
        conversionDevise.forEach(conv -> {
            comboSelection.getItems().add(conv.getPrompt());
        });

    }

}