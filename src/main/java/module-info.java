module com.slinger.greenfieldworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.slinger.greenfieldworld to javafx.fxml;
    exports com.slinger.greenfieldworld;
}