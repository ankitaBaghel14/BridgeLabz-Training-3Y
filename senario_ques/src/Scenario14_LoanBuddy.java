interface IApprovable{ void approveLoan(); double calcEMI(); }

class Applicant{
    String n; int score; double inc,loanAmt;
    Applicant(String n,int score,double inc,double loanAmt){ this.n=n; this.score=score; this.inc=inc; this.loanAmt=loanAmt;}
}

class LoanApp implements IApprovable{
    String type; double term,rate;
    LoanApp(String type,double term,double rate){ this.type=type; this.term=term; this.rate=rate; }
    public void approveLoan(){ System.out.println(type+" loan approved"); }
    public double calcEMI(){ return loanAmt*rate*Math.pow(1+rate,term)/(Math.pow(1+rate,term)-1); }
    double loanAmt;
}

// ---------------- Main ----------------
public class Scenario14_LoanBuddy{
    public static void main(String[] args){
        Applicant a = new Applicant("Ankita",750,50000,100000);
        LoanApp la = new LoanApp("Home",12,0.05);
        la.loanAmt=100000;
        la.approveLoan();
        System.out.println("EMI: "+la.calcEMI());
    }
}
