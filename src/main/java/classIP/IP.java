package classIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class IP {

	private String ip;
	private String dateHeure;
	private String page;

	/**
	 * Constructeur de la classe IP permettant d'instancier une ligne en référence à
	 * notre IP de visite
	 * 
	 * @param ip
	 * @param dateHeure
	 * @param page
	 */
	public IP(String ip, String dateHeure, String page) {
		this.ip = ip;
		this.dateHeure = dateHeure;
		this.page = page;
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

	/**
	 * Méthode qui prend en paramètre un String, et le découpe selon le format
	 * utilisé sur la page treportelie.fr/historic.txt, génére par ailleurs une
	 * exception si la ligne ne comporte aucun lien avec ce format
	 * 
	 * @param a
	 * @return
	 * @throws ExceptionPersonnalise
	 */
	public static IP decoupeChaine(String a) throws ExceptionPersonnalise {
		IP returnIP = null;
		if (a.contains(";")) {
			String ip = a.substring(0, a.indexOf(" ", 0));
			String dateHeure = a.substring(a.indexOf(" ", 0), a.lastIndexOf(" "));
			String page = a.substring(a.lastIndexOf("/"), a.length() - 1);
			returnIP = new IP(ip, dateHeure, page);
		} else {
			throw new ExceptionPersonnalise("Erreur de découpage de la ligne suivante : \n " + a);
		}
		return returnIP;
	}

	/**
	 * Méthode static qui permet de retourner une collection des IP ayant visité le
	 * site treportelie.fr
	 * 
	 * @return
	 */
	public static ArrayList<IP> returnCollectionIP() {
		ArrayList<IP> collection = new ArrayList<IP>();
		String host = "http://treportelie.fr/historic.txt";
		URL aURL = null;
		String codeHTML = "";
		try {
			aURL = new URL(host);
			URLConnection con = aURL.openConnection();
			con.setConnectTimeout(60000); // temps maximun alloué pour se connecter
			con.setReadTimeout(60000); // temps maximun alloué pour lire
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputline;

			// On commence à lire les lignes pour récupérer nos informations
			while ((inputline = in.readLine()) != null) {
				try {
					collection.add(IP.decoupeChaine(inputline));
				} catch (ExceptionPersonnalise e) {
					e.getMessage();
				}
			}
			in.close(); // Fermeture du flux
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// System.out.println(codeHTML);
		return collection;
	}
}
