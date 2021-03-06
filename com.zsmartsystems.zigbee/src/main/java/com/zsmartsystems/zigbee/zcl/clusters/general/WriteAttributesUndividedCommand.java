package com.zsmartsystems.zigbee.zcl.clusters.general;

import com.zsmartsystems.zigbee.zcl.ZclCommand;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

import java.util.List;
import com.zsmartsystems.zigbee.zcl.field.WriteAttributeRecord;

/**
 * Write Attributes Undivided Command value object class.
 * <p>
 * The write attributes undivided command is generated when a device wishes to
 * change the values of one or more attributes located on another device, in such a
 * way that if any attribute cannot be written (e.g. if an attribute is not implemented
 * on the device, or a value to be written is outside its valid range), no attribute
 * values are changed.
 * <br>
 * In all other respects, including generation of a write attributes response command,
 * the format and operation of the command is the same as that of the write attributes
 * command, except that the command identifier field shall be set to indicate the
 * write attributes undivided command.
 * <p>
 * Cluster: <b>General</b>. Command is sent <b>TO</b> the server.
 * This command is a <b>generic</b> command used across the profile.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class WriteAttributesUndividedCommand extends ZclCommand {
    /**
     * Records command message field.
     */
    private List<WriteAttributeRecord> records;

    /**
     * Default constructor.
     */
    public WriteAttributesUndividedCommand() {
        genericCommand = true;
        commandId = 3;
        commandDirection = true;
    }

    /**
     * Sets the cluster ID for <i>generic</i> commands. {@link WriteAttributesUndividedCommand} is a <i>generic</i> command.
     * <p>
     * For commands that are not <i>generic</i>, this method will do nothing as the cluster ID is fixed.
     * To test if a command is <i>generic</i>, use the {@link #isGenericCommand} method.
     *
     * @param clusterId the cluster ID used for <i>generic</i> commands as an {@link Integer}
     */
    @Override
    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * Gets Records.
     *
     * @return the Records
     */
    public List<WriteAttributeRecord> getRecords() {
        return records;
    }

    /**
     * Sets Records.
     *
     * @param records the Records
     */
    public void setRecords(final List<WriteAttributeRecord> records) {
        this.records = records;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(records, ZclDataType.N_X_WRITE_ATTRIBUTE_RECORD);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        records = (List<WriteAttributeRecord>) deserializer.deserialize(ZclDataType.N_X_WRITE_ATTRIBUTE_RECORD);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("WriteAttributesUndividedCommand [");
        builder.append(super.toString());
        builder.append(", records=");
        builder.append(records);
        builder.append("]");
        return builder.toString();
    }

}
