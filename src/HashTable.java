import com.sun.glass.ui.Size;

public class HashTable {
    private TableCells[] table;
    private static int size = 10;

    HashTable() {
        table = new TableCells[size];
        for (int i = 0; i < size; i++)
            table[i] = null;
    }

    public HashTable put(int key, int value) {
        int HCode = key % size;
        int StartIndex = -1;
        int indexDelCell = -1;
        while (HCode != StartIndex
                && (table[HCode] == DelTCells.UniqDelCell()
                || table[HCode] != null && table[HCode].getKey() != key)) {
            if (StartIndex == -1)
                StartIndex = HCode;
            if (table[HCode] == DelTCells.UniqDelCell())
                indexDelCell = HCode;
            HCode = (HCode + 1) % size;
        }
        if ((table[HCode] == null || HCode == StartIndex)
                && indexDelCell != -1)
            table[indexDelCell] = new TableCells(key, value);
        else if (StartIndex != HCode)
            if (table[HCode] != DelTCells.UniqDelCell() && table[HCode] != null
                    && table[HCode].getKey() == key)
                table[HCode].setValue(value);
        else
                table[HCode] = new TableCells(key, value);
        return null;
    }

    public int get(int key) {
        int HCode = key % size;
        int StartIndex = -1;
        while (HCode != StartIndex && (table[HCode] == DelTCells.UniqDelCell()
                || table[HCode] != null && table[HCode].getKey() != key)) {
            if (StartIndex == -1)
                StartIndex = HCode;
            HCode = (HCode + 1) % size;
        }
        return table[HCode].getValue();
    }

    public HashTable del(int key) {
        int HCode = key % size;
        int StartIndex = -1;
        while (HCode != StartIndex && (table[HCode] == DelTCells.UniqDelCell()
                || table[HCode] != null && table[HCode].getKey() != key)){
            if (StartIndex == -1)
                StartIndex = HCode;
            HCode = (HCode + 1) % size;
        }
        if (HCode != StartIndex && table[HCode] != null)
            table[HCode] = DelTCells.UniqDelCell();
        return null;
    }

    public boolean compare(HashTable hashTable) {
        for (int i = 0; i < size; i++) {
            if (table[i] == hashTable.table[i]) {
                return false;
            }
        }
        return true;
    }
}
