package com.zsmartsystems.zigbee.zcl.clusters;

import com.zsmartsystems.zigbee.CommandResult;
import com.zsmartsystems.zigbee.ZigBeeDeviceAddress;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.zcl.ZclAttribute;
import com.zsmartsystems.zigbee.zcl.ZclCluster;
import com.zsmartsystems.zigbee.zcl.ZclCommand;
import com.zsmartsystems.zigbee.zcl.clusters.doorlock.LockDoorCommand;
import com.zsmartsystems.zigbee.zcl.clusters.doorlock.LockDoorResponse;
import com.zsmartsystems.zigbee.zcl.clusters.doorlock.UnlockDoorCommand;
import com.zsmartsystems.zigbee.zcl.clusters.doorlock.UnlockDoorResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * <b>Door Lock</b> cluster implementation (<i>Cluster ID 0x0101</i>).
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ZclDoorLockCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0101;

    // Cluster Name
    public static final String CLUSTER_NAME = "Door Lock";

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(0);


        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclDoorLockCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }


    /**
     * The Lock Door Command
     *
     * @param pinCode {@link String} Pin code
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> lockDoorCommand(String pinCode) {
        LockDoorCommand command = new LockDoorCommand();

        // Set the fields
        command.setPinCode(pinCode);

        return send(command);
    }

    /**
     * The Unlock Door Command
     *
     * @param pinCode {@link String} Pin code
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> unlockDoorCommand(String pinCode) {
        UnlockDoorCommand command = new UnlockDoorCommand();

        // Set the fields
        command.setPinCode(pinCode);

        return send(command);
    }

    /**
     * The Lock Door Response
     *
     * @param status {@link Integer} Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> lockDoorResponse(Integer status) {
        LockDoorResponse command = new LockDoorResponse();

        // Set the fields
        command.setStatus(status);

        return send(command);
    }

    /**
     * The Unlock Door Response
     *
     * @param status {@link Integer} Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> unlockDoorResponse(Integer status) {
        UnlockDoorResponse command = new UnlockDoorResponse();

        // Set the fields
        command.setStatus(status);

        return send(command);
    }

    @Override
    public ZclCommand getCommandFromId(int commandId) {
        switch (commandId) {
            case 0: // LOCK_DOOR_COMMAND
                return new LockDoorCommand();
            case 1: // UNLOCK_DOOR_COMMAND
                return new UnlockDoorCommand();
            default:
                return null;
        }
    }

    @Override
    public ZclCommand getResponseFromId(int commandId) {
        switch (commandId) {
            case 0: // LOCK_DOOR_RESPONSE
                return new LockDoorResponse();
            case 1: // UNLOCK_DOOR_RESPONSE
                return new UnlockDoorResponse();
            default:
                return null;
        }
    }
}
