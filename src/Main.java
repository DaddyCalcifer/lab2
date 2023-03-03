import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        double x, e;
        int n;
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("Введите X (Число для расчёта): ");
            x = sc.nextDouble();
            if(x >= 1)
            {
                System.out.println("Некорректный ввод!");
                return;
            }
            System.out.print("Введите N (Количество повторений): ");
            n = sc.nextInt();
            System.out.print("Введите E (Точность расчёта): ");
            e = sc.nextDouble();
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Некорректный ввод!");
            return;
        }
        System.out.println("1.) Расчёт N слагаемых: " + CalculateLn(x, n, 0));
        System.out.println("2.) Расчёт при точности E: " + CalculateLn(x, n, e));
        System.out.println("3.) Расчёт при точности (E/10): " + CalculateLn(x, n, e/10));
        System.out.println("4.) Расчёт при помощи Math: " + Math.log(1-x));

        System.out.println("\n1.) Расчёт N слагаемых: " + CalculateLn2(x, n, 0));
        System.out.println("2.) Расчёт при точности E: " + CalculateLn2(x, n, e));
        System.out.println("3.) Расчёт при точности (E/10): " + CalculateLn2(x, n, e/10));
        System.out.println("4.) Расчёт при помощи Math: " + Math.log(1+x));
    }
    static double CalculateLn(double x, double n, double e)
    {
        double sum =0;
        for (int i = 1; i <= n; i++)
        {
            double s = Math.pow(x, i) /i;
            if(s > e) sum-=s;
        }
        return sum;
    }
    static double CalculateLn2(double x, double n, double e)
    {
        double sum =0;
        for (int i = 1; i <= n; i++)
        {
            double s = Math.pow(x, i) /i;
            if(s > e && (i % 2)==1) sum-=s;
            if(s > e && (i % 2)==0) sum+=s;
        }
        return Math.abs(sum);
    }

}