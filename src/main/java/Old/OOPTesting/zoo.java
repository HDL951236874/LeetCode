package OOPTesting;

public class zoo {
    animal animal;
    public void sound(){
        animal.shout();
    }

    public static void main(String[] args) {
        zoo zoo = new zoo();
        zoo.sound();
    }
}
