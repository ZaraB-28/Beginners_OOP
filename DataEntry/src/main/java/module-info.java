module com.example.dataentry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.dataentry to javafx.fxml;
    exports com.example.dataentry;
}