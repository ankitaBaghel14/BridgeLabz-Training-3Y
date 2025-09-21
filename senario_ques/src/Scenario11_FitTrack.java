interface ITrackable { void startWorkout(); void stopWorkout(); }

class UserP{
    String n; int age; double w;
    UserP(String n,int age,double w){ this.n=n; this.age=age; this.w=w;}
}

class Workout{
    String type; int dur, cal;
    Workout(String type,int dur,int cal){ this.type=type; this.dur=dur; this.cal=cal;}
    void info(){ System.out.println("Workout: "+type+", Duration: "+dur+" mins, Cal: "+cal);}
}

class Cardio extends Workout{ Cardio(int dur,int cal){ super("Cardio",dur,cal);} }
class Strength extends Workout{ Strength(int dur,int cal){ super("Strength",dur,cal);} }

// ---------------- Main ----------------
public class Scenario11_FitTrack{
    public static void main(String[] args){
        UserP u = new UserP("Ankita",22,55);
        Cardio w1 = new Cardio(30,250);
        Strength w2 = new Strength(20,150);
        w1.info();
        w2.info();
    }
}
