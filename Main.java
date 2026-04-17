public class Main {

    public static void main(String[] args) {

        System.out.println("ALGORITMOS DE ORDENAMIENTO\n");

        int[] entrada1 = {300, 1, 9, 89, 0, 3, 6, 178, 94, 345, 1000, 7};
        int[] entrada2 = {300, 1, 9, 89, 0, 3, 6, 178, 94, 345, 1000, 7};

        System.out.println("Merge Sort");
        ArrayData arregloMerge = new ArrayData(entrada1);

        System.out.print("Original: ");
        arregloMerge.show();

        arregloMerge.mergeSort();

        System.out.print("Ordenado: ");
        arregloMerge.show();

        System.out.println("\nQuick Sort");
        ArrayData arregloQuick = new ArrayData(entrada2);

        System.out.print("Original: ");
        arregloQuick.show();

        arregloQuick.quickSort();

        System.out.print("Ordenado: ");
        arregloQuick.show();

        System.out.println("\nProducto Punto");
        int[] v1 = {1, 2, 3};
        int[] v2 = {4, 5, 6};

        ArrayData vectorA = new ArrayData(v1);
        ArrayData vectorB = new ArrayData(v2);

        System.out.print("Vector a = ");
        vectorA.show();

        System.out.print("Vector b = ");
        vectorB.show();

        int resultado = vectorA.productoPunto(vectorB);
        System.out.println("a · b = " + resultado);

        System.out.println("\nPrueba de validacion");
        try {
            int[] v3 = {1, 2};
            int[] v4 = {3, 4, 5};
            ArrayData vecCorto = new ArrayData(v3);
            ArrayData vecLargo = new ArrayData(v4);
            vecCorto.productoPunto(vecLargo);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        }
    }
}
