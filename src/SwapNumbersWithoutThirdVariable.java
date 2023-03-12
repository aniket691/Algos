public class SwapNumbersWithoutThirdVariable {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        System.out.println("Original values:");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("Swapped values:");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        char[] c ={'a','n'};
        String s ="";
        s+=c[0];
        s+=c[1];



    }
}