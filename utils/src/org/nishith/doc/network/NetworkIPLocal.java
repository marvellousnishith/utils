package org.nishith.doc.network;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class finds the IP address of the local machine and also provide extra
 * information of the local machine as well.
 *
 * @author Nisheeth Shah
 */
public class NetworkIPLocal {

    /**
     * This method gives information of the local machine
     *
     * @return
     */
    public static Map<String, String> getLocalIPInfo() {
        InetAddress addr = null;
        Map<String, String> map = new HashMap<String, String>();
        NetworkInterface network = null;
        try {
            addr = InetAddress.getLocalHost();
            network = NetworkInterface.getByInetAddress(addr);
            map.put("ip", addr.getHostAddress());
            map.put("hostname", addr.getCanonicalHostName());
            map.put("computername", addr.getHostName());
            map.put("nicname", network.getDisplayName());
            map.put("interfacename", network.getName());
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            map.put("MAC", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static List<InetAddress> getAllLANIP() {
        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface cur = interfaces.nextElement();
                if (cur.isLoopback()) {
                    continue;
                }
                System.out.println("Interface :: " + cur.getName() + "(" + cur.getDisplayName() + ")");
                for (InterfaceAddress iaddr : cur.getInterfaceAddresses()) {
                    InetAddress addr = iaddr.getAddress();
                    if (!(addr instanceof Inet4Address)) {
                        continue;
                    }
                    System.out.println("\tAddress :: " + addr.getHostAddress() + " :: " + addr.getHostName());
                    System.out.println("Broadcast Address :: " + iaddr.getBroadcast().getHostAddress());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

}
