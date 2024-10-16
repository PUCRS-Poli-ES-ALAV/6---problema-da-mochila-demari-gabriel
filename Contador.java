import java.io.BufferedWriter;
import java.util.HashMap;

public class Contador {

    private HashMap<Integer, Integer> nAndCounters;
    private Integer atualN;

    public void toCSV(String filename){
        filename = filename + ".csv";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("n,counter\n");
        for (Integer n : this.nAndCounters.keySet()) {
            writer.write(n + "," + this.nAndCounters.get(n) + "\n");
        }
    }

    public setN(Integer n){
        this.atualN = n;
    }

    public Contador() {
        this.nAndCounters = new HashMap<>();
        this.atualN = 0;
    }

    public void startAgain() {
        this.nAndCounters = new HashMap<>();
    }

    public void increment() {
        if (this.nAndCounters.containsKey(this.atualN)) {
            this.nAndCounters.put(this.atualN, this.nAndCounters.get(n) + 1);
        } else {
            this.nAndCounters.put(this.atualN, 1);
        }
    }
}