import java.util.Arrays;
import java.util.Date;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        // (type) (identifier) (assignment operator) (value)
        
        // Primitive Types
        
        // |     Type     | Bytes |      Range
        // |     byte     |   1   |   [-128, 127]
        // |     short    |   2   |   [-32K, 32k]    
        // |     int      |   4   |    [-2B, 2B]
        // |     long     |   8   |
        // |     float    |   4   |
        // |     double   |   8   |
        // |     char     |   1   |    A, B, C
        // |     boolean  |   1   |   true/false
        
        // camelCase for variable names and meaningful names
        
        byte age = 30;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = false;
        age = 35;

        System.out.println(viewsCount);
        System.out.println(age);
        System.out.println(price);
        System.out.println(letter);
        System.out.println(isEligible);

        // Reference Types

        // Need to allocate memory with "new" operator
        // Reference types reference memory location

        Date now = new Date();
        System.out.println(now);

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

        // Strings
        // Reference types in Java
        // Immutable!!

        String message = "Hello World" + "!!";

        System.out.println(message.length());
        System.out.println(message.indexOf("W"));
        System.out.println(message.toLowerCase());
        System.out.println(message.trim());

        // Escape Sequences in Strings
        String quoteMessage = "Hello \"World\"";
        String newLineMessage = "Hello \n World";
        System.out.println(quoteMessage);
        System.out.println(newLineMessage);


        // Arrays

        int[] arr = new int[5];
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));

        int[] numbers = { 2, 3, 4, 1, 5 };
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // Multi-Dimensional Array
        
        int[][] nums = new int[2][3];
        nums[0][0] = 1;
        System.out.println(Arrays.deepToString(nums));


    }
}
