module com.stulsoft.graphics {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.stulsoft.graphics to javafx.fxml;
    exports com.stulsoft.graphics;
}