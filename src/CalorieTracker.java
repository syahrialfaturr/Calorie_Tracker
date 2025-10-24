import java.util.*;

public class CalorieTracker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> foodCalories = new HashMap<>();
        List<String> eatenFoods = new ArrayList<>();

        // ✅ Daftar makanan default
        foodCalories.put("Nasi Goreng", 350);
        foodCalories.put("Seblak", 400);
        foodCalories.put("Sate Ayam", 250);
        foodCalories.put("Ayam Geprek", 300);
        foodCalories.put("Tempe Goreng", 150);
        foodCalories.put("Mie Goreng", 380);
        foodCalories.put("Bakso", 280);
        foodCalories.put("Nasi Uduk", 320);
        foodCalories.put("Telur Dadar", 120);

        int choice;
        do {
            System.out.println("\n=== CALORIE TRACKER ===");
            System.out.println("1. Tambah Makanan yang Dimakan");
            System.out.println("2. Lihat Total Kalori");
            System.out.println("3. Lihat Daftar Makanan yang Dimakan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama makanan: ");
                    String foodName = input.nextLine().trim();

                    if (foodCalories.containsKey(foodName)) {
                        eatenFoods.add(foodName);
                        System.out.println(foodName + " ditemukan di database! (" +
                                foodCalories.get(foodName) + " kalori)");
                    } else {
                        System.out.println("Makanan tidak ditemukan di database.");
                        System.out.print("Masukkan jumlah kalori untuk " + foodName + ": ");
                        int newCalories = input.nextInt();
                        input.nextLine();
                        foodCalories.put(foodName, newCalories);
                        eatenFoods.add(foodName);
                        System.out.println(foodName + " berhasil ditambahkan ke database (" +
                                newCalories + " kalori).");
                    }
                    break;

                case 2:
                    if (eatenFoods.isEmpty()) {
                        System.out.println("Belum ada makanan yang dimasukkan.");
                    } else {
                        int total = 0;
                        System.out.println("\nDaftar Makanan yang Dimakan:");
                        for (String f : eatenFoods) {
                            int cal = foodCalories.get(f);
                            System.out.println("- " + f + " : " + cal + " kalori");
                            total += cal;
                        }
                        System.out.println("Total kalori hari ini: " + total + " kalori");
                    }
                    break;

                case 3:
                    if (eatenFoods.isEmpty()) {
                        System.out.println("Belum ada makanan yang dimakan.");
                    } else {
                        System.out.println("Makanan yang dimakan hari ini:");
                        for (int i = 0; i < eatenFoods.size(); i++) {
                            System.out.println((i + 1) + ". " + eatenFoods.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih! Tetap jaga pola makan sehat :)");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 4);

        input.close();
    }
}
