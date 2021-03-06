package com.zsmartsystems.zigbee.zdo.command;

import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zdo.ZdoResponse;
import com.zsmartsystems.zigbee.zdo.ZdoStatus;
import com.zsmartsystems.zigbee.zdo.descriptors.PowerDescriptor;

/**
 * Power Descriptor Response value object class.
 * <p>
 * The Power_Desc_rsp is generated by a remote device in response to a
 * Power_Desc_req directed to the remote device. This command shall be unicast to
 * the originator of the Power_Desc_req command.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class PowerDescriptorResponse extends ZdoResponse {
    /**
     * NWKAddrOfInterest command message field.
     */
    private Integer nwkAddrOfInterest;

    /**
     * PowerDescriptor command message field.
     */
    private PowerDescriptor powerDescriptor;

    /**
     * Default constructor.
     */
    public PowerDescriptorResponse() {
        clusterId = 0x8003;
    }

    /**
     * Gets NWKAddrOfInterest.
     *
     * @return the NWKAddrOfInterest
     */
    public Integer getNwkAddrOfInterest() {
        return nwkAddrOfInterest;
    }

    /**
     * Sets NWKAddrOfInterest.
     *
     * @param nwkAddrOfInterest the NWKAddrOfInterest
     */
    public void setNwkAddrOfInterest(final Integer nwkAddrOfInterest) {
        this.nwkAddrOfInterest = nwkAddrOfInterest;
    }

    /**
     * Gets PowerDescriptor.
     *
     * @return the PowerDescriptor
     */
    public PowerDescriptor getPowerDescriptor() {
        return powerDescriptor;
    }

    /**
     * Sets PowerDescriptor.
     *
     * @param powerDescriptor the PowerDescriptor
     */
    public void setPowerDescriptor(final PowerDescriptor powerDescriptor) {
        this.powerDescriptor = powerDescriptor;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(status, ZclDataType.ZDO_STATUS);
        serializer.serialize(nwkAddrOfInterest, ZclDataType.NWK_ADDRESS);
        serializer.serialize(powerDescriptor, ZclDataType.POWER_DESCRIPTOR);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        status = (ZdoStatus) deserializer.deserialize(ZclDataType.ZDO_STATUS);
        if (status != ZdoStatus.SUCCESS) {
            // Don't read the full response if we have an error
            return;
        }
        nwkAddrOfInterest = (Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS);
        powerDescriptor = (PowerDescriptor) deserializer.deserialize(ZclDataType.POWER_DESCRIPTOR);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PowerDescriptorResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append(", nwkAddrOfInterest=");
        builder.append(nwkAddrOfInterest);
        builder.append(", powerDescriptor=");
        builder.append(powerDescriptor);
        builder.append("]");
        return builder.toString();
    }

}
