public class ArrayData {

    // array size
    private final int arraySize;

    // data array
    private int[] array;

    // constructor: copies the input data
    public ArrayData(int[] datos) {
        this.arraySize = datos.length;
        this.array = new int[this.arraySize];

        for (int i = 0; i < datos.length; i++) {
            this.array[i] = datos[i];
        }
    }

    // returns the size
    public int getSize() {
        return arraySize;
    }

    // returns a copy of the array
    public int[] getArray() {
        int[] copia = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            copia[i] = array[i];
        }
        return copia;
    }

    // prints the array
    public void show() {
        System.out.print("[");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i]);
            if (i < arraySize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // starts merge sort
    public void mergeSort() {
        mergeSortRecursivo(0, this.arraySize - 1);
    }

    // splits the array
    private void mergeSortRecursivo(int izquierda, int derecha) {
        if (izquierda >= derecha) return;

        int medio = (izquierda + derecha) / 2;

        mergeSortRecursivo(izquierda, medio);
        mergeSortRecursivo(medio + 1, derecha);

        combinar(izquierda, medio, derecha);
    }

    // merges and sorts
    private void combinar(int izquierda, int medio, int derecha) {
        int[] izq = new int[medio - izquierda + 1];
        int[] der = new int[derecha - medio];

        for (int i = 0; i < izq.length; i++) {
            izq[i] = array[izquierda + i];
        }

        for (int j = 0; j < der.length; j++) {
            der[j] = array[medio + 1 + j];
        }

        int i = 0, j = 0, k = izquierda;

        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                array[k++] = izq[i++];
            } else {
                array[k++] = der[j++];
            }
        }

        while (i < izq.length) array[k++] = izq[i++];
        while (j < der.length) array[k++] = der[j++];
    }

    // starts quick sort
    public void quickSort() {
        quickSortRecursivo(0, this.arraySize - 1);
    }

    // splits the array recursively
    private void quickSortRecursivo(int izquierda, int derecha) {
        if (izquierda >= derecha) return;

        int indicePivote = partir(izquierda, derecha);

        quickSortRecursivo(izquierda, indicePivote - 1);
        quickSortRecursivo(indicePivote + 1, derecha);
    }

    // partitions around pivot and returns pivot index
    private int partir(int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temp;

        return i + 1;
    }

    // computes dot product with another ArrayData
    public int productoPunto(ArrayData otro) {
        if (this.arraySize != otro.arraySize) {
            throw new IllegalArgumentException(
                "Los vectores deben tener el mismo tamanio: " +
                this.arraySize + " != " + otro.arraySize
            );
        }

        int resultado = 0;
        for (int i = 0; i < this.arraySize; i++) {
            resultado += this.array[i] * otro.array[i];
        }
        return resultado;
    }
}
