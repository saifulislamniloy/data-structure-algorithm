package bit_manipulation;

class BitManipulation {
    // Set a bit (turn ON) at 'pos'
    public static int setBit(int num, int pos) {
        return num | (1 << pos);
    }

    // Clear a bit (turn OFF) at 'pos'
    public static int clearBit(int num, int pos) {
        return num & ~(1 << pos);
    }

    // Toggle a bit (flip between 0 and 1) at 'pos'
    public static int toggleBit(int num, int pos) {
        return num ^ (1 << pos);
    }

    // Check if a bit is set (returns true if bit at 'pos' is 1)
    public static boolean isBitSet(int num, int pos) {
        return (num & (1 << pos)) != 0;
    }

    // Count the number of set bits (1s) in 'num'
    public static int countSetBits(int num) {
        return Integer.bitCount(num);
    }

    // Brian Kernighan’s Algorithm
    // The number of iterations is equal to the number of set bits (1s), making it faster than iterating through all 32 bits.
    public static int countSetBits2(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1); // Clears the rightmost set bit
            count++;
        }
        return count;
    }

    // number of iteration is 32
    public static int countSetBits3(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1); // Add 1 if LSB is 1
            num >>= 1;          // Right shift to check the next bit
        }
        return count;
    }

    // Clear the lowest set bit (turns off the lowest 1)
    public static int clearLowestSetBit(int num) {
        return num & (num - 1);
    }

    // Check if a number is a power of 2 (only one bit set)
    public static boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    // Generate all subsets using bitmasking for a set of size n
    public static void generateSubsets(int n) {
        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("Subset: { ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("}");
        }
    }

    // Reverse the bits of a 32-bit integer
    public static int reverseBits(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (num & 1);
            num >>= 1;
        }
        return result;
    }

    // Check if two numbers have opposite signs
    public static boolean hasOppositeSigns(int a, int b) {
        return (a ^ b) < 0;
    }

    // Swap two numbers without using extra space
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Swapped: a = " + a + ", b = " + b);
    }

    // Turn off the rightmost 1-bit
    public static int turnOffRightmostOne(int num) {
        return num & (num - 1);
    }

    // Main method to test bitmask operations
    public static void main(String[] args) {
        int num = 42; // Binary: 101010
        int pos = 1;

        System.out.println("Original number: " + Integer.toBinaryString(num));
        System.out.println("Set bit at position " + pos + ": " + Integer.toBinaryString(setBit(num, pos)));
        System.out.println("Clear bit at position " + pos + ": " + Integer.toBinaryString(clearBit(num, pos)));
        System.out.println("Toggle bit at position " + pos + ": " + Integer.toBinaryString(toggleBit(num, pos)));
        System.out.println("Is bit at position " + pos + " set? " + isBitSet(num, pos));
        System.out.println("Count of set bits: " + countSetBits(num));
        System.out.println("Clear lowest set bit: " + Integer.toBinaryString(clearLowestSetBit(num)));
        System.out.println("Is " + num + " a power of two? " + isPowerOfTwo(num));

        System.out.println("\nGenerating subsets for n=3:");
        generateSubsets(3);
        System.out.println("Reverse bits: " + reverseBits(num)); // Output: Reversed integer
        System.out.println("Do -5 and 3 have opposite signs? " + hasOppositeSigns(-5, 3)); // Output: true
        swap(5, 10); // Output: a = 10, b = 5
        System.out.println("Turn off rightmost 1-bit: " + turnOffRightmostOne(num)); // Output: 16
    }
}
