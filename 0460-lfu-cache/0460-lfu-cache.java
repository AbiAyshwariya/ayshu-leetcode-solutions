class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;

    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList {
        int size;
        DLLNode head;
        DLLNode tail;

        DoubleLinkedList() {
            size = 0;
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(DLLNode node) {
            DLLNode nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            size++;
        }

        void removeNode(DLLNode node) {
            DLLNode prevNode = node.prev;
            DLLNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        DLLNode removeLast() {
            if (size > 0) {
                DLLNode node = tail.prev;
                removeNode(node);
                return node;
            }
            return null;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if (node == null) return -1;

        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.val = value;
            updateNode(node);
        } else {
            if (curSize == capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                DLLNode toRemove = minFreqList.removeLast();
                cache.remove(toRemove.key);
                curSize--;
            }

            DLLNode newNode = new DLLNode(key, value);
            minFrequency = 1;

            DoubleLinkedList list = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            list.addNode(newNode);
            frequencyMap.put(1, list);
            cache.put(key, newNode);
            curSize++;
        }
    }

    private void updateNode(DLLNode node) {
        int freq = node.frequency;
        DoubleLinkedList oldList = frequencyMap.get(freq);
        oldList.removeNode(node);

        if (freq == minFrequency && oldList.size == 0) {
            minFrequency++;
        }

        node.frequency++;
        DoubleLinkedList newList =
                frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }
}
