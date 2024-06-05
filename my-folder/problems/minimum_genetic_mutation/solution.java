class Solution {
    class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        Map<Character, String> mutationMap = new HashMap<>();
        mutationMap.put('A', "TCG");
        mutationMap.put('T', "ACG");
        mutationMap.put('C', "ATG");
        mutationMap.put('G', "ATC");


        Deque<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(startGene, 0));
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String currentGene = current.getKey();
            int currentGeneCount = current.getValue();

            if(endGene.equals(currentGene))
                return currentGeneCount;

            for (int i = 0; i < currentGene.length(); i++) {
                for (char mutation : mutationMap.get(currentGene.charAt(i)).toCharArray()) {
                    String mutatedGene = currentGene.substring(0, i) + mutation + currentGene.substring(i + 1);

                    if(bankSet.contains(mutatedGene)) {
                        queue.offer(new Pair<>(mutatedGene, currentGeneCount + 1));
                        bankSet.remove(mutatedGene);
                    }
                }
            }
        }
        return -1; // return -1 if no mutation leads to the end gene
    }
}