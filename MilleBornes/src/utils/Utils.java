package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {
	private static Random rnd = new Random();
	
	public static <T> T extraire (List <T> liste) {
		int rndIndex = rnd.nextInt(liste.size());
		return liste.remove(rndIndex);
	}
	
	public static <T> T extraireIterateur (List <T> liste) {
		int rndIndex = rnd.nextInt(liste.size());
		ListIterator <T> it = liste.listIterator(rndIndex);
		T elem = it.next();
		it.remove();
		return elem;
	}
	
	public static <T> List <T> melanger (List <T> liste) {
		List <T> listeMelange = new LinkedList<>();
		while (!liste.isEmpty()) {
			T elem = extraire(liste);
			listeMelange.add(elem);
		}
		return listeMelange;
	}
	
	public static <T> boolean verifierMelange (List <T> liste1, List <T> liste2) {
		for (T elem: liste1) {
			if (Collections.frequency(liste1, elem) != Collections.frequency(liste2, elem)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List <T> rassembler (List <T> liste) {
		List <T> listeCons = new ArrayList<>();
		
		if (liste.isEmpty() || liste == null) {
			return listeCons;
		}
		
		for (T elem: liste) {
			if (!listeCons.contains(elem)) {
				for (int j = 0; j < Collections.frequency(liste, elem); j++) {
					listeCons.add(elem);
				}
			}
		}
		
		return listeCons;
	}
	
	public static <T> boolean verifierRassemblement (List <T> liste) {
		ListIterator <T> it1 = liste.listIterator();
		ListIterator <T> it2 = liste.listIterator();
		
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
}
