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
    }
}
