package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_mining.
 */
public class MitMining extends Response<Boolean> {
    public boolean isMining() {
        return getResult();
    }
}
