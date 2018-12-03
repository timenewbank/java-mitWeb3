package mit.core.protocol.core.filters;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import mit.core.protocol.Web3j;
import mit.core.protocol.core.Request;
import mit.core.protocol.core.methods.response.MitFilter;
import mit.core.protocol.core.methods.response.MitLog;

/**
 * Handler for working with block filter requests.
 */
public class BlockFilter extends Filter<String> {

    public BlockFilter(Web3j web3j, Callback<String> callback) {
        super(web3j, callback);
    }

    @Override
    MitFilter sendRequest() throws IOException {
        return web3j.mitNewBlockFilter().send();
    }

    @Override
    void process(List<MitLog.LogResult> logResults) {
        for (MitLog.LogResult logResult : logResults) {
            if (logResult instanceof MitLog.Hash) {
                String blockHash = ((MitLog.Hash) logResult).get();
                callback.onEvent(blockHash);
            } else {
                throw new FilterException(
                        "Unexpected result type: " + logResult.get() + ", required Hash");
            }
        }
    }

    /**
     * Since the block filter does not support historic filters, the filterId is ignored
     * and an empty optional is returned.
     * @param filterId
     * Id of the filter for which the historic log should be retrieved
     * @return
     * Optional.empty()
     */
    @Override
    protected Optional<Request<?, MitLog>> getFilterLogs(BigInteger filterId) {
        return Optional.empty();
    }
}

