package formapplication;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class FXMLDatabaseBase extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Label idLabel;
    protected final Label firstNameLabel;
    protected final Label lastNameLabel;
    protected final Label emailLabel;
    protected final Label phoneLabel;
    protected final TextField idFeild;
    protected final TextField firstNameFeild;
    protected final TextField lastNameFeild;
    protected final TextField emailFeild;
    protected final TextField phoneFeild;
    protected final ButtonBar buttonBar;
    protected final Button newBtn;
    protected final Button updateBtn;
    protected final Button deleteBtn;
    protected final Button firstBtn;
    protected final Button pervBtn;
    protected final Button nextBtn;
    protected final Button lastBtn;

    public FXMLDatabaseBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        idLabel = new Label();
        firstNameLabel = new Label();
        lastNameLabel = new Label();
        emailLabel = new Label();
        phoneLabel = new Label();
        idFeild = new TextField();
        firstNameFeild = new TextField();
        lastNameFeild = new TextField();
        emailFeild = new TextField();
        phoneFeild = new TextField();
        buttonBar = new ButtonBar();
        newBtn = new Button();
        updateBtn = new Button();
        deleteBtn = new Button();
        firstBtn = new Button();
        pervBtn = new Button();
        nextBtn = new Button();
        lastBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        gridPane.setLayoutX(55.0);
        gridPane.setLayoutY(81.0);
        gridPane.setPrefHeight(179.0);
        gridPane.setPrefWidth(434.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(231.39996337890625);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(140.79996337890626);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(297.60004882812507);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(294.4000366210938);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        idLabel.setText("ID");

        GridPane.setRowIndex(firstNameLabel, 1);
        firstNameLabel.setText("First Name");

        GridPane.setRowIndex(lastNameLabel, 2);
        lastNameLabel.setText("Last Name");

        GridPane.setRowIndex(emailLabel, 3);
        emailLabel.setText("Email");

        GridPane.setRowIndex(phoneLabel, 4);
        phoneLabel.setText("Phone");

        GridPane.setColumnIndex(idFeild, 1);

        GridPane.setColumnIndex(firstNameFeild, 1);
        GridPane.setRowIndex(firstNameFeild, 1);

        GridPane.setColumnIndex(lastNameFeild, 1);
        GridPane.setRowIndex(lastNameFeild, 2);

        GridPane.setColumnIndex(emailFeild, 1);
        GridPane.setRowIndex(emailFeild, 3);

        GridPane.setColumnIndex(phoneFeild, 1);
        GridPane.setRowIndex(phoneFeild, 4);

        buttonBar.setLayoutX(-24.0);
        buttonBar.setLayoutY(293.0);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(627.0);

        newBtn.setMinWidth(24.0);
        newBtn.setMnemonicParsing(false);
        newBtn.setPrefHeight(26.0);
        newBtn.setText("New..");
        
        updateBtn.setMinWidth(50.0);
        updateBtn.setMnemonicParsing(false);
        updateBtn.setPrefHeight(26.0);
        updateBtn.setText("Update");

        deleteBtn.setMinWidth(56.0);
        deleteBtn.setMnemonicParsing(false);
        deleteBtn.setPrefHeight(26.0);
        deleteBtn.setText("Delete");

        firstBtn.setMinWidth(58.0);
        firstBtn.setMnemonicParsing(false);
        firstBtn.setPrefHeight(26.0);
        firstBtn.setText("First");

        pervBtn.setMinWidth(61.0);
        pervBtn.setMnemonicParsing(false);
        pervBtn.setPrefHeight(26.0);
        pervBtn.setText("Pervious");

        nextBtn.setMinWidth(66.0);
        nextBtn.setMnemonicParsing(false);
        nextBtn.setPrefHeight(26.0);
        nextBtn.setText("Next");
        
        lastBtn.setMnemonicParsing(false);
        lastBtn.setText("Last");

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getChildren().add(idLabel);
        gridPane.getChildren().add(firstNameLabel);
        gridPane.getChildren().add(lastNameLabel);
        gridPane.getChildren().add(emailLabel);
        gridPane.getChildren().add(phoneLabel);
        gridPane.getChildren().add(idFeild);
        gridPane.getChildren().add(firstNameFeild);
        gridPane.getChildren().add(lastNameFeild);
        gridPane.getChildren().add(emailFeild);
        gridPane.getChildren().add(phoneFeild);
        getChildren().add(gridPane);
        buttonBar.getButtons().add(newBtn);
        buttonBar.getButtons().add(updateBtn);
        buttonBar.getButtons().add(deleteBtn);
        buttonBar.getButtons().add(firstBtn);
        buttonBar.getButtons().add(pervBtn);
        buttonBar.getButtons().add(nextBtn);
        buttonBar.getButtons().add(lastBtn);
        getChildren().add(buttonBar);

    }
}
