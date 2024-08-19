package Assignment1;

public class AveragePetrolPrices {

    public static void main(String[] args) {
        double petrolprice[] = {34.67, 56.78, 67.87, 89.57, 98.76, 86.98};
        double sum = 0.0;

        for (int i = 0; i < petrolprice.length; i++) {
            sum += petrolprice[i];
        }

        double average = sum / petrolprice.length;
        System.out.println("Average is " + average);

        // Bubble Sort
        for (int i = 0; i < petrolprice.length - 1; i++) {
            for (int j = 0; j < petrolprice.length - i - 1; j++) {
                if (petrolprice[j] > petrolprice[j + 1]) {
                    double temp = petrolprice[j];
                    petrolprice[j] = petrolprice[j + 1];
                    petrolprice[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < petrolprice.length; i++) {
            System.out.print(petrolprice[i] + " ");
        }
    }
}
