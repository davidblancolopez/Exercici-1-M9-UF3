
package exercici.pkg1.m9.uf3;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;


public class Exercici1M9UF3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            System.out.println("------------------");
            while (interfaces.hasMoreElements()) {
                NetworkInterface interfaz = interfaces.nextElement();
                System.out.println("Interfaz: " + interfaz.getDisplayName());
                Enumeration<InetAddress> direccion = interfaz.getInetAddresses();
                while (direccion.hasMoreElements()) {
                    InetAddress ip = direccion.nextElement();
                    System.out.println(ip.getHostAddress());
                }
                System.out.println("------------------");
            }
        } catch(SocketException e) {
            System.out.println(e);
        }
    }
    
}
