interface ISchedulable{ void schedule(); void reschedule(); void cancel(); }

class Event{
    String n,loc,date;
    int attendees;
    Event(String n,String loc,String date,int attendees){ this.n=n; this.loc=loc; this.date=date; this.attendees=attendees;}
}

class UserE{
    String n;
    UserE(String n){ this.n=n; }
}

class BirthdayEvent extends Event{
    BirthdayEvent(String n,String loc,String date,int att){ super(n,loc,date,att);}
    void schedule(){ System.out.println("Birthday "+n+" scheduled at "+loc);}
}

// ---------------- Main ----------------
public class Scenario13_EventEase{
    public static void main(String[] args){
        BirthdayEvent e = new BirthdayEvent("AnkitaBD","Hall1","22-Sep",50);
        UserE u = new UserE("Ankita");
        e.schedule();
        System.out.println("Organizer: "+u.n);
    }
}
