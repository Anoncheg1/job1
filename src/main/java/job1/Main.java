package job1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<String> getListFromRange(String ip1, String ip2) { //117.211.141.234
	    String[] seg1 = ip1.split("\\.");    //split into 4 segments
	    String[] seg2 = ip2.split("\\.");    //split into 4 segments
	    int seg1Lower;
	    int seg1Upper;
	    int seg2Lower;
	    int seg2Upper;
	    int seg3Lower;
	    int seg3Upper;
	    int seg4Lower;
	    int seg4Upper;

	    
	    // get lower and upper bound of 1st segment
	    seg1Lower = Integer.parseInt(seg1[0]);
        seg1Upper = Integer.parseInt(seg2[0]);

	    // get lower and upper bound of 2nd segment
        seg2Lower = Integer.parseInt(seg1[1]);
        seg2Upper = Integer.parseInt(seg2[1]);

	    // get lower and upper bound of 3rd segment
        seg3Lower = Integer.parseInt(seg1[2]);
        seg3Upper = Integer.parseInt(seg2[2]);

	    // get lower and upper bound of 4th segment
        seg4Lower = Integer.parseInt(seg1[3]);
        seg4Upper = Integer.parseInt(seg2[3]);

	    //generate all IPs
        int seg2Upper2 = seg2Upper;
        int seg3Upper2 = seg3Upper;
        int seg4Upper2 = seg4Upper;
        
	    List<String> IPs = new ArrayList<>();
	    if (seg1Lower != seg1Upper)
    		seg2Upper2 = 255;
	    if (seg2Lower != seg2Upper)
	    	seg3Upper2 = 255;
	    if (seg3Lower != seg3Upper)
	    	seg4Upper2 = 255;
	    for (int i = seg1Lower; i <= seg1Upper; i++) {
	    	if (i == seg1Upper)
	    		seg2Upper2 = seg2Upper;
	        for (int j = seg2Lower; j <= seg2Upper2; j++) {
	        	if (j == seg2Upper)
		    		seg3Upper2 = seg3Upper;
	            for (int k = seg3Lower; k <= seg3Upper2; k++) {
	            	if (k == seg3Upper2)
	            		seg4Upper2 = seg4Upper; 
	                for (int l = seg4Lower; l <= seg4Upper2; l++) {
	                    IPs.add(i + "." + j + "." + k + "." + l);
	                }
	            }
	        }
	    }

	    return IPs;
	} 
	
    private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public static void main(String[] args) {
    	
    	System.out.print("Enter IP (e.g. 192.168.0.1) : ");

    	String ip1 = System.console().readLine();
    	String ip2;

    	if (ip1.matches(IPADDRESS_PATTERN)) {
    		System.out.print("Enter IP again:");
    		ip2 = System.console().readLine();
    		if (ip2.matches(IPADDRESS_PATTERN)) {

    			List<String> IPs = getListFromRange(ip1, ip2);
    			for (String IP : IPs) 
    				System.out.println(IP);
    			
    			System.exit(0);
    		}
    	}
		System.out.println("not IP. exit.");
    }
}