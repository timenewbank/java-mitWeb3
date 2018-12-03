package mit.core.tx;

import java.io.IOException;
import java.math.BigInteger;

import mit.core.protocol.Web3j;
import mit.core.protocol.core.methods.request.Transaction;
import mit.core.protocol.core.methods.response.MitSendTransaction;
import mit.core.tx.response.TransactionReceiptProcessor;

/**
 * TransactionManager implementation for using an Ethereum node to transact.
 *
 * <p><b>Note</b>: accounts must be unlocked on the node for transactions to be successful.
 */
public class ClientTransactionManager extends TransactionManager {

    private final Web3j web3j;

    public ClientTransactionManager(
            Web3j web3j, String fromAddress) {
        super(web3j, fromAddress);
        this.web3j = web3j;
    }

    public ClientTransactionManager(
            Web3j web3j, String fromAddress, int attempts, int sleepDuration) {
        super(web3j, attempts, sleepDuration, fromAddress);
        this.web3j = web3j;
    }

    public ClientTransactionManager(
            Web3j web3j, String fromAddress,
            TransactionReceiptProcessor transactionReceiptProcessor) {
        super(transactionReceiptProcessor, fromAddress);
        this.web3j = web3j;
    }

    @Override
    public MitSendTransaction sendTransaction(
            BigInteger gasPrice, BigInteger gasLimit, String to,
            String data, BigInteger value)
            throws IOException {

        Transaction transaction = new Transaction(
                getFromAddress(), null, gasPrice, gasLimit, to, value, data);

        return web3j.mitSendTransaction(transaction)
                .send();
    }
}
