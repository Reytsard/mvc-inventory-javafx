module com.cp3.inman.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.cp3.inman.client.view to javafx.fxml;
    opens com.cp3.inman.client.model to javafx.fxml;
    opens com.cp3.inman.client.controller to javafx.fxml;
    exports com.cp3.inman.client;
}