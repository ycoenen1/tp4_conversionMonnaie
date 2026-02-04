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
    private final ArrayList<ConversionDevise> conversionDevise = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("0.0000");
    public RotateTransition rotate;
    private double valeur_Final;
    private double valeur_Conversion;
    private double valeur_Init;

    public HelloController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fabriqueDonnees();
        comboSelection.setOnAction(event -> comboSelection(event));

        /*
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
        });*/

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

    public void initConvertion(ConversionDevise cd) {
        label_Init.setText(cd.getSource());
        label_Final.setText(cd.getCible());
        valeur_Conversion = cd.getTaux();

    }

    private void convertion() {
        try {
            valeur_Init = Double.parseDouble(textField_Init.getText().replace(",", "."));
            if (label_Init.getText().equals("Euro")){
                valeur_Final = valeur_Init * valeur_Conversion;
                textField_Final.setText(df.format(valeur_Final));
            } else {
                valeur_Final = valeur_Init / valeur_Conversion;
                textField_Final.setText(df.format(valeur_Final));
            }

        } catch (NumberFormatException ex) {
            alerteFormat(ex.getMessage());
        }

    }

    private void comboSelection(Event event) {

        for (ConversionDevise cd : conversionDevise) {
            if (cd.getPrompt().equals(comboSelection.getValue().toString())) {
                initConvertion(cd);
            }
        }

        buttonConvertion.setOnAction(e -> convertion());

    }

    private void fabriqueDonnees() {
        conversionDevise.add(new ConversionDevise("Euro -> USD", "Euro", "USD", taux_Euro_Dollar));
        conversionDevise.add(new ConversionDevise("USD -> Euro", "USD", "Euro", taux_Euro_Dollar));
        conversionDevise.add(new ConversionDevise("Euro -> Yen", "Euro", "Yen", taux_Euro_Yen));
        conversionDevise.add(new ConversionDevise("Yen -> Euro", "Yen", "Euro", taux_Euro_Yen));
        conversionDevise.add(new ConversionDevise("Euro -> Livre Sterling", "Euro", "Livre Sterling", taux_Euro_Livre));
        conversionDevise.add(new ConversionDevise("Livre Sterling -> Euro", "Livre Sterling", "Euro", taux_Euro_Livre));
        conversionDevise.forEach( conv-> {
            comboSelection.getItems().add(conv.getPrompt());
        });

    }

}