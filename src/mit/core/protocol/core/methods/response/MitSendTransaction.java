package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_sendTransaction.
 */
public class MitSendTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}
