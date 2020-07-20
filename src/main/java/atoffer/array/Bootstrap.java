package atoffer.array;

public class Bootstrap {
    public static void main(String[] args) {
        VectorAlgorithm va = new VectorAlgorithm();
        int result = va.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(result);
    }
}
