package proj;

import java.util.ArrayList;

import com.ireasoning.protocol.*;
import com.ireasoning.protocol.snmp.*;
import com.ireasoning.util.ParseArguments;

/**
 * This class demonstrates polling agent (using SNMP GET_NEXT request) periodically.
 * <pre>
 * Example: 
 * java snmppoll -i 5 localhost .1.3.6.1.2.1.1.1.0 .1.3.6.1.2.1.1.3
 * </pre>
 */ 


public abstract class snmppoll extends snmp
{
    static int _interval = 3;//10 seconds;
    SnmpPoller _poller = null;
    Listener listener = null;

    protected ArrayList<String> keys = null;
    protected ArrayList<String> prev_keys = null;
    protected ArrayList<Object> values = null;
        
    public void removeListener() {
    	_poller.removeListener(listener);
    }
    
    public void doIt(String hostName, int port, String communityValue, int version)
    {
    	System.out.println(hostName +" "+ port+" "+ communityValue+" "+ version);
        try
        {
            SnmpSession session = new SnmpSession(hostName, port, communityValue, communityValue, version);
            if(_isSnmpV3)
            {
                session.setV3Params(_user, _authProtocol, _authPassword, _privProtocol, _privPassword, _context, null);
            }
            
            _poller = new SnmpPoller(session);
            listener = new Listener() {
				@Override
				public void handleMsg(Object sender, Msg msg) {

			    	prev_keys = keys;
					if (msg.getType() != Msg.ERROR_TYPE) {
						SnmpPdu pdu = (SnmpPdu)msg;	
						SnmpVarBind[] binds = pdu.getVarBinds();
						keys = new ArrayList<>();
						
						for (int j = 0; j < binds.length; j++) {
							keys.add(binds[j].getValue().toString());
						}
					}
			    	System.out.println(sender);
			    	for(Object o : keys) {
			    		System.out.println(o);
			    	}
				}
			};
			_poller.addListener(listener);
            _poller.snmpGetPoll(_oids, _interval);

        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }

   
}