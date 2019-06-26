
public interface Queue<E> {

    public Queue<E> enQueue(E t);

    public Queue<E> deQueue();

    public Object head();

    public boolean isEmpty();
}