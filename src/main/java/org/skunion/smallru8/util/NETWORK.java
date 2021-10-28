package org.skunion.smallru8.util;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class NETWORK {

	public static boolean portisAvailable(int port) {
	    ServerSocket ss = null;
	    DatagramSocket ds = null;
	    try {
	        ss = new ServerSocket(port);
	        ss.setReuseAddress(true);
	        ss.close();
	        ds = new DatagramSocket(port);
	        ds.setReuseAddress(true);
	        ds.close();
	        return true;
	    } catch (IOException e) {
	    } finally {
	        if (ds != null) {
	            ds.close();
	        }
	        if (ss != null) {
	            try {
	                ss.close();
	            } catch (IOException e) {
	                /* should not be thrown */
	            }
	        }
	    }
	    return false;
	}
	
}
