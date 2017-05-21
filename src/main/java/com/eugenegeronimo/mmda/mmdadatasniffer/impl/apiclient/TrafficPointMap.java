package com.eugenegeronimo.mmda.mmdadatasniffer.impl.apiclient;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapping traffic point numbers to its actual location name
 */
@Component
public class TrafficPointMap {

    private static final Map<String, String> trafficPointMap = new HashMap<>();

    static {
        // Traffic point names per ID
        // EDSA
        trafficPointMap.put("11", "Balintawak");
        trafficPointMap.put("12", "Kaingin Road");
        trafficPointMap.put("13", "Munoz");
        trafficPointMap.put("14", "Bansalangin");
        trafficPointMap.put("15", "North Ave.");
        trafficPointMap.put("16", "Trinoma");
        trafficPointMap.put("17", "Quezon Ave.");
        trafficPointMap.put("18", "NIA");
        trafficPointMap.put("19", "Timog");
        trafficPointMap.put("110", "Kamuning");
        trafficPointMap.put("111", "New York - Nepa-Q Mart");
        trafficPointMap.put("112", "Monte de Piedad");
        trafficPointMap.put("113", "Aurora");
        trafficPointMap.put("114", "Mc Arthur - Farmers");
        trafficPointMap.put("115", "P. Tuazon");
        trafficPointMap.put("116", "Main Ave.");
        trafficPointMap.put("117", "Santolan");
        trafficPointMap.put("118", "White Plains - Connecticut");
        trafficPointMap.put("119", "Ortigas");
        trafficPointMap.put("120", "SM Megamall");
        trafficPointMap.put("121", "Shaw Blvd.");
        trafficPointMap.put("122", "Reliance");
        trafficPointMap.put("123", "Pioneer - Boni");
        trafficPointMap.put("124", "Guadalupe");
        trafficPointMap.put("125", "Orense");
        trafficPointMap.put("126", "Kalayaan - Estrella");
        trafficPointMap.put("127", "Buendia");
        trafficPointMap.put("128", "Ayala Ave.");
        trafficPointMap.put("129", "Arnaiz - Pasay Road");
        trafficPointMap.put("130", "Magallanes");
        trafficPointMap.put("131", "Malibay");
        trafficPointMap.put("132", "Tramo");
        trafficPointMap.put("133", "Taft Ave.");
        trafficPointMap.put("134", "F.B. Harrison");
        trafficPointMap.put("135", "Roxas Boulevard");
        trafficPointMap.put("136", "Macapagal Ave.");
        trafficPointMap.put("137", "Mall of Asia");
        // Commonwealth
        trafficPointMap.put("798", "Batasan");
        trafficPointMap.put("799", "St. Peter's Church");
        trafficPointMap.put("7100", "Ever Gotesco");
        trafficPointMap.put("7101", "Diliman Preparatory School");
        trafficPointMap.put("7102", "Zuzuarregi");
        trafficPointMap.put("7103", "General Malvar Hospital");
        trafficPointMap.put("7104", "Tandang Sora Eastside");
        trafficPointMap.put("7105", "Tandang Sora Westside");
        trafficPointMap.put("7106", "Central Ave");
        trafficPointMap.put("7107", "Magsaysay Ave");
        trafficPointMap.put("7108", "University Ave");
        trafficPointMap.put("738", "Philcoa");
        // Quezon Ave.
        trafficPointMap.put("239", "Elliptical Road");
        trafficPointMap.put("240", "Agham Road");
        trafficPointMap.put("241", "Bantayog Road");
        trafficPointMap.put("242", "EDSA");
        trafficPointMap.put("243", "SGT. Esguerra");
        trafficPointMap.put("244", "Scout Albano");
        trafficPointMap.put("245", "Scout Borromeo");
        trafficPointMap.put("246", "Scout Santiago");
        trafficPointMap.put("247", "Timog");
        trafficPointMap.put("248", "Scout Reyes");
        trafficPointMap.put("249", "Scout Magbanua");
        trafficPointMap.put("250", "Roces Avenue");
        trafficPointMap.put("251", "Roosevelt Avenue");
        trafficPointMap.put("252", "Dr. Garcia Sr.");
        trafficPointMap.put("253", "Scout Chuatoco");
        trafficPointMap.put("254", "G. Araneta Avenue");
        trafficPointMap.put("255", "Sto. Domingo");
        trafficPointMap.put("256", "Biak na Bato");
        trafficPointMap.put("257", "Banaue");
        trafficPointMap.put("258", "Cordillera");
        trafficPointMap.put("259", "D. Tuazon");
        trafficPointMap.put("260", "Speaker Perez");
        trafficPointMap.put("261", "Apo Avenue");
        trafficPointMap.put("262", "Kanlaon");
        trafficPointMap.put("263", "Mayon");
        // Espana
        trafficPointMap.put("371", "Welcome Rotunda");
        trafficPointMap.put("370", "Bluementritt");
        trafficPointMap.put("369", "A. Maceda");
        trafficPointMap.put("368", "Antipolo");
        trafficPointMap.put("367", "Vicente Cruz");
        trafficPointMap.put("366", "G. Forbes - Lacson");
        trafficPointMap.put("365", "P. Naval");
        trafficPointMap.put("364", "Lerma");
        // C5
        trafficPointMap.put("4131", "Tandang Sora");
        trafficPointMap.put("4132", "Capitol Hills");
        trafficPointMap.put("4133", "Universty of the Philippines");
        trafficPointMap.put("4134", "C.P. Garcia");
        trafficPointMap.put("4135", "Miriam College");
        trafficPointMap.put("4136", "Ateneo De Manila University");
        trafficPointMap.put("4137", "Xavierville");
        trafficPointMap.put("4138", "Aurora Boulevard");
        trafficPointMap.put("4139", "P. Tuazon");
        trafficPointMap.put("4140", "Bonny Serrano");
        trafficPointMap.put("472", "Libis Flyover");
        trafficPointMap.put("473", "Eastwood");
        trafficPointMap.put("474", "Green Meadows");
        trafficPointMap.put("475", "Ortigas Avenue");
        trafficPointMap.put("476", "J. Vargas");
        trafficPointMap.put("477", "Lanuza");
        trafficPointMap.put("478", "Bagong Ilog");
        trafficPointMap.put("479", "Kalayaan");
        trafficPointMap.put("480", "Market! Market!");
        // Ortigas
        trafficPointMap.put("8116", "Santolan");
        trafficPointMap.put("8117", "Madison");
        trafficPointMap.put("8118", "Roosevelt");
        trafficPointMap.put("8119", "Club Filipino");
        trafficPointMap.put("8120", "Wilson");
        trafficPointMap.put("8121", "Connecticut");
        trafficPointMap.put("8122", "La Salle Greenhills");
        trafficPointMap.put("8123", "POEA");
        trafficPointMap.put("8124", "EDSA Shrine");
        trafficPointMap.put("8125", "San Miguel");
        trafficPointMap.put("8126", "Meralco Ave");
        trafficPointMap.put("8127", "Medical City");
        trafficPointMap.put("8128", "Lanuza Ave");
        trafficPointMap.put("8129", "Green Meadows Ave");
        trafficPointMap.put("8130", "C5 Flyover");
        // Marcos Highway
        trafficPointMap.put("9115", "SM City Marikina");
        trafficPointMap.put("9114", "LRT-2 Station");
        trafficPointMap.put("9113", "Dona Juana");
        trafficPointMap.put("9112", "Amang Rodriguez");
        trafficPointMap.put("9111", "F. Mariano Ave");
        trafficPointMap.put("9110", "Robinson's Metro East");
        trafficPointMap.put("9109", "San Benildo School");
        // Roxas Blvd
        trafficPointMap.put("591", "Anda Circle");
        trafficPointMap.put("590", "Finance Road");
        trafficPointMap.put("589", "U.N. Avenue");
        trafficPointMap.put("5142", "Pedro Gil");
        trafficPointMap.put("588", "Rajah Sulayman");
        trafficPointMap.put("587", "Quirino");
        trafficPointMap.put("586", "Pablo Ocampo");
        trafficPointMap.put("585", "Buendia");
        trafficPointMap.put("584", "EDSA Extension");
        trafficPointMap.put("583", "Baclaran");
        trafficPointMap.put("582", "Airport Road");
        trafficPointMap.put("581", "Coastal Road");
        // SLEX
        trafficPointMap.put("697", "Magallanes");
        trafficPointMap.put("696", "Nichols");
        trafficPointMap.put("6141", "C5 On-ramp");
        trafficPointMap.put("695", "Merville Exit");
        trafficPointMap.put("694", "Bicutan Exit");
        trafficPointMap.put("693", "Sucat Exit");
        trafficPointMap.put("692", "Alabang Exit");
        // NLEX
        trafficPointMap.put("10157", "Sta. Ines");
        trafficPointMap.put("10159", "Angeles");
        trafficPointMap.put("10160", "Mexico");
        trafficPointMap.put("10161", "San Fernando");
        trafficPointMap.put("10162", "San Simon");
        trafficPointMap.put("10163", "Pulilan");
        trafficPointMap.put("10164", "Sta. Rita");
        trafficPointMap.put("10165", "Balagtas");
        trafficPointMap.put("10166", "Tabang");
        trafficPointMap.put("10167", "Bocaue");
        trafficPointMap.put("10168", "Marilao");
        trafficPointMap.put("10169", "Meycauayan");
        trafficPointMap.put("10170", "Valenzuela");
        trafficPointMap.put("10172", "Mindanao Avenue");
        trafficPointMap.put("10171", "Balintawak");
    }


    public String getTrafficPointName(String lineId, String trafficPointId) {
        if (lineId == null || trafficPointId == null) {
            return null;
        }
        return trafficPointMap.get(lineId.concat(trafficPointId));
    }
}
