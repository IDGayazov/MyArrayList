import java.util.Comparator;

public class ArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int currSize;
    private int size;
    private T[] arr;
    public ArrayList() {
        this(INITIAL_CAPACITY);
    }
    public ArrayList(int size) {
        this.currSize = 0;
        this.size = size;
        this.arr = (T[]) new Object[size];
    }
    public ArrayList(final ArrayList<? extends T> arrList){
        this(arrList.size());
        int sz = arrList.size();
        this.addAll(arrList);
        new java.util.ArrayList<>();
    }
    public void add(T elem){
        if(currSize == size){
            T[] tmp = arr;
            arr = (T[])new Object[2*size];
            System.arraycopy(tmp, 0, arr, 0, size);
            size *= 2;
        }
        arr[currSize++] = elem;
    }
    public void add(int index, T elem){

        if(index < 0 || index >= currSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        if(currSize == size){
            T[] tmp = arr;
            arr = (T[])new Object[2*size];
            System.arraycopy(tmp, 0, arr, 0, size);
            size *= 2;
        }

        for(int i = currSize + 1; i > index; --i){
            arr[i] = arr[i - 1];
        }

        arr[index] = elem;
        currSize++;
    }
    public void addAll(final ArrayList<? extends T> sourceList){
        final int sourceListSize = sourceList.size();
        for(int i = 0; i < sourceListSize; ++i){
            this.add(sourceList.get(i));
        }
    }
    public T get(int i){
        if(i < 0 || currSize <= i)
            throw new ArrayIndexOutOfBoundsException();
        return this.arr[i];
    }
    public int indexOf(T elem){
        for(int i = 0; i < currSize; ++i){
            if(elem.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }
    public T remove(int index){
        if(index < 0 || index >= currSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        T elem = arr[index];
        for(int i = index; i < currSize; ++i){
            arr[i] = arr[i + 1];
        }

        currSize--;

        return elem;
    }
    public boolean remove(T elem){
        int index = this.indexOf(elem);
        if(index == -1){
            return false;
        }
        this.remove(index);
        return true;
    }
    public void sort(Comparator<? super T> comparator){
        boolean swapped;
        for(int i = currSize; i > 0; --i){
            swapped = false;
            for(int j = 0; j < i - 1; ++j){
                if(comparator.compare(arr[j], arr[j + 1]) > 0){
                    T elem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = elem;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    public static <T> void sort(ArrayList<? extends T> arrList, Comparator<? super T> comp){
        arrList.sort(comp);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return currSize;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for(int i = 0; i < currSize; ++i){
           sb.append(arr[i] + " ");
        }
        sb.append("}");
        return sb.toString();
    }
}
