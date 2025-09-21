interface ICheckout { double generateBill(); double applyDisc(); }

class Product{
    String n,c; double p; Product(String n,String c,double p){ this.n=n; this.c=c; this.p=p;}
}

class Cart{
    Product[] items;
    Cart(Product[] items){ this.items=items;}
    double total(){ double tot=0; for(Product x:items) tot+=x.p; return tot;}
}

class PerishableProduct extends Product implements ICheckout{
    PerishableProduct(String n,String c,double p){ super(n,c,p);}
    public double generateBill(){ return p;}
    public double applyDisc(){ return p*0.9;}
}

class NonPerishableProduct extends Product implements ICheckout{
    NonPerishableProduct(String n,String c,double p){ super(n,c,p);}
    public double generateBill(){ return p;}
    public double applyDisc(){ return p*0.95;}
}

// ---------------- Main ----------------
public class Scenario9_SwiftCart{
    public static void main(String[] args){
        Product[] items = {
                new PerishableProduct("Milk","Dairy",50),
                new NonPerishableProduct("Soap","Grocery",30)
        };
        Cart cart = new Cart(items);
        System.out.println("Total Bill: "+cart.total());
        System.out.println("Discounted Milk: "+items[0].applyDisc());
    }
}
