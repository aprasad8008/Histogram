import java.util.Scanner;
import java.io.File;

public class Histogram
{
    public static void main(String[] args) throws Exception
    {
        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        Scanner scan2 = new Scanner(System.in);
        int[] grades = new int[101];

        while (scan.hasNext())
        {
            String[] temp = scan.nextLine().split(",");
            grades[Integer.parseInt(temp[1].trim())]++;
        }

        scan.close();
        int bins;
        if (args.length == 2)
        {
            bins = Integer.parseInt(args[1]);
        }
        else
        {
            System.out.println("How many bins would you like?");
            bins = scan2.nextInt();
        }

        scan2.close();

        int bins2 = bins;
        int range = 101 / bins;
        int num = 100;
        int endingNum = 100 - (range - 1);

        for (int h = 0; h < bins2; h++)
        {
            if (bins == 1)
            {
                endingNum = 0;
            }
            System.out.printf("%3d - %2d | ", num, endingNum);
            for (int i = endingNum; i <= num; i++)
            {
                for (int k = 0; k < grades[i]; k++)
                {
                    System.out.print("[]");
                }
            }
            System.out.println();
            bins--;
            num = num - range;
            endingNum = endingNum - range;
        }
    }
}
