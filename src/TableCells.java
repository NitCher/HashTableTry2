public class TableCells {
    private int key;
    private int value;

    TableCells(int key, int value) {
        this.key = key;
        this.value = value;
    }

    int getValue() {
        return value;
    }

    int getKey() {
        return key;
    }

    void setValue(int value){
        this.value = value;
    }
}

class DelTCells extends TableCells {
    private static DelTCells entry = null;

    private DelTCells(){
        super(-1, -1);
    }

    static DelTCells UniqDelCell() {
        if (entry == null) {
            entry = new DelTCells();
        }
        return entry;
    }
}
