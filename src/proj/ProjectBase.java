package proj;

import com.ireasoning.protocol.Msg;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.ThreadFactory;

import com.ireasoning.protocol.*;
import com.ireasoning.protocol.snmp.*;
import com.ireasoning.util.ParseArguments;

public class ProjectBase extends snmppoll implements Runnable{
	private static SnmpOID oid = new SnmpOID(".1.3.6.1.4.1.9.9.48.1.1.1.2.1");
	private SnmpTarget target = null;
	private SnmpSession session = null;
	
	
	private void setHost(String s) {
		_host = s;
	}
	
	public ProjectBase() {
		try {
			SnmpSession.loadMib("src/CISCO-SMI.mib");
			SnmpSession.loadMib("src/CISCO-MEMORY-POOL-MIB");
			SnmpSession.loadMib("src/CISCO-PROCESS-MIB");
			if(_host == null)setHost("192.168.10.1");
		}
		catch(IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println("??");
			doIt(_host, _port, _community, _version);
			System.out.println("proso");
			try{
				Thread.sleep(10000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("-------------------------------PRINTING KEYS_-------------------------");
			printKeys();
			System.out.println();
			removeListener();
			System.out.println("Input new host");
			String str= (new Scanner(System.in)).nextLine(); 
			System.out.print("You have entered: "+str);
			setHost(str);
		}
	}
	
	void printKeys() {
		for(Object o : prev_keys) {
			System.out.println(o);
		}
		for(Object o : keys) {
			System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		ProjectBase p = new ProjectBase();
		Thread t = new Thread(p);	
		t.start();
	}

	
}
