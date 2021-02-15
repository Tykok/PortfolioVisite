package fr.treportelie.PortfolioAPI.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fr.treportelie.PortfolioAPI.classIP.IP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AcceuilController implements Initializable {

	@FXML
	private TableView<IP> tableView_IP;
	@FXML
	private TableColumn<IP, String> column_adresseIP;
	@FXML
	private TableColumn<IP, String> column_date;
	@FXML
	private TableColumn<IP, String> column_page;

	private ObservableList<IP> listeIP = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		column_adresseIP.setCellValueFactory(new PropertyValueFactory<>("ip"));
		column_date.setCellValueFactory(new PropertyValueFactory<>("dateHeure"));
		column_page.setCellValueFactory(new PropertyValueFactory<>("page"));
		for (IP i : IP.returnCollectionIP()) {
			listeIP.add(i);
		}
		tableView_IP.setItems(listeIP);

	}

}
