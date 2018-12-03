package mit.core.protocol.core.methods.response;

import java.math.BigInteger;

import mit.core.protocol.core.Response;
import mit.utils.Numeric;

/**
 * eth_hashrate.
 */
public class MitHashrate extends Response<String> {
    public BigInteger getHashrate() {
        return Numeric.decodeQuantity(getResult());
    }
}
