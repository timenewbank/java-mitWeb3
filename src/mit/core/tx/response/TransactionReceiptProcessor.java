package mit.core.tx.response;

import java.io.IOException;
import java.util.Optional;

import mit.core.protocol.Web3j;
import mit.core.protocol.core.methods.response.MitGetTransactionReceipt;
import mit.core.protocol.core.methods.response.TransactionReceipt;
import mit.core.protocol.exceptions.TransactionException;

/**
 * Abstraction for managing how we wait for transaction receipts to be generated on the network.
 */
public abstract class TransactionReceiptProcessor {

    private final Web3j web3j;

    public TransactionReceiptProcessor(Web3j web3j) {
        this.web3j = web3j;
    }

    public abstract TransactionReceipt waitForTransactionReceipt(
            String transactionHash)
            throws IOException, TransactionException;

    Optional<TransactionReceipt> sendTransactionReceiptRequest(
            String transactionHash) throws IOException, TransactionException {
        MitGetTransactionReceipt transactionReceipt =
                web3j.mitGetTransactionReceipt(transactionHash).send();
        if (transactionReceipt.hasError()) {
            throw new TransactionException("Error processing request: "
                    + transactionReceipt.getError().getMessage());
        }

        return transactionReceipt.getTransactionReceipt();
    }
}
