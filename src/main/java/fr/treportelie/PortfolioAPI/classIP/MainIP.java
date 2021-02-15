package fr.treportelie.PortfolioAPI.classIP;

import java.util.ArrayList;

public class MainIP extends IP {

	private int nbIP;

	public MainIP(String ip, String dateHeure, String page) {
		super(ip, dateHeure, page);
		this.nbIP = nbTotalIP++;
	}

	public String getIP() {
		return this.ip;
	}

	public String getDateHeure() {
		return this.dateHeure;
	}

	public String getPage() {
		return this.page;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Information sur l'adresse IP : \n");
		sb.append("IP :");
		sb.append(ip);
		sb.append("\nDate et heure de visite : ");
		sb.append(dateHeure);
		sb.append("\nPage visitée : ");
		sb.append(page);
		return sb.toString();
	}

}
