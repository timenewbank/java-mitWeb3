package mit.core.protocol.core.methods.response;

import java.math.BigInteger;

import mit.core.protocol.core.Response;
import mit.utils.Numeric;

/**
 * eth_getUncleCountByBlockHash.
 */
public class MitGetUncleCountByBlockHash extends Response<String> {
    public BigInteger getUncleCount() {
        return Numeric.decodeQuantity(getResult());
    }
}
