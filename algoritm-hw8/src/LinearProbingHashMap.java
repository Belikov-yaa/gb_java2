public class LinearProbingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private final Object DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        DELETED = new Object();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    private void expandSize() {
        int newCapacity = getPrime(capacity + 10);
        Key[] oldKeys = keys;
        keys = (Key[]) new Object[newCapacity];
        Value[] oldValues = values;
        values = (Value[]) new Object[newCapacity];
        capacity = newCapacity;
        size = 0;
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != null && !oldKeys[i].equals(DELETED)) {
                put(oldKeys[i], oldValues[i]);
            }
        }
    }

    public void put(Key key, Value value) {
        // проверка на прввышение лоад фактора. Либо просаем эксепшн либо
        // перехиширование на массив размером больше, но простое число
        if (size > capacity * 0.6)
            expandSize();

        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;
        while (keys[i] != null && !keys[i].equals(DELETED)) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            i = (i + step) % capacity;
            step++;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (i + step) % capacity;
            step++;
        }
        return null;
    }

    public Value delete(Key key) {
        int i = hash(key);
        int step = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                Value temp = values[i];
                values[i] = null;
                keys[i] = (Key) DELETED;
                size--;
                return temp;
            }
            i = (i + step) % capacity;
            step++;
        }
        return null;
    }

    // Функция для нахождения ближайшего простого числа
    private int getPrime(int min) {
        for (int i = min + 1; true; i++)
            if (isPrime(i))
                return i;
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++)
            if (n % j == 0)
                return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size() > 0) {
            for (int i = 0; i < capacity; i++) {
                if (keys[i] != null && !keys[i].equals(DELETED)) {
                    sb.append(" {");
                    sb.append(keys[i]).append(", ").append(values[i]);
                    sb.append("}");
                }
            }
        }

        return sb.toString();
    }
}
