class MyCircularQueue {
    LinkedList<Integer> circularQueue;
    int size = 0;

    public MyCircularQueue(int k) {
        circularQueue = new LinkedList<>();
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(circularQueue.size() == size)
            return false;
        circularQueue.offer(value);
        return true;
    }
    
    public boolean deQueue() {
        if(!circularQueue.isEmpty()) {
            circularQueue.poll();
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(!circularQueue.isEmpty())
            return circularQueue.getFirst();
        return -1;
    }
    
    public int Rear() {
        if(!circularQueue.isEmpty())
            return circularQueue.getLast();
        return -1;
    }
    
    public boolean isEmpty() {
        return circularQueue.isEmpty();
    }
    
    public boolean isFull() {
        return size == circularQueue.size();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */