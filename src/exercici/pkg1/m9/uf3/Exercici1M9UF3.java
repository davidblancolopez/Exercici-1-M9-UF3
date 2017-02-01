
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
        /*******************************************************************************************************************
         * *****************************************************************************************************************
         * *****************************************************************************************************************
         * *****************************************************************************************************************
         */
        
        System.out.println("**************************************************************************************************"
                + "************************************************************************************************************");
        
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            
            //Recolleix la MAC pero esta en un format que no es correcte perque no mostrara la informació
            //com cal.
            byte[] mac = network.getHardwareAddress();

            System.out.print("Direcció MAC : ");

            //Es crea una cadena on anirem posant la direcció MAC donant el format correcte a l'array mac. 
            StringBuilder cadenaDireccioMAC = new StringBuilder();
            
            //El bucle va afegint a la cadena la informació que recorre en l'array mac, aplica format amb "%02X%s"
            //i afegeix el '-' per a separar els numeros.
            for (int i = 0; i < mac.length; i++) {
                cadenaDireccioMAC.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            //S'imprimeix la cadena amb la MAC formatada.
            System.out.println(cadenaDireccioMAC.toString());

        } catch (SocketException e) {
            System.out.println(e);
        }
        
        
        
        /*******************************************************************************************************************
         * *****************************************************************************************************************
         * *****************************************************************************************************************
         * *****************************************************************************************************************
         */
        
        System.out.println("**************************************************************************************************"
                + "************************************************************************************************************");
        
        
        
    }
    
}
