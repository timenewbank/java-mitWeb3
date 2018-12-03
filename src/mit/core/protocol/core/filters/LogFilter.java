package mit.core.protocol.core.filters;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import mit.core.protocol.Web3j;
import mit.core.protocol.core.Request;
import mit.core.protocol.core.methods.response.MitFilter;
import mit.core.protocol.core.methods.response.MitLog;
import mit.core.protocol.core.methods.response.Log;

/**
 * Log filter handler.
 */
public class LogFilter extends Filter<Log> {

    private final mit.core.protocol.core.methods.request.EthFilter ethFilter;

    public LogFilter(
            Web3j web3j, Callback<Log> callback,
            mit.core.protocol.core.methods.request.EthFilter ethFilter) {
        super(web3j, callback);
        this.ethFilter = ethFilter;
    }


    @Override
    MitFilter sendRequest() throws IOException {
        return web3j.mitNewFilter(ethFilter).send();
    }

    @Override
    void process(List<MitLog.LogResult> logResults) {
        for (MitLog.LogResult logResult : logResults) {
            if (logResult instanceof MitLog.LogObject) {
                Log log = ((MitLog.LogObject) logResult).get();
                callback.onEvent(log);
            } else {
                throw new FilterException(
                        "Unexpected result type: " + logResult.get() + " required LogObject");
            }
        }
    }

    @Override
    protected Optional<Request<?, MitLog>> getFilterLogs(BigInteger filterId) {
        return Optional.of(web3j.mitGetFilterLogs(filterId));
    }
}
