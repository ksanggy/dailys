class RandomizedSet {

    private Map<Integer, Integer> valueToIndexMap = new HashMap<>();
    private List<Integer> values = new ArrayList<>();
    private Random randomGenerator = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if(valueToIndexMap.containsKey(val))
            return false;
        valueToIndexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!valueToIndexMap.containsKey(val))
            return false;
        int indexToRemove = valueToIndexMap.get(val);
        int lastElement = values.get(values.size() - 1);
        values.set(indexToRemove, lastElement);
        valueToIndexMap.put(lastElement, indexToRemove);
        values.remove(values.size() - 1);
        valueToIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(randomGenerator.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */