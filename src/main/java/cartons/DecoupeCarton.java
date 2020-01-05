package cartons;

import java.util.ArrayList;

public class DecoupeCarton {
    protected int[][] dessins;

    public DecoupeCarton(int[][] dessins) {
        this.dessins = dessins;
    }

    public int prixMinimum() {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < dessins.length; i++) {
            for (int j = 0; j < dessins.length; j++) {
                // filtrer ceux qui sont plus petits
                ArrayList<int[]> restants = new ArrayList();
                for (int k = 0; k < dessins.length; k++) {
                    if (dessins[k][0] > dessins[i][0] ||  dessins[k][1] > dessins[j][1]) {
                        restants.add(dessins[k]);
                    }
                }
                // calculs
                int prix = dessins[i][0] * dessins[j][1];
                if (! restants.isEmpty()) {
                    prix += restants.stream().map(n ->  n[0]).max(Integer::compareTo).get() * restants.stream().map(n ->  n[1]).max(Integer::compareTo).get();
                }
                min = Integer.min(min, prix);
            }
        }

        return min;
    }
}
