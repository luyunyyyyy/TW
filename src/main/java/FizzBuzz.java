import java.util.ArrayList;

public class FizzBuzz {
    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int num : nums) {
            StringBuilder stringBuilder = new StringBuilder();
            if (num % 3 == 0) {
                stringBuilder.append("Fizz");
            }
            if (num % 5 == 0) {
                stringBuilder.append("Buzz");
            }
            if (stringBuilder.length() == 0) {
                stringBuilder.append(num);
            }
            arrayList.add(stringBuilder.toString());
        }
        System.out.println(String.join(",", arrayList));
    }
}
