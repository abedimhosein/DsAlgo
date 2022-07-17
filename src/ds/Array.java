package ds;

public class Array {
    private int[] items;
    private int lastIndex = -1;

    private boolean isFull() {
        return this.items.length == (this.lastIndex + 1);
    }

    private void extend() {
        int[] newItems = new int[this.items.length * 2];
        for (int i = 0; i < this.items.length; i++) {
            newItems[i] = this.items[i];
        }
        this.items = newItems;
    }

    private void shiftLeft(int index) {
        for (int idx = index; idx < this.lastIndex; idx++)
            this.items[idx] = this.items[idx + 1];
        this.lastIndex--;
    }

    private void shiftRight(int index) {
        for (int idx = this.lastIndex; idx >= index; idx--)
            this.items[idx + 1] = this.items[idx];
        this.lastIndex++;
    }

    public Array(int length) {
        this.items = new int[length];
    }

    public void insert(int newItem) {
        if (this.isFull())
            this.extend();
        this.items[++this.lastIndex] = newItem;
    }

    public void removeAt(int index) {
        if (index < 0 || index > this.lastIndex) {
            throw new IllegalArgumentException();
        }
        this.shiftLeft(index);
    }

    public int indexOf(int itm) {
        for (int idx = 0; idx <= this.lastIndex; idx++)
            if (this.items[idx] == itm)
                return idx;

        return -1;
    }

    public int max() {
        int currentMax = this.items[0];
        for (int item : this.items) {
            if (currentMax < item)
                currentMax = item;
        }
        return currentMax;
    }

    public Array intersect(Array another) {
        Array intersection = new Array(1);
        for (int i = 0; i <= this.lastIndex; i++) {
            for (int j = 0; j <= another.lastIndex; j++) {
                if (this.items[i] == another.items[j]) {
                    intersection.insert(this.items[i]);
                    break;
                }
            }
        }
        return intersection;
    }

    public Array reverse() {
        Array rvrs = new Array(this.lastIndex);
        for (int idx = this.lastIndex; idx > -1; idx--) {
            rvrs.insert(this.items[idx]);
        }
        return rvrs;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > this.lastIndex) {
            throw new IllegalArgumentException();
        }
        if (this.isFull())
            this.extend();

        shiftRight(index);
        this.items[index] = item;
    }

    public void print() {
        for (int i = 0; i <= this.lastIndex; i++) {
            System.out.print(this.items[i] + " ");
        }
        System.out.println();
    }

}
