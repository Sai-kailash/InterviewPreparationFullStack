package Low_Level_Design.Ticket_Booking_System;

import java.util.*;

public class MovieScheduler {
    static class Movie {
        String name;

        Movie(String name) {
            this.name = name;
        }
    }

    static class Show {
        String movieName;
        int screenNumber;
        String startTime;
        String endTime;

        Show(String movieName, int screenNumber, String startTime, String endTime) {
            this.movieName = movieName;
            this.screenNumber = screenNumber;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String toString() {
            return "Screen " + screenNumber + ": " + movieName + " (" + startTime + " - " + endTime + ")";
        }
    }

    static String getTimeStr(int minutes) {
        int hour = minutes / 60;
        int min = minutes % 60;
        return String.format("%02d:%02d", hour, min);
    }

    public static void main(String[] args) {
        int numScreens = 5;
        int numMovies = 5;
        int showsPerScreen = 4;
        int showDuration = 120;
        int bufferTime = 30;

        String[] movieNames = {"Avengers", "Inception", "Interstellar", "Batman", "Tenet"};
        List<Movie> movies = new ArrayList<>();
        for (String name : movieNames) movies.add(new Movie(name));

        Map<Integer, List<Show>> schedule = new HashMap<>();
        Map<Integer, Set<String>> moviesOnScreen = new HashMap<>();

        int currentTime = 600; // start at 10:00 AM
        int totalSlots = numScreens * showsPerScreen;
        int showsScheduled = 0;

        List<Integer> screenSlots = new ArrayList<>(Collections.nCopies(numScreens, 0));
        List<Integer> screenTimes = new ArrayList<>(Collections.nCopies(numScreens, 600));
        Queue<String> availableMovies = new LinkedList<>(movies.stream().map(m -> m.name).toList());

        Set<String> playingNow = new HashSet<>();

        while (showsScheduled < totalSlots) {
            for (int screen = 0; screen < numScreens; screen++) {
                if (screenSlots.get(screen) >= showsPerScreen) continue;

                // Find a movie that isn't already playing at this time
                String movieToSchedule = null;
                for (String movie : movieNames) {
                    if (playingNow.contains(movie)) continue;
                    if (moviesOnScreen.getOrDefault(screen, new HashSet<>()).contains(movie)) continue;

                    movieToSchedule = movie;
                    break;
                }

                if (movieToSchedule == null) continue;

                String startTime = getTimeStr(screenTimes.get(screen));
                String endTime = getTimeStr(screenTimes.get(screen) + showDuration);

                Show show = new Show(movieToSchedule, screen + 1, startTime, endTime);
                schedule.computeIfAbsent(screen, k -> new ArrayList<>()).add(show);
                moviesOnScreen.computeIfAbsent(screen, k -> new HashSet<>()).add(movieToSchedule);

                screenSlots.set(screen, screenSlots.get(screen) + 1);
                screenTimes.set(screen, screenTimes.get(screen) + showDuration + bufferTime);

                playingNow.add(movieToSchedule);
                showsScheduled++;
            }

            // Clear simultaneous movie constraint for next time
            playingNow.clear();
        }

        // Print Schedule
        for (int screen = 0; screen < numScreens; screen++) {
            System.out.println("Schedule for Screen " + (screen + 1) + ":");
            for (Show show : schedule.get(screen)) {
                System.out.println("  " + show);
            }
            System.out.println();
        }
    }
}
