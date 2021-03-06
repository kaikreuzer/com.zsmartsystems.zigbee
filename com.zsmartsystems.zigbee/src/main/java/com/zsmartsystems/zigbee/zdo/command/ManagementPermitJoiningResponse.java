package com.zsmartsystems.zigbee.zdo.command;

import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zdo.ZdoResponse;
import com.zsmartsystems.zigbee.zdo.ZdoStatus;

/**
 * Management Permit Joining Response value object class.
 * <p>
 * The Mgmt_Permit_Joining_rsp is generated in response to a unicast
 * Mgmt_Permit_Joining_req. In the description which follows, note that no
 * response shall be sent if the Mgmt_Permit_Joining_req was received as a
 * broadcast to all routers. If this management command is not permitted by the
 * requesting device, a status of INVALID_REQUEST shall be returned. Upon
 * receipt and after support for Mgmt_Permit_Joining_req has been verified, the
 * Remote Device shall execute the NLME-PERMIT-JOINING.request. The
 * Mgmt_Permit-Joining_rsp shall contain the same status that was contained in the
 * NLME-PERMIT-JOINING.confirm primitive.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ManagementPermitJoiningResponse extends ZdoResponse {
    /**
     * Default constructor.
     */
    public ManagementPermitJoiningResponse() {
        clusterId = 0x8036;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(status, ZclDataType.ZDO_STATUS);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        status = (ZdoStatus) deserializer.deserialize(ZclDataType.ZDO_STATUS);
        if (status != ZdoStatus.SUCCESS) {
            // Don't read the full response if we have an error
            return;
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ManagementPermitJoiningResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }

}
