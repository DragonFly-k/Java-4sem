import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class InternetConnection {
    InetAddress currentIP=null;
    public InternetConnection() {
        try {
            currentIP = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + currentIP.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getIP(){
        return currentIP.getHostAddress();
    }

    public void getByName(String name){
        try {
            var ip = InetAddress.getByName(name);
            System.out.println("IP Address : " + ip.getHostAddress());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getByAddress(String address,byte[] ip){
        try {
            var pageIP = InetAddress.getByAddress(address, ip);
            System.out.println(pageIP.isReachable(200));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readHtml(String url){
        try {
            URL urll = new URL(url);
            InputStream input = urll.openStream();
            byte[] buffer = input.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        }
        catch(MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var connect = new InternetConnection();
        connect.getIP();
        connect.getByName("www.belstu.by");
        byte[] ip = {(byte) 127, (byte) 0, (byte) 0, (byte) 1};
        connect.getByAddress("zzz", ip);
        connect.readHtml("https://www.belstu.by");
    }
}
