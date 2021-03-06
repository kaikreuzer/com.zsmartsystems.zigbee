package com.zsmartsystems.zigbee.zdo.command;

import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zdo.ZdoRequest;
import com.zsmartsystems.zigbee.Command;
import com.zsmartsystems.zigbee.CommandResponseMatcher;
import com.zsmartsystems.zigbee.zdo.command.SimpleDescriptorResponse;

/**
 * Simple Descriptor Request value object class.
 * <p>
 * The Simple_Desc_req command is generated from a local device wishing to
 * inquire as to the simple descriptor of a remote device on a specified endpoint. This
 * command shall be unicast either to the remote device itself or to an alternative
 * device that contains the discovery information of the remote device.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class SimpleDescriptorRequest extends ZdoRequest implements CommandResponseMatcher {
    /**
     * NWKAddrOfInterest command message field.
     */
    private Integer nwkAddrOfInterest;

    /**
     * Endpoint command message field.
     */
    private Integer endpoint;

    /**
     * Default constructor.
     */
    public SimpleDescriptorRequest() {
        clusterId = 0x0004;
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
     * Gets Endpoint.
     *
     * @return the Endpoint
     */
    public Integer getEndpoint() {
        return endpoint;
    }

    /**
     * Sets Endpoint.
     *
     * @param endpoint the Endpoint
     */
    public void setEndpoint(final Integer endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(nwkAddrOfInterest, ZclDataType.NWK_ADDRESS);
        serializer.serialize(endpoint, ZclDataType.UNSIGNED_8_BIT_INTEGER);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        nwkAddrOfInterest = (Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS);
        endpoint = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
    }

    @Override
    public boolean isMatch(Command request, Command response) {
        if (!(response instanceof SimpleDescriptorResponse)) {
            return false;
        }

        return (((SimpleDescriptorRequest) request).getDestinationAddress()
                .equals(((SimpleDescriptorResponse) response).getSourceAddress()))
                && (((SimpleDescriptorRequest) request).getEndpoint()
                .equals(((SimpleDescriptorResponse) response).getSimpleDescriptor().getEndpoint()));
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SimpleDescriptorRequest [");
        builder.append(super.toString());
        builder.append(", nwkAddrOfInterest=");
        builder.append(nwkAddrOfInterest);
        builder.append(", endpoint=");
        builder.append(endpoint);
        builder.append("]");
        return builder.toString();
    }

}
