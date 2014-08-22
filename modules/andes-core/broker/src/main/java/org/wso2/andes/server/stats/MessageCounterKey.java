package org.wso2.andes.server.stats;

/**
 * Created by Akalanka on 7/31/14.
 * This class is used as the key for the MessageCounter.
 * The key consist of (QueueName, MessageCounterType).
 * The class is immutable.
 */
public final class MessageCounterKey {

    /**
     * The message statuses that define MessageCounterKey.
     */
    public enum MessageCounterType {
        PUBLISH_COUNTER("Published"),
        DELIVER_COUNTER("Delivered"),
        ACKNOWLEDGED_COUNTER("Acknowledged");

        private final String value;

        private MessageCounterType(final String value) {
            this.value = value;
        }

        public String getType() {
            return value;
        }

    }

    private final String queueName;
    private final MessageCounterType messageCounterType;


    /**
     * The constructor to get the message counter key given the queue name and the message status.
     *
     * @param paramQueueName The queue name
     * @param paramMessageCounterType The message status.
     */
    public MessageCounterKey(String paramQueueName, MessageCounterType paramMessageCounterType) {
        this.queueName = paramQueueName;
        this.messageCounterType = paramMessageCounterType;
    }

    /**
     * Get the queue name from the message counter key.
     *
     * @return The queue name
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * Get the message counter type (message status) from the message counter key.
     *
     * @return The message counter type
     */
    public MessageCounterType getMessageCounterType() {
        return messageCounterType;
    }

    /**
     * The equals method to check for equality in two MessageCounterKeys'.
     * @param o The object to compare
     * @return Is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageCounterKey that = (MessageCounterKey) o;

        return messageCounterType == that.messageCounterType && queueName.equals(that.queueName);
    }

    /**
     * The hash code method to use since the MessageCounterkey will be used as java collection keys.
     * @return The hash code
     */
    @Override
    public int hashCode() {
        int result = queueName.hashCode();
        result = 31 * result + messageCounterType.hashCode();
        return result;
    }

}
