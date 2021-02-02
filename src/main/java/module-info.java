module fr.treportelie.PortfolioAPI {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires commons.io;
	requires java.base;

    opens fr.treportelie.PortfolioAPI to javafx.fxml;
    exports fr.treportelie.PortfolioAPI;
}