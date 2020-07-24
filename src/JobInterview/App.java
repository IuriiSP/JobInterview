package JobInterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class App {

    public static void main(String[] args) throws UnknownHostException {
        String lowIP = "";
        String highIP = "";
        boolean check = false;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            do {
                System.out.println("Введите \"первый\" ip адрес");
                lowIP = reader.readLine();
                check = Services.checkIP(lowIP);
                if (check == false) System.out.println("Неверный формат");
            }

            while (!check);

            check = false;
            do {
                System.out.println("Введите \"второй\" ip адрес");
                highIP = reader.readLine();
                check = Services.checkIP(highIP);
                if (check == false) System.out.println("Неверный формат");
            }

            while (!check);

            long lesserIP = Services.ipToLong(InetAddress.getByName(lowIP));
            long largerIP = Services.ipToLong(InetAddress.getByName(highIP));

            long diff = Math.abs(largerIP - lesserIP);
            System.out.println("Адреса заданного диапазона: ");

            if (lesserIP < largerIP) {
                for (long i = 1; i < diff; i++)
                    System.out.println(Services.longToIp(lesserIP + i));
            } else if (lesserIP > largerIP) {
                for (long i = 1; i < diff; i++)
                    System.out.println(Services.longToIp(largerIP + i));
            }
            else if ((lesserIP == largerIP) || (diff == 1)) System.out.println("в данном диапазоне нет других адресов");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
