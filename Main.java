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

        // Item[] itens = new Item[7];
        // int pesomochila = 190;
        // itens[0] = null;
        // //  Pesos:  56, 59, 80, 64, 75, 17

        // //Valores: 50, 50, 64, 46, 50, 05
        // itens[1] = new Item(50, 56);
        // itens[2] = new Item(50, 59);
        // itens[3] = new Item(64, 80);
        // itens[4] = new Item(46, 64);
        // itens[5] = new Item(50, 75);
        // itens[6] = new Item(5, 17);
        // System.out.println("BACKPACK DE " + pesomochila + ": " + backPackPD(itens.length -1, pesomochila, itens, c) + " COM " + c.getCount() + " OPERAÇÕES");


        String s1 = "Casablanca";
        String s2 = "Portentoso";

        int dist = EDdinamico(s1, s2, c);
        System.out.println("Distância de ED entre " + s1 + " e " + s2 + " é " + dist + " com " + c.getCount() + " operações");          

        s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
   			"simplify the build processes in the Jakarta Turbine project. There were several" + 
   			" projects, each with their own Ant build files, that were all slightly different." +
   			"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
   			"definition of what the project consisted of, an easy way to publish project information" +
   			"and a way to share JARs across several projects. The result is a tool that can now be" +
   			"used for building and managing any Java-based project. We hope that we have created " +
   			"something that will make the day-to-day work of Java developers easier and generally help " +
   			"with the comprehension of any Java-based project.";
        s2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
   			"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
   			"ask? I am going to try to answer this question in this article." + 
   		        "Go to the profile of Marin Vlastelica Pogančić" + 
   		        "Marin Vlastelica Pogančić Jun";
        

        dist = EDdinamico(s1, s2, c);
        System.out.println("Distância de ED entre " + s1 + " e " + s2 + " é " + dist + " com " + c.getCount() + " operações");    

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

    public static int ED(String S, String T, int i, int j)
        {
            if (j == -1 || i == -1)
            {
                return Math.abs(j - i);
            }

            if (S.charAt(i) == T.charAt(j))
            {
                return ED(S, T, i - 1, j - 1);
            }
            else
            {
                // CAS MET
                var substitution = ED(S, T, i - 1, j - 1) + 1;

                //CAS ME
                var insertion = ED(S, T, i, j - 1) + 1;

                //CA MET
                var deletion = ED(S, T, i - 1, j) + 1;
                return Math.min(substitution, Math.min(insertion, deletion));
            }
        }


        public static int EDdinamico(String a, String b, Contador c) {
            int l1 = a.length();
            int l2 = b.length();

            int[][] d = new int[l1 + 1][l2 + 1];
            d[0][0] = 0;
            for(int i = 1; i < l1; i++) {
                d[i][0] = d[i - 1][0] + 1;
                c.increment();
            }

            for(int j = 1; j < l2; j++) {
                d[0][j] = d[0][j - 1] + 1;
                c.increment();
            }

            for(int i = 1; i <= l1; i++) {
                for(int j = 1; j <= l2; j++) {
                    int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                    c.increment();

                    d[i][j] = Minimo(d[i-1][j] + 1,d[i][j-1] + 1, d[i-1][j-1] + cost);
                }
            }
            return d[l1][l2];
        }

        private static int Minimo(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

}
