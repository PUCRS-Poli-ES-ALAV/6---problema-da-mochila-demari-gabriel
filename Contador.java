public class Contador {
    

    private int count;

    public Contador() {
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }
}
