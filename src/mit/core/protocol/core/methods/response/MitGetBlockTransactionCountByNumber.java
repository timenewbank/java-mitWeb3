package mit.core.protocol.core.methods.response;

import java.math.BigInteger;

import mit.core.protocol.core.Response;
import mit.utils.Numeric;

/**
 * eth_getBlockTransactionCountByNumber.
 */
public class MitGetBlockTransactionCountByNumber extends Response<String> {
    public BigInteger getTransactionCount() {
        return Numeric.decodeQuantity(getResult());
    }
}
