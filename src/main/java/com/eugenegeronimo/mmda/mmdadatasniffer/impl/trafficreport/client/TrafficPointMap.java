package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

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
        trafficPointMap.put("1_1", "Balintawak");
        trafficPointMap.put("1_2", "Kaingin Road");
        trafficPointMap.put("1_3", "Munoz");
        trafficPointMap.put("1_4", "Bansalangin");
        trafficPointMap.put("1_5", "North Ave.");
        trafficPointMap.put("1_6", "Trinoma");
        trafficPointMap.put("1_7", "Quezon Ave.");
        trafficPointMap.put("1_8", "NIA");
        trafficPointMap.put("1_9", "Timog");
        trafficPointMap.put("1_10", "Kamuning");
        trafficPointMap.put("1_11", "New York - Nepa-Q Mart");
        trafficPointMap.put("1_12", "Monte de Piedad");
        trafficPointMap.put("1_13", "Aurora");
        trafficPointMap.put("1_14", "Mc Arthur - Farmers");
        trafficPointMap.put("1_15", "P. Tuazon");
        trafficPointMap.put("1_16", "Main Ave.");
        trafficPointMap.put("1_17", "Santolan");
        trafficPointMap.put("1_18", "White Plains - Connecticut");
        trafficPointMap.put("1_19", "Ortigas");
        trafficPointMap.put("1_20", "SM Megamall");
        trafficPointMap.put("1_21", "Shaw Blvd.");
        trafficPointMap.put("1_22", "Reliance");
        trafficPointMap.put("1_23", "Pioneer - Boni");
        trafficPointMap.put("1_24", "Guadalupe");
        trafficPointMap.put("1_25", "Orense");
        trafficPointMap.put("1_26", "Kalayaan - Estrella");
        trafficPointMap.put("1_27", "Buendia");
        trafficPointMap.put("1_28", "Ayala Ave.");
        trafficPointMap.put("1_29", "Arnaiz - Pasay Road");
        trafficPointMap.put("1_30", "Magallanes");
        trafficPointMap.put("1_31", "Malibay");
        trafficPointMap.put("1_32", "Tramo");
        trafficPointMap.put("1_33", "Taft Ave.");
        trafficPointMap.put("1_34", "F.B. Harrison");
        trafficPointMap.put("1_35", "Roxas Boulevard");
        trafficPointMap.put("1_36", "Macapagal Ave.");
        trafficPointMap.put("1_37", "Mall of Asia");
        // Commonwealth
        trafficPointMap.put("7_98", "Batasan");
        trafficPointMap.put("7_99", "St. Peter's Church");
        trafficPointMap.put("7_100", "Ever Gotesco");
        trafficPointMap.put("7_101", "Diliman Preparatory School");
        trafficPointMap.put("7_102", "Zuzuarregi");
        trafficPointMap.put("7_103", "General Malvar Hospital");
        trafficPointMap.put("7_104", "Tandang Sora Eastside");
        trafficPointMap.put("7_105", "Tandang Sora Westside");
        trafficPointMap.put("7_106", "Central Ave");
        trafficPointMap.put("7_107", "Magsaysay Ave");
        trafficPointMap.put("7_108", "University Ave");
        trafficPointMap.put("7_38", "Philcoa");
        // Quezon Ave.
        trafficPointMap.put("2_39", "Elliptical Road");
        trafficPointMap.put("2_40", "Agham Road");
        trafficPointMap.put("2_41", "Bantayog Road");
        trafficPointMap.put("2_42", "EDSA");
        trafficPointMap.put("2_43", "SGT. Esguerra");
        trafficPointMap.put("2_44", "Scout Albano");
        trafficPointMap.put("2_45", "Scout Borromeo");
        trafficPointMap.put("2_46", "Scout Santiago");
        trafficPointMap.put("2_47", "Timog");
        trafficPointMap.put("2_48", "Scout Reyes");
        trafficPointMap.put("2_49", "Scout Magbanua");
        trafficPointMap.put("2_50", "Roces Avenue");
        trafficPointMap.put("2_51", "Roosevelt Avenue");
        trafficPointMap.put("2_52", "Dr. Garcia Sr.");
        trafficPointMap.put("2_53", "Scout Chuatoco");
        trafficPointMap.put("2_54", "G. Araneta Avenue");
        trafficPointMap.put("2_55", "Sto. Domingo");
        trafficPointMap.put("2_56", "Biak na Bato");
        trafficPointMap.put("2_57", "Banaue");
        trafficPointMap.put("2_58", "Cordillera");
        trafficPointMap.put("2_59", "D. Tuazon");
        trafficPointMap.put("2_60", "Speaker Perez");
        trafficPointMap.put("2_61", "Apo Avenue");
        trafficPointMap.put("2_62", "Kanlaon");
        trafficPointMap.put("2_63", "Mayon");
        // Espana
        trafficPointMap.put("3_71", "Welcome Rotunda");
        trafficPointMap.put("3_70", "Bluementritt");
        trafficPointMap.put("3_69", "A. Maceda");
        trafficPointMap.put("3_68", "Antipolo");
        trafficPointMap.put("3_67", "Vicente Cruz");
        trafficPointMap.put("3_66", "G. Forbes - Lacson");
        trafficPointMap.put("3_65", "P. Naval");
        trafficPointMap.put("3_64", "Lerma");
        // C5
        trafficPointMap.put("4_131", "Tandang Sora");
        trafficPointMap.put("4_132", "Capitol Hills");
        trafficPointMap.put("4_133", "Universty of the Philippines");
        trafficPointMap.put("4_134", "C.P. Garcia");
        trafficPointMap.put("4_135", "Miriam College");
        trafficPointMap.put("4_136", "Ateneo De Manila University");
        trafficPointMap.put("4_137", "Xavierville");
        trafficPointMap.put("4_138", "Aurora Boulevard");
        trafficPointMap.put("4_139", "P. Tuazon");
        trafficPointMap.put("4_140", "Bonny Serrano");
        trafficPointMap.put("4_72", "Libis Flyover");
        trafficPointMap.put("4_73", "Eastwood");
        trafficPointMap.put("4_74", "Green Meadows");
        trafficPointMap.put("4_75", "Ortigas Avenue");
        trafficPointMap.put("4_76", "J. Vargas");
        trafficPointMap.put("4_77", "Lanuza");
        trafficPointMap.put("4_78", "Bagong Ilog");
        trafficPointMap.put("4_79", "Kalayaan");
        trafficPointMap.put("4_80", "Market! Market!");
        // Ortigas
        trafficPointMap.put("8_116", "Santolan");
        trafficPointMap.put("8_117", "Madison");
        trafficPointMap.put("8_118", "Roosevelt");
        trafficPointMap.put("8_119", "Club Filipino");
        trafficPointMap.put("8_120", "Wilson");
        trafficPointMap.put("8_121", "Connecticut");
        trafficPointMap.put("8_122", "La Salle Greenhills");
        trafficPointMap.put("8_123", "POEA");
        trafficPointMap.put("8_124", "EDSA Shrine");
        trafficPointMap.put("8_125", "San Miguel");
        trafficPointMap.put("8_126", "Meralco Ave");
        trafficPointMap.put("8_127", "Medical City");
        trafficPointMap.put("8_128", "Lanuza Ave");
        trafficPointMap.put("8_129", "Green Meadows Ave");
        trafficPointMap.put("8_130", "C5 Flyover");
        // Marcos Highway
        trafficPointMap.put("9_115", "SM City Marikina");
        trafficPointMap.put("9_114", "LRT-2 Station");
        trafficPointMap.put("9_113", "Dona Juana");
        trafficPointMap.put("9_112", "Amang Rodriguez");
        trafficPointMap.put("9_111", "F. Mariano Ave");
        trafficPointMap.put("9_110", "Robinson's Metro East");
        trafficPointMap.put("9_109", "San Benildo School");
        // Roxas Blvd
        trafficPointMap.put("5_91", "Anda Circle");
        trafficPointMap.put("5_90", "Finance Road");
        trafficPointMap.put("5_89", "U.N. Avenue");
        trafficPointMap.put("5_142", "Pedro Gil");
        trafficPointMap.put("5_88", "Rajah Sulayman");
        trafficPointMap.put("5_87", "Quirino");
        trafficPointMap.put("5_86", "Pablo Ocampo");
        trafficPointMap.put("5_85", "Buendia");
        trafficPointMap.put("5_84", "EDSA Extension");
        trafficPointMap.put("5_83", "Baclaran");
        trafficPointMap.put("5_82", "Airport Road");
        trafficPointMap.put("5_81", "Coastal Road");
        // SLEX
        trafficPointMap.put("6_97", "Magallanes");
        trafficPointMap.put("6_96", "Nichols");
        trafficPointMap.put("6_141", "C5 On-ramp");
        trafficPointMap.put("6_95", "Merville Exit");
        trafficPointMap.put("6_94", "Bicutan Exit");
        trafficPointMap.put("6_93", "Sucat Exit");
        trafficPointMap.put("6_92", "Alabang Exit");
        // NLEX
        trafficPointMap.put("10_157", "Sta. Ines");
        trafficPointMap.put("10_159", "Angeles");
        trafficPointMap.put("10_160", "Mexico");
        trafficPointMap.put("10_161", "San Fernando");
        trafficPointMap.put("10_162", "San Simon");
        trafficPointMap.put("10_163", "Pulilan");
        trafficPointMap.put("10_164", "Sta. Rita");
        trafficPointMap.put("10_165", "Balagtas");
        trafficPointMap.put("10_166", "Tabang");
        trafficPointMap.put("10_167", "Bocaue");
        trafficPointMap.put("10_168", "Marilao");
        trafficPointMap.put("10_169", "Meycauayan");
        trafficPointMap.put("10_170", "Valenzuela");
        trafficPointMap.put("10_172", "Mindanao Avenue");
        trafficPointMap.put("10_171", "Balintawak");
    }


    public String getTrafficPointName(String lineId, String trafficPointId) {
        if (lineId == null || trafficPointId == null) {
            return null;
        }
        return trafficPointMap.get(lineId + "_" + trafficPointId);
    }
}
