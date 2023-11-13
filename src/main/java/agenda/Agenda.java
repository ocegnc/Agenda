package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Test push Océane
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    private ArrayList<Event> Events;

    public void addEvent(Event e) {
        Events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> EventsDay = new ArrayList<Event>();
        for(Event e : Events){
            if (e.isInDay(day)){
                EventsDay.add(e);
            }
        }
        return EventsDay;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> SameTitle = new ArrayList<Event>();
        for(Event e : Events){
            if(e.getTitle().equals(title)){
                SameTitle.add(e);
            }
        }
        return SameTitle;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {

    }

}
