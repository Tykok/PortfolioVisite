module fr.treportelie.PortfolioAPI {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.base;
	requires jdk.compiler;
	requires jdk.javadoc;

    opens fr.treportelie.PortfolioAPI to javafx.fxml;
    exports fr.treportelie.PortfolioAPI;
    opens fr.treportelie.PortfolioAPI.classIP to javafx.fxml;
    exports fr.treportelie.PortfolioAPI.classIP;
    opens fr.treportelie.PortfolioAPI.controller to javafx.fxml;
    exports fr.treportelie.PortfolioAPI.controller;
}