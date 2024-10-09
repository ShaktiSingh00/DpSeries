class KnapSackRecursive {

    public static int knapsackRec(int[] values, int[] weight, int capacity, int n) {

        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (weight[n - 1] > capacity) {
            return knapsackRec(values, weight, capacity, n - 1);
        } else {
            int include = values[n - 1] + knapsackRec(values, weight, capacity - weight[n - 1], n - 1);
            int exclude = knapsackRec(values, weight, capacity, n - 1);

            return Math.max(include, exclude);
        }

    }

    public static void main(String[] args) {
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };

        int capacity = 5;
        int n = values.length;

        System.out.println(knapsackRec(values, weights, capacity, n));
    }
}