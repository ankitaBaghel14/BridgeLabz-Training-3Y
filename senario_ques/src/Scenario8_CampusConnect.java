interface ICourseActions { void enrollCourse(); void dropCourse(); }

class PersonC {
    String n, email; int id;
    PersonC(String n, String email, int id){ this.n=n; this.email=email; this.id=id;}
}

class StuC extends PersonC{
    StuC(String n,String email,int id){ super(n,email,id);}
    void printDetails(){ System.out.println("Stu: "+n+", Email: "+email+", ID:"+id);}
}

class FacC extends PersonC{
    FacC(String n,String email,int id){ super(n,email,id);}
    void printDetails(){ System.out.println("Fac: "+n+", Email: "+email+", ID:"+id);}
}

class CourseC implements ICourseActions{
    String cn; CourseC(String cn){ this.cn=cn;}
    public void enrollCourse(){ System.out.println("Enrolled in "+cn);}
    public void dropCourse(){ System.out.println("Dropped "+cn);}
}

// ---------------- Main ----------------
public class Scenario8_CampusConnect{
    public static void main(String[] args){
        StuC s = new StuC("Ankita","ankita@mail.com",101);
        FacC f = new FacC("Dr. Sharma","sharma@mail.com",1);
        CourseC c = new CourseC("Math");
        s.printDetails();
        f.printDetails();
        c.enrollCourse();
        c.dropCourse();
    }
}
