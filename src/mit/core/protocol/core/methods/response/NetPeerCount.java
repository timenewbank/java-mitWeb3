package mit.core.protocol.core.methods.response;

import java.math.BigInteger;

import mit.core.protocol.core.Response;
import mit.utils.Numeric;

/**
 * net_peerCount.
 */
public class NetPeerCount extends Response<String> {

    public BigInteger getQuantity() {
        return Numeric.decodeQuantity(getResult());
    }
}
