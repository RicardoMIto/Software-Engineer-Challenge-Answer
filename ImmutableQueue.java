
class ImmutableQueue<E> implements Queue<E> {

  public ImmutableQueue<E> deQueue() {
    throw new IndexOutOfBoundsException("You can't deQueue a empty queue");
  }

  public ImmutableQueue<E> enQueue(E e) {
    if (e == null) {
      throw new IllegalArgumentException("Argument mustn't be null");
    }
    return new ImmutableNotEmptyQueue(this, e);
  }

  public E head() {
    throw new IndexOutOfBoundsException("This Queue is Empty");
  }

  public boolean isEmpty() {
    return true;
  }

  public int size() {
    return 0;
  }

  private class ImmutableNotEmptyQueue extends ImmutableQueue<E> {

    private final ImmutableQueue<E> originalQueue;
    private final E first;
    private final int size;

    private ImmutableNotEmptyQueue(ImmutableQueue<E> originalQueue, E last) {
      this.originalQueue = originalQueue;
      this.first = originalQueue.isEmpty() ? last : originalQueue.head();
      this.size = originalQueue.size() + 1;
    }

    @Override
    public ImmutableQueue<E> deQueue() {
      return this.originalQueue;
    }

    @Override
    public E head() {
      return this.first;
    }

    @Override
    public boolean isEmpty() {
      return false;
    }

    @Override
    public int size() {
      return this.size;
    }
  }
}