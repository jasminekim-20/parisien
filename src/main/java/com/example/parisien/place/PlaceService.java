package com.example.parisien.place;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlaceService {

    private final List<Place> places = new ArrayList<>();
    private final Map<String, Place> byId = new HashMap<>();

    public PlaceService() {
        places.add(new Place("att-01", "31 Rue Vergniaud", "ATTRACTION", 48.8886456, 2.2826205, null));
        places.add(new Place("att-02", "Bibliothèque nationale de France (BnF) | Richelieu", "ATTRACTION", 48.8673812, 2.3384826, null));
        places.add(new Place("att-03", "Bourdelle Museum", "ATTRACTION", 48.8431549, 2.3186433, null));
        places.add(new Place("att-04", "Château de Versailles", "ATTRACTION", 48.8048649, 2.1203554, null));
        places.add(new Place("att-05", "Cité de l'architecture et du patrimoine", "ATTRACTION", 48.8625207, 2.2872414, null));
        places.add(new Place("att-06", "Citéco - Cité de l'Économie", "ATTRACTION", 48.8806780, 2.2952139, null));
        places.add(new Place("att-07", "Conciergerie", "ATTRACTION", 48.8553788, 2.3450130, null));
        places.add(new Place("att-08", "Cour Carrée", "ATTRACTION", 48.8603561, 2.3350614, null));
        places.add(new Place("att-09", "Courtyard of the Hotel de Sully", "ATTRACTION", 48.8551534, 2.3611971, null));
        places.add(new Place("att-10", "Domaine National du Palais-Royal", "ATTRACTION", 48.8637069, 2.3370320, null));
        places.add(new Place("att-11", "Eiffel Tower", "ATTRACTION", 48.8582599, 2.2945006, null));
        places.add(new Place("att-12", "Église Saint-Sulpice", "ATTRACTION", 48.8517188, 2.3319550, null));
        places.add(new Place("att-13", "Église Saint-Séverin", "ATTRACTION", 48.8528014, 2.3449277, null));
        places.add(new Place("att-14", "Espace Niemeyer", "ATTRACTION", 48.8851426, 2.3391853, null));
        places.add(new Place("att-15", "Galerie Vivienne", "ATTRACTION", 48.8665322, 2.3395374, null));
        places.add(new Place("att-16", "Jardin du Luxembourg", "ATTRACTION", 48.8464060, 2.3378173, null));
        places.add(new Place("att-17", "La Défense", "ATTRACTION", 48.8925014, 2.2361054, null));
        places.add(new Place("att-18", "La Galerie Dior", "ATTRACTION", 48.8664857, 2.3070634, null));
        places.add(new Place("att-19", "La Madeleine", "ATTRACTION", 48.8698579, 2.3244102, null));
        places.add(new Place("att-20", "La Sainte-Chapelle", "ATTRACTION", 48.8554421, 2.3443920, null));
        places.add(new Place("att-21", "Le Centre Pompidou", "ATTRACTION", 48.8605686, 2.3522250, null));
        places.add(new Place("att-22", "Le Marais", "ATTRACTION", 48.8577472, 2.3613955, null));
        places.add(new Place("att-23", "Le Musée des arts décoratifs", "ATTRACTION", 48.8636164, 2.3338208, null));
        places.add(new Place("att-24", "Le Petit Palais", "ATTRACTION", 48.8660507, 2.3134566, null));
        places.add(new Place("att-25", "Les Invalides", "ATTRACTION", 48.8566434, 2.3120889, null));
        places.add(new Place("att-26", "Les Tuileries", "ATTRACTION", 48.8640405, 2.3276953, null));
        places.add(new Place("att-27", "Louvre Museum", "ATTRACTION", 48.8604980, 2.3355316, null));
        places.add(new Place("att-28", "Maison de la Culture du Japon à Paris", "ATTRACTION", 48.8507006, 2.2818229, null));
        places.add(new Place("att-29", "Maison de Victor Hugo", "ATTRACTION", 48.8541294, 2.3662884, null));
        places.add(new Place("att-30", "Musée Bourdelle", "ATTRACTION", 48.8431659, 2.3186203, null));
        places.add(new Place("att-31", "Musée de Cluny", "ATTRACTION", 48.8515296, 2.3439836, null));
        places.add(new Place("att-32", "Musée de la Chasse et de la Nature", "ATTRACTION", 48.8600309, 2.3599384, null));
        places.add(new Place("att-33", "Musée de la Vie Romantique", "ATTRACTION", 48.8822148, 2.3331824, null));
        places.add(new Place("att-34", "Musée des Arts Forains", "ATTRACTION", 48.8330184, 2.3889775, null));
        places.add(new Place("att-35", "Musée des Plans-Reliefs", "ATTRACTION", 48.8566266, 2.3120750, null));
        places.add(new Place("att-36", "Musée d'Orsay", "ATTRACTION", 48.8599655, 2.3264698, null));
        places.add(new Place("att-37", "Musée Nissim de Camondo", "ATTRACTION", 48.8797995, 2.3080748, null));
        places.add(new Place("att-38", "Musée Rodin", "ATTRACTION", 48.8553045, 2.3154934, null));
        places.add(new Place("att-39", "Notre-Dame Cathedral of Paris", "ATTRACTION", 48.8529715, 2.3499034, null));
        places.add(new Place("att-40", "Panthéon", "ATTRACTION", 48.8462209, 2.3458287, null));
        places.add(new Place("att-41", "Palais Garnier", "ATTRACTION", 48.8718615, 2.3316026, null));
        places.add(new Place("att-42", "Passage des Panoramas", "ATTRACTION", 48.8700324, 2.3425911, null));
        places.add(new Place("att-43", "Place des Vosges", "ATTRACTION", 48.8553208, 2.3667235, null));
        places.add(new Place("att-44", "Pont Alexandre III", "ATTRACTION", 48.8638931, 2.3135077, null));
        places.add(new Place("att-45", "Saint-Germain-des-Prés", "ATTRACTION", 48.8538596, 2.3337042, null));
        places.add(new Place("att-46", "The Basilica of the Sacred Heart of Paris", "ATTRACTION", 48.8867046, 2.3431050, null));
        places.add(new Place("att-47", "The Centre Pompidou", "ATTRACTION", 48.8605686, 2.3522250, null));

        places.add(new Place("cafe-01", "BUDDY BUDDY · Nut Butter Coffee Bar", "CAFE", 48.8650620, 2.3610326, null));
        places.add(new Place("cafe-02", "Bonjour Jacob", "CAFE", 48.8709031, 2.3631437, null));
        places.add(new Place("cafe-03", "Dreamin’ Man", "CAFE", 48.8646092, 2.3512541, null));
        places.add(new Place("cafe-04", "Dreamin’ Man", "CAFE", 48.8605679, 2.3644, null));
        places.add(new Place("cafe-05", "Noir", "CAFE", 48.8674715, 2.3244670, null));
        places.add(new Place("cafe-06", "RECTO VERSO", "CAFE", 48.8612979, 2.3584060, null));
        places.add(new Place("cafe-07", "Sevenly Heart", "CAFE", 48.8614328, 2.3583100, null));
        places.add(new Place("cafe-08", "The Coffee", "CAFE", 48.8659666, 2.3399664, null));

        places.add(new Place("other-01", "Pareux Eric", "OTHER", 48.8443716, 2.2777170, null));

        rebuildIndex();
    }

    private void rebuildIndex() {
        byId.clear();
        for (Place p : places) {
            byId.put(p.getId(), p);
        }
    }

    public List<Place> findAll() {
        return Collections.unmodifiableList(places);
    }

    public Place findByIdOrThrow(String id) {
        Place p = byId.get(id);
        if (p == null) throw new IllegalArgumentException("Place not found: " + id);
        return p;
    }
}
