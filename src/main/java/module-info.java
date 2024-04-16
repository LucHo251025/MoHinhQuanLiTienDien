module com.example.mohinhquanlitiendien {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.mohinhquanlitiendien.Model;
    opens com.example.mohinhquanlitiendien to javafx.fxml;
    exports com.example.mohinhquanlitiendien;
    exports com.example.mohinhquanlitiendien.Controller;
    opens com.example.mohinhquanlitiendien.Controller to javafx.fxml;
}