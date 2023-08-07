import java.util.Arrays;
import java.util.Date;
import java.awt.*;
import java.text.NumberFormat;

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

        // Constants
        // Final keyword to make variable immutable
        // Capital letters for constants

        final float PI = 3.14f;
        System.out.println(PI);

        // Arithmetic Expressions

        int result = 10 + 3;
        float res = 10f / 3f;
        System.out.println(result);
        System.out.println(res);

        // Decremental/Incremental Operator
        int x = 1;
        x++;
        System.out.println(x);

        // Augmented Operators
        int y = 2;
        y -= 2;
        System.out.println(y);

        // Casting
        
        // Implicit
        // In this case, Java will cast the short (2 bytes) variable to an int (4 bytes)
        // anonymously in memory and then perform the operation
        // No data loss
        // byte > short > int > long > float > double

        short first = 3;
        int second = first + 3;
        System.out.println(second);

        // Explicit
        // No longer need the values after the decimal point in the double

        double a = 10.33;
        int b = (int)a + 3;
        System.out.println(b);

        // Wrapper classes for converting String to Float, Int, Double, Short, Long, Byte
        // java.lang

        String c = "123";
        Integer.parseInt(c);
        System.out.println(c);

        // The Math class
        int r = Math.round(1.1F);
        System.out.println(r);

        System.out.println(Math.ceil(1.1F));
        
        // Random number 0-100
        int number = (int) (Math.random() * 100);
        System.out.println(number);

        // Formatting Numbers
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String re = currency.format(1234567.891);
        System.out.println(re);

        System.out.println("Hello");
    }
}
