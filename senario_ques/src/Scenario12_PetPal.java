interface IInteractable{ void feed(); void play(); void sleep(); }

class Pet{
    String n,t; int age;
    Pet(String n,String t,int age){ this.n=n; this.t=t; this.age=age; }
    void makeSound(){ System.out.println(n+" makes sound"); }
}

class Dog extends Pet implements IInteractable{
    Dog(String n,int age){ super(n,"Dog",age);}
    public void feed(){ System.out.println(n+" fed"); }
    public void play(){ System.out.println(n+" plays"); }
    public void sleep(){ System.out.println(n+" sleeps"); }
    public void makeSound(){ System.out.println(n+" barks"); }
}

class Cat extends Pet implements IInteractable{
    Cat(String n,int age){ super(n,"Cat",age);}
    public void feed(){ System.out.println(n+" fed"); }
    public void play(){ System.out.println(n+" plays"); }
    public void sleep(){ System.out.println(n+" sleeps"); }
    public void makeSound(){ System.out.println(n+" meows"); }
}

class Bird extends Pet implements IInteractable{
    Bird(String n,int age){ super(n,"Bird",age);}
    public void feed(){ System.out.println(n+" fed"); }
    public void play(){ System.out.println(n+" plays"); }
    public void sleep(){ System.out.println(n+" sleeps"); }
    public void makeSound(){ System.out.println(n+" chirps"); }
}

// ---------------- Main ----------------
public class Scenario12_PetPal{
    public static void main(String[] args){
        Dog d = new Dog("Tommy",2);
        Cat c = new Cat("Kitty",1);
        Bird b = new Bird("Tweety",1);
        d.makeSound(); c.makeSound(); b.makeSound();
        d.feed(); c.play(); b.sleep();
    }
}
