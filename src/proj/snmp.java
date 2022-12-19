package proj;

import java.io.*;
import java.util.*;

import com.ireasoning.protocol.Session;
import com.ireasoning.protocol.snmp.*;
import com.ireasoning.util.ParseArguments;

/**
 * This class is the base class of snmp command line programs. It provides
 * useful functionality such as parsing command line arguments, prints out
 * PDU data, etc.
 * <br>
 * Note: MIB-II is preloaded.
 */
public abstract class snmp 
{
    protected ParseArguments _parseArgs;
    
    protected int         _port = 161;
    protected int         _version = 1;
    protected String 	  _host = null;
    protected String[]      _hosts = new String[]{
    		"192.168.10.1",
    		"192.168.20.1",
    		"192.168.30.1"
    };
    protected String      _authProtocol;
    protected String      _authPassword;
    protected int         _privProtocol = SnmpConst.DES;
    protected String      _privPassword;
    protected String      _community = "si2019";
    protected String      _user;
    protected String      _context;
    protected String[]    _Properties = new String[] {
    		"cpmCPUTotal5sec",
    		"cpmCPUTotal1min",
    		"cpmCPUTotal5min",
    		"ciscoMemoryPoolName.1",
    		"ciscoMemoryPoolName.2",
    		"ciscoMemoryPoolUsed.1",
    		"ciscoMemoryPoolUsed.2",
    		"ciscoMemoryPoolFree.1",
    		"ciscoMemoryPoolFree.2"
    };
    protected String[]    _oids = new String[] {
    		".1.3.6.1.4.1.9.9.109.1.1.1.1.3.1", //cpmCPUTotal5sec
    		".1.3.6.1.4.1.9.9.109.1.1.1.1.4.1", //cpmCPUTotal1min
    		".1.3.6.1.4.1.9.9.109.1.1.1.1.5.1", //cpmCPUTotal5min
    		".1.3.6.1.4.1.9.9.48.1.1.1.2.1", //ciscoMemoryPoolName
    		".1.3.6.1.4.1.9.9.48.1.1.1.2.2",
    		//".1.3.6.1.4.1.9.9.48.1.1.1.3.1", //ciscoMemoryPoolValid
    		//".1.3.6.1.4.1.9.9.48.1.1.1.3.2",
    		".1.3.6.1.4.1.9.9.48.1.1.1.5.1", //ciscoMemoryPoolUsed 
    		".1.3.6.1.4.1.9.9.48.1.1.1.5.2",
    		".1.3.6.1.4.1.9.9.48.1.1.1.6.1", //ciscoMemoryPoolFree 
    		".1.3.6.1.4.1.9.9.48.1.1.1.6.2"
    };
    protected String 	  _sysNameOid = ".1.3.6.1.2.1.1.5.0";
    protected boolean     _isSnmpV3;
    protected boolean     _numericalOID = false;
    protected String[]    _mibFiles;
    protected String      _mibString;
    protected int         _transportLayer;
    
    
    
    protected void printOptions()
    {
        System.out.println( "Options:");
        System.out.println( "_____________________________________");
        System.out.println( "host =\t\t\t" + _hosts[0]);
        System.out.println( "port =\t\t\t" + _port);
        System.out.println( "isSnmpV3 =\t\t" + _isSnmpV3);
        System.out.println( "authProtocol =\t\t" + _authProtocol);
        System.out.println( "authPassword =\t\t" + _authPassword);
        System.out.println( "privProtocol =\t\t" + _privProtocol);
        System.out.println( "privPassword =\t\t" + _privPassword);
        System.out.println( "community =\t\t" + _community);
        System.out.println( "user =\t\t\t" + _user);
        System.out.println( "mib files =\t\t" + _mibString);
        System.out.println( "_____________________________________");
    }


}