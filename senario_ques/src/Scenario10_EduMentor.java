interface ICertifiable { void genCert(); }

class UserEM {
    String n,email; int id;
    UserEM(String n,String email,int id){ this.n=n; this.email=email; this.id=id; }
}

class Learner extends UserEM{
    Learner(String n,String email,int id){ super(n,email,id);}
    void printDetails(){ System.out.println("Learner: "+n+", ID:"+id);}
}

class Instructor extends UserEM{
    Instructor(String n,String email,int id){ super(n,email,id);}
    void printDetails(){ System.out.println("Instructor: "+n+", ID:"+id);}
}

class Quiz{
    String[] q; int score;
    Quiz(String[] q){ this.q=q; score=0;}
    void calcScore(int s){ score=s;}
}

// ---------------- Main ----------------
public class Scenario10_EduMentor{
    public static void main(String[] args){
        Learner l = new Learner("Ankita","a@mail.com",101);
        Instructor i = new Instructor("Dr. Sharma","s@mail.com",1);
        l.printDetails();
        i.printDetails();

        Quiz quiz = new Quiz(new String[]{"Q1","Q2"});
        quiz.calcScore(90);
        System.out.println("Quiz Score: "+quiz.score);
    }
}
