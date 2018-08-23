import java.util.*;

public class Frame {
    public String name;
    public ArrayList<Integer> scores;

    public Frame(String name)
    {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public void throwBall(int score)
    {
        this.scores.add(score);
        if (score == 10)
        {
            this.scores.add(0);
        }
    }

    public int getScore()
    {
        int totalScore = 0;
        for(int i=0; i<java.lang.Math.min(this.scores.size(), 20); i+=2){
            int s = this.scores.get(i);
            System.out.println("i = " + i + ", s = " + s);
            int t;
            if(i+1 >= this.scores.size()){
                t = 0;
            }
            else{
                t = this.scores.get(i+1);
            }
            totalScore += (s+t);
            if(s == 10){
                // only if spare (and actually, also strike.)
                try {
                    totalScore += this.scores.get(i + 3);
                }
                catch(IndexOutOfBoundsException e){
                    throw new java.lang.Error("Incomplete score due to strike/spare.");
                }
            }
            if(s+t == 10){
                // only if spare (and actually, also strike.)
                try {
                    totalScore += this.scores.get(i + 2);
                }
                catch(IndexOutOfBoundsException e){
                    throw new java.lang.Error("Incomplete score due to strike/spare.");
                }
            }
            System.out.println("score = " + totalScore);
        }
        /*
        boolean spare = false;
        for(int i=0; i<this.scores.size(); i++){
            // get 2 consecutive frames
            int s = this.scores.get(i);
            int t = 0;
            // attempt to get next frame only if
            if(i != 0) {
                t = this.scores.get(i-1);
            }
            if(spare == true) {
                totalScore += s;
                spare = false;
            }
            if((s+t == 10) && (i%2 == 1)) {
                spare = true;
            }
            totalScore += s;
        }
        */
        return totalScore;
    }
}
