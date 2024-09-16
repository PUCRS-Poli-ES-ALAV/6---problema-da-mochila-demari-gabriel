public class Main {

    public static void main(String[] args) {

        Contador c = new Contador();

        // System.out.println("FIBONACCI RECURSIVO DE 4: " + FIBO_REC(4));
        // System.out.println("FIBONACCI RECURSIVO DE 8: " + FIBO_REC(8));
        // System.out.println("FIBONACCI RECURSIVO DE 16: " + FIBO_REC(16));
        // System.out.println("FIBONACCI RECURSIVO DE 32: " + FIBO_REC(32));
        // System.out.println("FIBONACCI DINÂMICO DE 4: " + FIBO(4));
        // System.out.println("FIBONACCI DINÂMICO DE 8: " + FIBO(8));
        // System.out.println("FIBONACCI DINÂMICO DE 16: " + FIBO(16));
        // System.out.println("FIBONACCI DINÂMICO DE 32: " + FIBO(32));
        // System.out.println("FIBONACCI RECURSIVO DE 128: " + FIBO_REC(128));
        // System.out.println("FIBONACCI RECURSIVO DE 1000: " + FIBO_REC(1000));
        // System.out.println("FIBONACCI RECURSIVO DE 10000: " + FIBO_REC(10000));
        // System.out.println("FIBONACCI MEMOIZED DE 4: " + MEMOIZED_FIBO(new int[4], 4));
        // System.out.println("FIBONACCI MEMOIZED DE 8: " + MEMOIZED_FIBO(new int[8], 8));
        // System.out.println("FIBONACCI MEMOIZED DE 16: " + MEMOIZED_FIBO(new int[16], 16));
        // System.out.println("FIBONACCI MEMOIZED DE 32: " + MEMOIZED_FIBO(new int[32], 32));
        // System.out.println("FIBONACCI MEMOIZED DE 128: " + MEMOIZED_FIBO(new int[128], 128));
        // System.out.println("FIBONACCI MEMOIZED DE 1000: " + MEMOIZED_FIBO(new int[1000], 1000));
        // System.out.println("FIBONACCI MEMOIZED DE 10000: " + MEMOIZED_FIBO(new int[10000], 10000));

        // int[] w = {2,1,1,4,12};
        // int[] v = {2,1,2,10,4};
        // int W = 15;
        // int n = w.length;
        
        // System.out.println("BACKPACK DE 15: " + backpack(w, v, W, n, c) + " COM " + c.getCount() + " OPERAÇÕES");

        Item[] itens = new Item[7];
        int pesomochila = 190;
        itens[0] = null;
        //  Pesos:  56, 59, 80, 64, 75, 17

        //Valores: 50, 50, 64, 46, 50, 05
        itens[1] = new Item(50, 56);
        itens[2] = new Item(50, 59);
        itens[3] = new Item(64, 80);
        itens[4] = new Item(46, 64);
        itens[5] = new Item(50, 75);
        itens[6] = new Item(5, 17);
        System.out.println("BACKPACK DE " + pesomochila + ": " + backPackPD(itens.length -1, pesomochila, itens, c) + " COM " + c.getCount() + " OPERAÇÕES");

        


    }

    public static int FIBO_REC(int n){
        if(n <= 1) return n;
        return FIBO_REC(n-1) + FIBO_REC(n-2);
    }

    public static int FIBO(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static int MEMOIZED_FIBO(int[] f, int n) {
        for(int i = 0; i < n; i++) {
            f[i] = -1;
        }
        return LOOKUP_FIBO(f,n);
    }

    private static int LOOKUP_FIBO(int[] f, int n) {
        if(f[n] >= 0) return f[n];
        if(f[n] <= 1) {
            f[n] = n;
        }else {
            f[n] = LOOKUP_FIBO(f, n - 1) + LOOKUP_FIBO(f, n - 2);   
        }

        return f[n];
    }


    private static int backpack(int[] w, int[] v, int W, int n, Contador c) {
        c.increment();
        if(n == 0 || W == 0) return 0;
        if(w[n-1] > W) return backpack(w, v, W, n-1, c);
        return Math.max(v[n-1] + backpack(w, v, W - w[n-1], n-1, c), backpack(w, v, W, n-1, c));
    }

    public static int backPackPD(int n, int c, Item[] itens, Contador cont){
        int[][] maxTab = new int[n+1][c+1];


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= c; j++){
                cont.increment();
                if(i == 0 || j == 0){
                    maxTab[i][j] = 0;
                }else if(itens[i].peso <= j){
                    maxTab[i][j] = Math.max(itens[i].valor + maxTab[i-1][j-itens[i].peso], maxTab[i-1][j]);
                }else{
                    maxTab[i][j] = maxTab[i-1][j];
                }
            }
        }   

        return maxTab[n][c];
    }
}
