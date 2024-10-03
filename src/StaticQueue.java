public class StaticQueue {
    private int top = -1;
    private int base = 0;
    private Coordenada[] data;

    public StaticQueue(int size) {
        this.data = new Coordenada[size];
    }

    public boolean isFull() {
        if(top == data.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top - base == -1) {
            return true;
        }
        return false;
    }

    public void add(Coordenada coordenada) {
        if (isFull()) {
            throw new StackOverflowError("Stack cheia");
        } else {
            top++;
            data[top] = coordenada;
        }
    }

    public Coordenada remove() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack já vazia");
        }
        Coordenada pop = data[base];
        data[base] = null;
        base++;
        if(base > top) {
            top = -1;
            base = 0;
        }
        return pop;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
        base = 0;
    }

}
