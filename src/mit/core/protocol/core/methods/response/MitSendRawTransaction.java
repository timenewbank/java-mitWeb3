package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_sendRawTransaction.
 */
public class MitSendRawTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}
