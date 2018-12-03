package mit.core.protocol.core.methods.response;

import java.math.BigInteger;

import mit.core.protocol.core.Response;
import mit.utils.Numeric;

/**
 * eth_blockNumber.
 */
public class MitBlockNumber extends Response<String> {
    public BigInteger getBlockNumber() {
        return Numeric.decodeQuantity(getResult());
    }
}
