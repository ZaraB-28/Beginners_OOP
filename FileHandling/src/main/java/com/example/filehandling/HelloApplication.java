package com.example.filehandling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        VBox box = new VBox();
        File dataFile = new File("User.abc");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(50);
        gridPane.setVgap(10);

        Label nameLabel = new Label("FullName");
        nameLabel.setFont(Font.font(14));
        nameLabel.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.add(nameLabel,0,1);
        GridPane.setMargin(nameLabel, new Insets(0, 0, 0, 10));

        TextField name = new TextField();
        name.setFont(Font.font("Times New Roman",16));
        gridPane.add(name,1,1);

        Label IDLabel = new Label("ID");
        IDLabel.setFont(Font.font(14));
        IDLabel.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.add(IDLabel,0,2);
        GridPane.setMargin(IDLabel, new Insets(0, 0, 0, 10));

        TextField id = new TextField();
        id.setFont(Font.font("Times New Roman",16));
        gridPane.add(id,1,2);

        Label genderLabel = new Label("Gender");
        genderLabel.setFont(Font.font(14));
        genderLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(genderLabel,new Insets(0,0,0,10));
        gridPane.add(genderLabel,0,3);

        RadioButton radioButton = new RadioButton("Male");
        RadioButton radioButton1 = new RadioButton("Female");
        radioButton.setFont(Font.font("Times New Roman", 14));
        radioButton1.setFont(Font.font("Times New Roman", 14));

        HBox genderBox = new HBox();

        ToggleGroup genderToggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(genderToggleGroup);
        radioButton.setToggleGroup(genderToggleGroup);
        genderBox.getChildren().addAll(radioButton, radioButton1);
        genderBox.setSpacing(5);
        gridPane.add(genderBox,1,3);

        Label provinceLabel = new Label("HomeProvince");
        provinceLabel.setFont(Font.font(14));
        provinceLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(provinceLabel,new Insets(0,0,0,10));
        gridPane.add(provinceLabel,0,4);

        ComboBox<String> province = new ComboBox<>();
        province.getItems().addAll("Punjab","Sindh", "Balochistan", "KPK");
        province.setValue("Select a Province");
        gridPane.add(province,1,4);

        Label dobLabel = new Label("DOB");
        dobLabel.setFont(Font.font(14));
        dobLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(dobLabel,new Insets(0,0,0,10));
        gridPane.add(dobLabel,0,5);

        DatePicker dob = new DatePicker();
        dob.setPrefWidth(200);
        dob.setPrefHeight(30);
        gridPane.add(dob,1,5);


        Label recordLabel = new Label("New Record");
        recordLabel.setFont(Font.font(14));
        recordLabel.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.add(recordLabel,2,1);
        GridPane.setMargin(recordLabel,new Insets(0,0,0,20));


        Button New = new Button("New");
        New.setFont(Font.font(12));
        New.setPadding(new Insets(5));
        New.setPrefWidth(120);
        New.setPrefHeight(10);
        New.setCursor(Cursor.HAND);
        gridPane.add(New,2,2);

        New.setOnAction(e -> {
            String userName = name.getText();
            String userProvince= province.getValue();
            String userId = id.getText();
            RadioButton selectedGender = (RadioButton) genderToggleGroup.getSelectedToggle();
            String userGender = selectedGender.getText();


            try(BufferedWriter storeData = new BufferedWriter(new FileWriter(dataFile,true))){
                storeData.write(userName + " | ");
                storeData.write(userId + " | ");
                storeData.write(userGender+ " | ");
                storeData.write(userProvince);
                storeData.newLine();


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button Find = new Button("Find");
        Find.setFont(Font.font(12));
        Find.setPadding(new Insets(5));
        Find.setPrefWidth(120);
        Find.setPrefHeight(10);
        Find.setCursor(Cursor.HAND);
        gridPane.add(Find,2,3);

        Find.setOnAction(e -> {

            Label IDfind = new Label("Enter ID");
            gridPane.add(IDfind, 0, 8);
            GridPane.setMargin(IDfind, new Insets(0, 0, 0, 10));

            TextField findID = new TextField();
            findID.setFont(Font.font("Times New Roman", 16));
            gridPane.add(findID, 1, 8);

            findID.setOnAction(event -> {
                String idToFind = findID.getText().trim();

                try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                    String line;
                    boolean found = false;

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(" \\| ");
                        if (parts[1].equals(idToFind)) {
                            System.out.println("Found: " + line);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("ID not found.");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        });

        Button close = new Button("Close");
        close.setFont(Font.font(12));
        close.setPadding(new Insets(5));
        close.setPrefWidth(120);
        close.setPrefHeight(10);
        close.setCursor(Cursor.HAND);
        gridPane.add(close,2,4);

        close.setOnAction(e -> stage.close());

        Scene scene = new Scene(box, 600, 450);
        box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        box.getChildren().add(gridPane);
        stage.setTitle("Data Entry Form");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
