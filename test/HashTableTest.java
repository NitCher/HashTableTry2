import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    static HashTable hashTable;

    @BeforeAll
    static void createHashTable(){
        hashTable = new HashTable();
    }

    @Test
    void putTest() {
        hashTable.put(0, 0);
        hashTable.put(1, 10);
    }

    @Test
    void getTest() {
        hashTable.get(0);
    }

    @Test
    void delTest() {
        hashTable.del(0);
    }

    @Test
    void compareTest() {
        HashTable hashTableToCompare = new HashTable();
        hashTableToCompare.put(0, 0);
        hashTableToCompare.put(1, 10);
        hashTable.compare(hashTableToCompare);
    }
}
