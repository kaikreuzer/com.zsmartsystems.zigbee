package com.zsmartsystems.zigbee.zcl.clusters;

import com.zsmartsystems.zigbee.ZigBeeDeviceAddress;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.zcl.ZclAttribute;
import com.zsmartsystems.zigbee.zcl.ZclCluster;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>BACnet Protocol Tunnel</b> cluster implementation (<i>Cluster ID 0x0601</i>).
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ZclBaCnetProtocolTunnelCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0601;

    // Cluster Name
    public static final String CLUSTER_NAME = "BACnet Protocol Tunnel";

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(0);


        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclBaCnetProtocolTunnelCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }

}
