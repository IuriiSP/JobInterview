package JobInterview;

import java.net.InetAddress;

public class Services {

    public static long ipToLong(InetAddress ip){
        byte[]octets = ip.getAddress();

        long result = 0;

        for (byte octet : octets){
            result <<= 8;
            result |= octet & 255;
        }
        return result;
    }

    public static String longToIp(long ip){
        long[] b = new long[4];
        int k = 24;
        String result = "";

        for (int i = 0; i < 4; i++, k-=8){
            b[i] = ip >> k;
            ip -= b[i] << k;
            result += b[i];
            if (i < 3) result += ".";
        }
        return result;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkIP(String ip){
        boolean result = true;

        if (!(ip.contains("."))) {
            result = false;
        } else {
            for (String c : ip.split("\\.")){
                if (!(isDigit(c))) {
                    result = false;
                    break;
                }
            }

        }

        return result;
    }

}