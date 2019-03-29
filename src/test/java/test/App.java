package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import airport.dao.*;
import airport.entity.*;

public class App {

	public static void main(String[] args) {

//DAO
		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();
		DaoVol daoVol = DaoVolFactory.getInstance();
		DaoVille daoVille = DaoVilleFactory.getInstance();
		DaoCompagnieAerienne daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
		DaoEscale daoEscale = DaoEscaleFactory.getInstance();
		DaoReservation daoReservation = DaoReservationFactory.getInstance();
		DaoConnecter daoConnecter = DaoConnecterFactory.getInstance();
		DaoPassager daoPassager = DaoPassagerFactory.getInstance();
		DaoCompagnieAerienneVol daoCompagnieAerienneVol = DaoCompagnieAerienneVolFactory.getInstance();
		DaoClient daoClient = DaoClientFactory.getInstance();
		DaoLogin daoLogin = DaoLoginFactory.getInstance();
		
//VILLES
		Ville vil1 = new Ville("Paris");
		Ville vil2 = new Ville("Santiago de Chile");
		Ville vil3 = new Ville("Madrid");
		Ville vil4 = new Ville("New York");
		Ville vil5 = new Ville("Aubervilliers");
//AEROPORTS		
		Aeroport aer1 = new Aeroport("Roissy Charles de Gaulle");
		Aeroport aer2 = new Aeroport("Arturo Benitez");
		Aeroport aer3 = new Aeroport("Alfonso Suarez");
		Aeroport aer4 = new Aeroport("John Fitzegrald Kennedy");
		Aeroport aer5 = new Aeroport("Orly");
//CONNECTER
		Connecter con1 = new Connecter (new ConnecterPk(vil1,aer1));
		Connecter con2 = new Connecter (new ConnecterPk(vil1,aer5));
		Connecter con3 = new Connecter (new ConnecterPk(vil4,aer4));
		Connecter con4 = new Connecter (new ConnecterPk(vil5,aer1));
//DATES	DE VOLS
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = null; Date date2 = null; Date date3 = null; Date date4 = null;
		try {
		date1 = dateformat.parse("01/05/2019");
		date2 = dateformat.parse("02/05/2019");
		date3 = dateformat.parse("03/05/2019");
		date4 = dateformat.parse("04/05/2019");
		}catch(Exception e) {System.out.println("probleme de dates");e.printStackTrace();}
//HEURES DE VOLS
		SimpleDateFormat heureformat = new SimpleDateFormat("HH:mm:ss");
		Date heure1 = null; Date heure2  = null; Date heure3  = null; Date heure4 = null;
		try {
			heure1 = heureformat.parse("08:00:00");
			heure2 = heureformat.parse("12:30:00");
			heure3 = heureformat.parse("16:30:00");
			heure4 = heureformat.parse("23:30:00");
		}catch(Exception e) {System.out.println("probleme d'heures");e.printStackTrace();}
//VOLS
		Vol vol1 = new Vol(aer1, aer3, date1, heure1, date1, heure2);
		Vol vol2 = new Vol(aer1, aer2, date2, heure1, date2, heure4);
		Vol vol3 = new Vol(aer1, aer4, date3, heure1, date3, heure3);
		Vol vol4 = new Vol(aer3, aer1, date4, heure2, date4, heure3);
		//Vol vol5 = new Vol(aer5, aer4, date1, heure1, date1, heure4);
//COMPAGNIES
		CompagnieAerienne comp1 = new CompagnieAerienne("Air France");
		CompagnieAerienne comp2 = new CompagnieAerienne("Iberia");	
//COMPAGNIE-VOL
		CompagnieAerienneVol compvol1 = new CompagnieAerienneVol(new CompagnieAerienneVolPk(vol1,comp1),"AF123");
		CompagnieAerienneVol compvol2 = new CompagnieAerienneVol(new CompagnieAerienneVolPk(vol2,comp2),"IB789");
//ADRESSES
		Adresse adr1 = new Adresse("1265 rue du fief","62840","Sailly sur la Lys","France");
		Adresse adr2 = new Adresse("6 rue Rougemont","75009","Paris","France");
//PASSAGERS
		Passager p1 = new Passager("Pierre","Boucher",adr1);
		Passager p2 = new Passager("Charles","DeSteMarie",adr2);
		Passager p3 = new Passager("Guillaume","Victor",adr2);
//LOGINS
		Login log1 = new Login("oliviergoz","admin");
		Login log2 = new Login("ajc","ingenierie");
//CLIENTs
		Client cli1 = new ClientPhysique(TitrePhysique.M,"Olivier","Gozlan",log1 ,0102030405,"olivier.gozlan@ajc.fr", adr2);
		Client cli2 = new ClientMoral(TitreMoral.PR,"41424820300021","AJC Ingenierie",log2 ,1111111111,"contact@ajc.fr", adr2);
//RESERVATIONS
		Date daterez = null;
		try {daterez = dateformat.parse("12/01/2019");} catch (ParseException e) {e.printStackTrace();}
		Reservation res1 = new Reservation(daterez,1);
		res1.setVol(vol1); res1.setPassager(p1); res1.setClient(cli2);
		Reservation res2 = new Reservation(daterez,1);
		res2.setVol(vol1); res2.setPassager(p2); res1.setClient(cli2);
		Reservation res3 = new Reservation(daterez,1);
		res3.setVol(vol1); res3.setPassager(p3); res1.setClient(cli2);
// ESCALES
		Date h1=null; Date h2=null;
		try {h1 = heureformat.parse("10:00:00"); h2 = heureformat.parse("11:00:00");} 
		catch (ParseException e) {e.printStackTrace();}
		Escale esc1 = new Escale(new EscalePk(vol2,aer3),h1,h2);
		
// INSERTION BASE
		daoVille.insert(vil1); daoVille.insert(vil2); daoVille.insert(vil3); daoVille.insert(vil4); daoVille.insert(vil5);
		daoPassager.insert(p1); daoPassager.insert(p2); daoPassager.insert(p3);
		daoLogin.insert(log1);daoLogin.insert(log2);
		daoClient.insert(cli1);daoClient.insert(cli2);
		daoAeroport.insert(aer1); daoAeroport.insert(aer2); daoAeroport.insert(aer3); daoAeroport.insert(aer4); daoAeroport.insert(aer5);
		daoConnecter.insert(con1); daoConnecter.insert(con2); daoConnecter.insert(con3); daoConnecter.insert(con4);
		daoCompagnieAerienne.insert(comp1); daoCompagnieAerienne.insert(comp2);
		daoVol.insert(vol1); daoVol.insert(vol2); daoVol.insert(vol3); daoVol.insert(vol4);
		daoCompagnieAerienneVol.insert(compvol1);daoCompagnieAerienneVol.insert(compvol2);
		daoEscale.insert(esc1);
		daoReservation.insert(res1);daoReservation.insert(res2);daoReservation.insert(res3);
		
// REQUETES	
		System.out.println("------------------------------------");
		System.out.println("Vols possibles depuis Aubervilliers:");
		List<Vol> volsDepuisAubervilliers = daoVol.findAllFrom(vil5);
		for (Vol v : volsDepuisAubervilliers) {
			System.out.println(v.getId() + " : " + v.getDepart().getNom() + " --> " + v.getArrivee().getNom() ); 
		}
		System.out.println("------------------------------------");
		System.out.println("Vols possibles depuis Aubervilliers le 1er mai:");
		List<Vol> volsDepuisAubervilliersLe1erMai = daoVol.findAllFrom(vil5,date1);
		for (Vol v : volsDepuisAubervilliersLe1erMai) {
			System.out.println(v.getId() + " : " + v.getDepart().getNom() + " --> " + v.getArrivee().getNom() ); 
		}
		System.out.println("------------------------------------");
		System.out.println("Vols possibles depuis Paris jusque New York:");
		List<Vol> volsfromParisToNewYork = daoVol.findAllFromTo(vil1,vil4);
		for (Vol v : volsfromParisToNewYork) {
			System.out.println(v.getId() + " : " + v.getDateDepart() + " : " + v.getDepart().getNom() + " --> " + v.getArrivee().getNom() ); 
		}
		System.out.println("------------------------------------");
		System.out.println("Clients qui habitent Paris:");
		List<Client> a= daoClient.findByVille("Paris");
        for (Client client : a) {
            System.out.println(client.getNom());
        }
//********        
        System.out.println("----------------FINDALL CLASSIQUE--------------------");
        List<Reservation> rWithout = daoReservation.findAll();
        for (Reservation r : rWithout) {
            System.out.println(r.getPassager().getNom());
        }
        System.out.println("-----------------FINDALL WITH PASSAGER ET VOLS -------------------");
        System.out.println("Remonter toutes les réservations avec les Passagers et les Vols");
        List<Reservation> rWith = daoReservation.findAllWithPassagerAndVol();
        for (Reservation r : rWith) {
            System.out.println(r.getPassager().getNom());
        }
//********  
		System.out.println("------------------------------------");
		System.out.println("Passagers du vol (vol1) Paris Madrid : ");
		List<Passager> passagersDuVol1 = daoPassager.findAllInFlight(vol1);
		for (Passager p : passagersDuVol1) {
			System.out.println(p.getPrenom() + " " +p.getNom() ); 
		}
        
        
	}

}
