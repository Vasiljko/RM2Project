package proj;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.plaf.synth.SynthToggleButtonUI;

import com.ireasoning.protocol.snmp.*;


public class Proba {
	private static String host = "192.168.10.1";
	private static String readCommunity = "si2019";
	private static String writeCommunity = "si2019";
	private static int port = 161;
	private static int version = 1;
	
	//.1.3.6.1.2.1.11.1.0
	//private static SnmpOID oid = new SnmpOID(new int[] {1,3,6,1,2,1,11,1,0});
	
	//.1.3.6.1.4.1.9.9.109.1.1.1.3
	
	//private static SnmpOID oid = new SnmpOID(new int[] {1,3,6,1,4,1,9,9,109,1,1,1,1,3});
	
	//.1.3.6.1.4.1.9.9.48.1.1.1.2
	private static SnmpOID oid = new SnmpOID(".1.3.6.1.2.1.11.1.0");
	
	//.1.3.6.1.2.1.1.5.0 - sysName
	//private static SnmpOID oid = new SnmpOID(new int[] {1,3,6,1,2,1,1,5,0});
	
	//.1.3.6.1.2.1.1.5.0
	private static SnmpOID sysNameOid = new SnmpOID(new int[] {1,3,6,1,2,1,1,5,0});
	
	
	public Proba() {
		try {
			System.out.println(new File(".").getCanonicalPath());
			
			SnmpSession.loadMib("src/CISCO-SMI.mib");
			SnmpSession.loadMib("src/CISCO-MEMORY-POOL-MIB");
			SnmpSession.loadMib("src/CISCO-PROCESS-MIB");
			
			SnmpTarget target = new SnmpTarget(host, port,readCommunity, writeCommunity, version);
			
			SnmpSession session = new SnmpSession(target);
			
			System.out.println(session.snmpGetRequest(sysNameOid).getVarBind(0).getValue().toString());

			SnmpPdu retPdu = session.snmpGetRequest(oid);
			if(retPdu.hasMore())
	        {
	            SnmpVarBind[] varbinds = retPdu.getVarBinds();
	            for (int i = 0; i < varbinds.length ; i++) 
	            {
	            	System.out.println(varbinds[i]);
	            }
	        }
			else System.out.println(retPdu);
			session.close();
		}
		catch(IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Proba p = new Proba();
	}
	
	
}
