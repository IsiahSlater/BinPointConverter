
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        //get a float from the user
        System.out.print("Please provide a decimal number: ");
        double decimal;
        Scanner input = new Scanner(System.in);
        decimal = input.nextDouble();

        int wholeDecimal = (int) decimal;
        decimal -= wholeDecimal;
        double binary = convertPoint(decimal);
        binary += (double)convertWhole(wholeDecimal);
        decimal += wholeDecimal;
        System.out.print(decimal + " in binary is " + binary);
    }

    public static double convertPoint(double decimal)
    {
        int pointPlace = -1;
        double binary = 0.0;
        double temp;
        //assume for now decimal is < 1
        while (decimal != 0)
        {
            decimal *= 2;
            if (decimal >= 1)
            {
                decimal--;
                temp = 1 * (Math.pow(10, pointPlace));
                binary += temp;
            }
            else
            {
                temp = 0 * (Math.pow(10, pointPlace));
                binary += temp;
            }
            pointPlace--;
        }
        return binary;
    }

    public static int convertWhole(int decimal)
    {
        //modulate number
        //if modulation == 1, add 1 to place, if == 0, add 0 to place
        int place = 0;
        int binary = 0;
        while (decimal != 0)
        {
            if (decimal % 2 == 1)
            {
                binary += 1 * (Math.pow(10, place));
            }
            else
            {
                binary += 0 * (Math.pow(10, place));
            }
            place++;
            decimal /= 2;
        }
        return binary;
    }
}
