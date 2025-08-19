package Low_Level_Design.Movie_Ticket_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Theatre {

    int screen_size = 5;
    Screen[] screens = new Screen[screen_size];
    enum Movies{
        RRR, Baahubali, F1, Avengers, War
    }

    List<Movies> movies = new ArrayList<>(Arrays.asList(Movies.RRR, Movies.Baahubali, Movies.F1, Movies.Avengers, Movies.War));
    String[] times = new String[]{"9:00AM", "9:30AM", "10:00AM", "10:30AM", "11:00AM",
            "1:00PM", "1:30PM", "2:00PM", "2:30PM", "3:00PM",
            "5:00PM", "5:30PM", "6:00PM", "6:30PM", "7:00PM",
            "9:00PM", "9:30PM", "10:00PM", "10:30PM", "11:00PM"};



    Theatre(){

        for(int i=0;i<screen_size;i++) {
            String[] timings = new String[]{times[i], times[i+5], times[i+10], times[i+15]};
            Movies m = movies.removeFirst();
            screens[i] = new Screen(movies, timings);
            movies.add(m);
        }
    }

    public void getTimes(String movie){

        System.out.println("--------------" + movie + "---------------");

        for(int j=0;j<4;j++){
            for (int i=0;i<screen_size;i++){
                if(screens[i].movies[j].movie.toString().equals(movie)){
                    System.out.println(screens[i].movies[j].time + " - " + "screen " + (i+1));
                }
            }
        }
    }

    public static void main(String[] args){

        Theatre t = new Theatre();


        t.getTimes("Baahubali");
        t.getTimes("F1");
        t.getTimes("Avengers");
        t.getTimes("War");
        t.getTimes("RRR");




    }




}
