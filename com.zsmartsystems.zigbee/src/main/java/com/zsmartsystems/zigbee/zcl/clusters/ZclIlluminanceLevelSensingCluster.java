package com.zsmartsystems.zigbee.zcl.clusters;

import com.zsmartsystems.zigbee.CommandResult;
import com.zsmartsystems.zigbee.ZigBeeDeviceAddress;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.zcl.ZclAttribute;
import com.zsmartsystems.zigbee.zcl.ZclCluster;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * <b>Illuminance level sensing</b> cluster implementation (<i>Cluster ID 0x0401</i>).
 * <p>
 * The cluster provides an interface to illuminance level sensing functionality,
 * including configuration and provision of notifications of whether the illuminance
 * is within, above or below a target band.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ZclIlluminanceLevelSensingCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0401;

    // Cluster Name
    public static final String CLUSTER_NAME = "Illuminance level sensing";

    // Attribute constants
    public static final int ATTR_LEVELSTATUS = 0x0000;
    public static final int ATTR_LIGHTSENSORTYPE = 0x0001;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(2);

        attributeMap.put(ATTR_LEVELSTATUS, new ZclAttribute(0, "LevelStatus", ZclDataType.ENUMERATION_8_BIT, true, true, false, true));
        attributeMap.put(ATTR_LIGHTSENSORTYPE, new ZclAttribute(1, "LightSensorType", ZclDataType.ENUMERATION_8_BIT, false, true, false, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclIlluminanceLevelSensingCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }


    /**
     * Get the <i>LevelStatus</i> attribute [attribute ID <b>0</b>].
     * <p>
     * The LevelStatus attribute indicates whether the measured illuminance is above,
     * below, or within a band around IlluminanceTargetLevel .
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLevelStatusAsync() {
        return read(attributes.get(ATTR_LEVELSTATUS));
    }


    /**
     * Synchronously get the <i>LevelStatus</i> attribute [attribute ID <b>0</b>].
     * <p>
     * The LevelStatus attribute indicates whether the measured illuminance is above,
     * below, or within a band around IlluminanceTargetLevel .
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getLevelStatus(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_LEVELSTATUS).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_LEVELSTATUS).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_LEVELSTATUS).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_LEVELSTATUS));
    }


    /**
     * Set reporting for the <i>LevelStatus</i> attribute [attribute ID <b>0</b>].
     * <p>
     * The LevelStatus attribute indicates whether the measured illuminance is above,
     * below, or within a band around IlluminanceTargetLevel .
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setLevelStatusReporting(final int minInterval, final int maxInterval) {
        return setReporting(attributes.get(ATTR_LEVELSTATUS), minInterval, maxInterval);
    }

    /**
     * Get the <i>LightSensorType</i> attribute [attribute ID <b>1</b>].
     * <p>
     * The LightSensorType attribute specifies the electronic type of the light sensor.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLightSensorTypeAsync() {
        return read(attributes.get(ATTR_LIGHTSENSORTYPE));
    }


    /**
     * Synchronously get the <i>LightSensorType</i> attribute [attribute ID <b>1</b>].
     * <p>
     * The LightSensorType attribute specifies the electronic type of the light sensor.
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getLightSensorType(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_LIGHTSENSORTYPE).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_LIGHTSENSORTYPE).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_LIGHTSENSORTYPE).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_LIGHTSENSORTYPE));
    }

    /**
     * Add a binding for this cluster to the local node
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> bind() {
        return bind();
    }
}
