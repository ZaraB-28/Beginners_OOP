package com.example.dataentry;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataEntryForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        VBox box = new VBox();
        List<UserInfo> userInfo = new ArrayList<>();

        Image image = new Image(getClass().getResource("/banner.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        box.getChildren().add(imageView);

        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(50);
        gridPane.setVgap(10);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(Font.font("Times New Roman",18));
        nameLabel.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.add(nameLabel,0,1);
        GridPane.setMargin(nameLabel, new Insets(0, 0, 0, 50));

        TextField name = new TextField();
        name.setFont(Font.font("Times New Roman",16));
        gridPane.add(name,1,1);

        Label fatherNameLabel = new Label("Father's Name");
        fatherNameLabel.setFont(Font.font("Times New Roman", 18));
        fatherNameLabel.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.add(fatherNameLabel,0,2);

        TextField fatherName = new TextField();
        fatherName.setFont(Font.font("Times New Roman",16));
        gridPane.add(fatherName,1,2);
        GridPane.setMargin(fatherNameLabel,new Insets(0,0,0,50));

        Label cityLabel = new Label("City");
        cityLabel.setFont(Font.font("Times New Roman", 18));
        cityLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(cityLabel,new Insets(0,0,0,50));
        gridPane.add(cityLabel,0,3);

        ComboBox<String> city = new ComboBox<>();
        city.getItems().addAll("New York","Florida", "Washington", "Miami");
        city.setValue("Select a City");
        gridPane.add(city,1,3);

        Label addressLabel = new Label("Address");
        addressLabel.setFont(Font.font("Times New Roman", 18));
        addressLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(addressLabel,new Insets(0,0,0,50));
        gridPane.add(addressLabel,0,4);

        TextField address = new TextField();
        address.setFont(Font.font("Times New Roman",16));
        gridPane.add(address,1,4);
        GridPane.setMargin(fatherNameLabel,new Insets(0,0,0,50));

        Label emailLabel = new Label("Email");
        emailLabel.setFont(Font.font("Times New Roman", 18));
        emailLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(emailLabel,new Insets(0,0,0,50));
        gridPane.add(emailLabel,0,5);

        TextField email = new TextField();
        email.setFont(Font.font("Times New Roman",16));
        gridPane.add(email,1,5);
        GridPane.setMargin(fatherNameLabel,new Insets(0,0,0,50));

        Label genderLabel = new Label("Gender");
        genderLabel.setFont(Font.font("Times New Roman", 18));
        genderLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setMargin(genderLabel,new Insets(20,0,0,50));
        gridPane.add(genderLabel,0,6);

        RadioButton radioButton = new RadioButton("Male");
        RadioButton radioButton1 = new RadioButton("Female");
        radioButton.setFont(Font.font("Times New Roman", 14));
        radioButton1.setFont(Font.font("Times New Roman", 14));

        VBox genderBox = new VBox();

        ToggleGroup genderToggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(genderToggleGroup);
        radioButton.setToggleGroup(genderToggleGroup);
        genderBox.getChildren().addAll(radioButton, radioButton1);
        genderBox.setSpacing(5);
        GridPane.setMargin(genderBox,new Insets(0,0,0,50));
        gridPane.add(genderBox,0,7);

        VBox imageContainer = new VBox();

        Label imageSelect = new Label("Select an image");
        imageSelect.setFont(Font.font("Times New Roman", 16));
        imageSelect.setAlignment(Pos.BOTTOM_LEFT);
        imageSelect.setPadding(new Insets(0,0,10,0));

        Button imageButton = new Button("Choose Image");
        imageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                Image selectedImage = new Image(selectedFile.toURI().toString());
                ImageView imageView1 = new ImageView(selectedImage);
                imageView1.setFitWidth(100);
                imageView1.setFitHeight(100);

                HBox imageBox = new HBox(imageView1);
                imageBox.setAlignment(Pos.TOP_CENTER);
                imageBox.setPadding(new Insets(0,0,10,0));
                imageContainer.getChildren().add(imageBox);
            }
        });

        imageContainer.getChildren().addAll(imageSelect, imageButton);
        imageContainer.setPrefSize(200, 200);
        imageContainer.setAlignment(Pos.CENTER);
        imageContainer.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                new CornerRadii(20),
                BorderStroke.DEFAULT_WIDTHS
        )));

        GridPane.setMargin(imageContainer, new Insets(10, 0, 0, 50));
        gridPane.add(imageContainer, 1, 7);


        Button submit = new Button("SUBMIT");
        submit.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(10), Insets.EMPTY)));
        submit.setFont(Font.font(16));
        submit.setTextFill(Color.WHITE);
        submit.setPadding(new Insets(5));
        submit.setPrefWidth(120);
        submit.setPrefHeight(8);
        submit.setCursor(Cursor.HAND);
        gridPane.add(submit,0,7);
        GridPane.setMargin(submit,new Insets(0,0,10,50));

        submit.setOnAction(e -> {
            String userName = name.getText().trim();
            String userFatherName = fatherName.getText().trim();
            String userCity = city.getValue();
            String userAddress = address.getText().trim();
            String userEmail = email.getText().trim();
            RadioButton selectedGender = (RadioButton) genderToggleGroup.getSelectedToggle();
            String userGender = selectedGender.getText();

            UserInfo newUser = new UserInfo(userName, userFatherName, userCity, userAddress, userEmail, userGender);
            userInfo.add(newUser);
            System.out.println(newUser);

            openNewScene(stage, newUser);
        });




        Scene scene = new Scene(box, 500, 650);
        box.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        box.getChildren().add(gridPane);
        stage.setTitle("Data Entry Form");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    private void openNewScene(Stage stage, UserInfo user) {
        VBox v = new VBox(10);
        v.setPadding(new Insets(20));
        v.setAlignment(Pos.TOP_CENTER);

        Label welcomeLabel = new Label("WELCOME!");
        Label loginLabel = new Label("Login Info");
        Label nameLabel = new Label("Name: " + user.getName());
        Label fatherNameLabel = new Label("Father's Name: " + user.getFatherName());
        Label cityLabel = new Label("City: " + user.getCity());
        Label addressLabel = new Label("Address: " + user.getAddress());
        Label emailLabel = new Label("Email: " + user.getEmail());
        Label genderLabel = new Label("Gender: " + user.getGender());

        welcomeLabel.setPadding(new Insets(50,0,0,0));

        welcomeLabel.setFont(Font.font("Times New Roman",20));
        loginLabel.setFont(Font.font("Times New Roman",20));
        nameLabel.setFont(Font.font("Times New Roman",18));
        fatherNameLabel.setFont(Font.font("Times New Roman",18));
        cityLabel.setFont(Font.font("Times New Roman",18));
        addressLabel.setFont(Font.font("Times New Roman",18));
        emailLabel.setFont(Font.font("Times New Roman",18));
        genderLabel.setFont(Font.font("Times New Roman",18));

        v.getChildren().addAll(welcomeLabel,loginLabel,nameLabel, fatherNameLabel, cityLabel, addressLabel, emailLabel, genderLabel);
        v.setSpacing(10);
        Scene newScene = new Scene(v, 500, 650);
        v.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));


        stage.setScene(newScene);
    }



    public static void main(String[] args) {
        launch();
    }
}
