package Low_Level_Design.Movie_Ticket_I;

import java.util.List;

class Movie{
    Theatre.Movies movie;
    String time;

    Movie(Theatre.Movies movie, String time){
        this.movie = movie;
        this.time = time;
    }
}

public class Screen {

    int[][][] seats = new int[4][2][2];
    Movie[] movies = new Movie[4];

    Screen(List<Theatre.Movies> movies, String[] time){
       for(int i=0;i<movies.size();i++){
           this.movies[i] = new Movie(movies.get(i), time[i]);
       }
    }

}
