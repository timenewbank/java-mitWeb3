package mit.core.protocol.core.methods.response;

import java.math.BigInteger;

import mit.core.protocol.core.Response;
import mit.utils.Numeric;

/**
 * eth_estimateGas.
 */
public class MitEstimateGas extends Response<String> {
    public BigInteger getAmountUsed() {
        return Numeric.decodeQuantity(getResult());
    }
}
