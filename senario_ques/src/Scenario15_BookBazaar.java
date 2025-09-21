interface IDiscountable{ double applyDisc(); }

class Book{
    String t,a; double p; int stock;
    Book(String t,String a,double p,int stock){ this.t=t; this.a=a; this.p=p; this.stock=stock; }
}

class EBook extends Book implements IDiscountable{
    EBook(String t,String a,double p,int stock){ super(t,a,p,stock);}
    public double applyDisc(){ return p*0.9;}
}

class PrintedBook extends Book implements IDiscountable{
    PrintedBook(String t,String a,double p,int stock){ super(t,a,p,stock);}
    public double applyDisc(){ return p*0.85;}
}

class Order{
    Book[] items;
    Order(Book[] items){ this.items=items; }
    double total(){ double tot=0; for(Book b:items) tot+=b.p; return tot;}
}

// ---------------- Main ----------------
public class Scenario15_BookBazaar{
    public static void main(String[] args){
        Book[] items = { new EBook("Java","Author1",500,10), new PrintedBook("Python","Author2",400,5)};
        Order ord = new Order(items);
        System.out.println("Total Bill: "+ord.total());
        System.out.println("Discounted Java eBook: "+items[0].applyDisc());
    }
}
