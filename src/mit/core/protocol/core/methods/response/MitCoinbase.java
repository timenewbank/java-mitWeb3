package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_coinbase.
 */
public class MitCoinbase extends Response<String> {
    public String getAddress() {
        return getResult();
    }
}
