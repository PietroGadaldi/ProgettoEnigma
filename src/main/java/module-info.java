module com.gadaldipietro.progettoenigma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.gadaldipietro.progettoenigma to javafx.fxml;
    exports com.gadaldipietro.progettoenigma;
}