import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

public class Contador {

    private HashMap<Integer, Integer> nAndCounters;
    private Integer atualN;

    public void toCSV(String filename){
        filename = filename + ".csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename));){
            writer.write("n,counter\n");
            for (Integer n : this.nAndCounters.keySet()) {
                writer.write(n + "," + this.nAndCounters.get(n) + "\n");
            }
        } catch(Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        }
        
        
        
    }

    public void setN(Integer n){
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
            this.nAndCounters.put(this.atualN, this.nAndCounters.get(this.atualN) + 1);
        } else {
            this.nAndCounters.put(this.atualN, 1);
        }
    }
}