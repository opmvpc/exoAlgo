package decoupe;

import java.util.HashMap;

public class Decoupe {
    private static HashMap<Integer, Integer> prix = setPrix();


    private static HashMap<Integer, Integer> setPrix() {
        HashMap<Integer, Integer> prix = new HashMap<Integer, Integer>();

        prix.put(1, 1);
        prix.put(2, 5);
        prix.put(3, 8);
        prix.put(4, 9);
        prix.put(5, 10);
        prix.put(6, 17);
        prix.put(7, 17);
        prix.put(8, 20);
        prix.put(9, 24);
        prix.put(10, 30);

        return prix;
    }

    /*@
    @ requires m > 0 && m < 2;
    @ ensures \result == m;
    @ also
    @ requires m > 1;
    @ ensures (forall int i; 1<=i && i<m; \result == (\max int x;1<=i && i<m;x == (m / i) * prix.get(i))
    @*/
    public static int decoupeTige(int m){

        if (m <= 1) {
            return m;
        }

        int max = 0;
        for (int i = 1; i <= m; i++) {
            int decoupe = m/i;
            int unPrix = decoupe * prix.get(i > 10 ? 10: i) + decoupeTige(m-(decoupe*i));
            if (max < unPrix) {
                max = unPrix;
            }
        }

        return max;
    }
}
