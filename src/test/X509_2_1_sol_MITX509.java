package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import mit.abi.EventEncoder;
import mit.abi.FunctionEncoder;
import mit.abi.TypeReference;
import mit.abi.datatypes.Address;
import mit.abi.datatypes.Bool;
import mit.abi.datatypes.DynamicArray;
import mit.abi.datatypes.Event;
import mit.abi.datatypes.Function;
import mit.abi.datatypes.Type;
import mit.abi.datatypes.Utf8String;
import mit.abi.datatypes.generated.Uint256;
import mit.crypto.Credentials;
import mit.core.protocol.Web3j;
import mit.core.protocol.core.DefaultBlockParameter;
import mit.core.protocol.core.RemoteCall;
import mit.core.protocol.core.methods.request.EthFilter;
import mit.core.protocol.core.methods.response.Log;
import mit.core.protocol.core.methods.response.TransactionReceipt;
import mit.tuples.generated.Tuple2;
import mit.core.tx.Contract;
import mit.core.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the mit.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class X509_2_1_sol_MITX509 extends Contract {
    private static final String BINARY = "608060405261271060005561c3506001556207a12060025569152d02c7e14af6800000600e553480156200003257600080fd5b5060405162001c0838038062001c08833981016040528051600a8054600160a060020a031916331790550180516200007290600b9060208401906200007a565b50506200011f565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620000bd57805160ff1916838001178555620000ed565b82800160010185558215620000ed579182015b82811115620000ed578251825591602001919060010190620000d0565b50620000fb929150620000ff565b5090565b6200011c91905b80821115620000fb576000815560010162000106565b90565b611ad9806200012f6000396000f30060806040526004361061017c5763ffffffff60e060020a60003504166303673f9f811461018157806306fdde03146101f357806308a4e9691461027d57806308bf738414610292578063095ea7b31461030157806318160ddd1461032757806321df64c01461033c57806323b872dd146103545780632e1a7d4d1461037e5780633ebf3f20146103965780634eabeb60146103ae57806355048fcf146103c657806355ce5ae5146103e75780636352211e146103ff5780636624f29f146104335780636a123795146104ca57806370a08231146104e25780638462151c14610503578063857d6b8d146105745780638da5cb5b1461058c57806393ae364d146105a157806395d89b41146105c55780639a52e101146105da578063a9059cbb146105f2578063b3b88d2d14610616578063c7da224c1461062e578063d2fb166c14610689578063d37219ec146106a1578063da6aef78146106b6578063e5f324cf146106ce578063e9d70b7f146106e6578063f2fde38b146106fb575b600080fd5b34801561018d57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101df95833595369560449491939091019190819084018382808284375094975061071c9650505050505050565b604080519115158252519081900360200190f35b3480156101ff57600080fd5b50610208610750565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561024257818101518382015260200161022a565b50505050905090810190601f16801561026f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561028957600080fd5b50610208610787565b6040805160206004803580820135601f81018490048402850184019095528484526102ef94369492936024939284019190819084018382808284375094975050508335600160a060020a0316945050506020909101359050610815565b60408051918252519081900360200190f35b34801561030d57600080fd5b50610325600160a060020a036004351660243561087e565b005b34801561033357600080fd5b506102ef6108e9565b34801561034857600080fd5b506101df6004356108f0565b34801561036057600080fd5b50610325600160a060020a0360043581169060243516604435610923565b34801561038a57600080fd5b506101df600435610988565b3480156103a257600080fd5b506102ef600435610a44565b3480156103ba57600080fd5b50610208600435610a56565b3480156103d257600080fd5b506101df600160a060020a0360043516610b2c565b3480156103f357600080fd5b506102ef600435610c72565b34801561040b57600080fd5b50610417600435610c84565b60408051600160a060020a039092168252519081900360200190f35b34801561043f57600080fd5b5061044b600435610cad565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b8381101561048e578181015183820152602001610476565b50505050905090810190601f1680156104bb5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b3480156104d657600080fd5b50610417600435610d89565b3480156104ee57600080fd5b506102ef600160a060020a0360043516610da4565b34801561050f57600080fd5b50610524600160a060020a0360043516610dbf565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610560578181015183820152602001610548565b505050509050019250505060405180910390f35b34801561058057600080fd5b506101df600435610e8b565b34801561059857600080fd5b50610417610ec5565b3480156105ad57600080fd5b50610208600435600160a060020a0360243516610ed4565b3480156105d157600080fd5b50610208610f45565b3480156105e657600080fd5b506102ef600435610f7c565b3480156105fe57600080fd5b50610325600160a060020a0360043516602435610f8e565b34801561062257600080fd5b50610417600435610fdd565b34801561063a57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526102ef9436949293602493928401919081908401838280828437509497505093359450610ff89350505050565b34801561069557600080fd5b50610208600435611023565b3480156106ad57600080fd5b506102ef6110ba565b3480156106c257600080fd5b506104176004356110c0565b3480156106da57600080fd5b506101df6004356110db565b3480156106f257600080fd5b506102086110ed565b34801561070757600080fd5b50610325600160a060020a0360043516611183565b60006107283384611218565b1561073257600080fd5b61073d3384846112e2565b50610747836113f1565b50600192915050565b60408051808201909152600a81527f4d2e492e54205835303900000000000000000000000000000000000000000000602082015281565b600b805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561080d5780601f106107e25761010080835404028352916020019161080d565b820191906000526020600020905b8154815290600101906020018083116107f057829003601f168201915b505050505081565b600a546000908190600160a060020a0316331461083157600080fd5b61083b858561152c565b600e5490915034101561084d57600080fd5b6000818152600c60209081526040808320349055600d9091529020426201518085020190559050805b509392505050565b6108883382611602565b151561089357600080fd5b61089d8183611622565b60408051338152600160a060020a038416602082015280820183905290517f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259181900360600190a15050565b6003545b90565b60006108fc3383611218565b151561090757600080fd5b610911338361165d565b5061091b826113f1565b506001919050565b600160a060020a038216151561093857600080fd5b600160a060020a03821630141561094e57600080fd5b610958338261175c565b151561096357600080fd5b61096d8382611602565b151561097857600080fd5b61098383838361177c565b505050565b6000818152600460205260408120543390829081908190600160a060020a031684146109b357600080fd5b6000868152600c6020526040812054935083116109cf57600080fd5b6000868152600660205260409020546001549092508211156109f057600080fd5b506000858152600d602052604090205442811115610a0d57600080fd5b604051339084156108fc029085906000818181858888f19350505050158015610a3a573d6000803e3d6000fd5b5050505050919050565b60066020526000908152604090205481565b6000818152600460205260409020546060903390600160a060020a03168114610a7e57600080fd5b6003805484908110610a8c57fe5b60009182526020918290206002918202018054604080516001831615610100026000190190921693909304601f810185900485028201850190935282815292909190830182828015610b1f5780601f10610af457610100808354040283529160200191610b1f565b820191906000526020600020905b815481529060010190602001808311610b0257829003601f168201915b5050505050915050919050565b6000808080600160a060020a0385161515610b4657600080fd5b84925082600160a060020a03166352454a3c6040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015610b8757600080fd5b505af1158015610b9b573d6000803e3d6000fd5b505050506040513d6020811015610bb157600080fd5b5051604080517f56ef9ba90000000000000000000000000000000000000000000000000000000081529051919250600160a060020a038516916356ef9ba9916004808201926020929091908290030181600087803b158015610c1257600080fd5b505af1158015610c26573d6000803e3d6000fd5b505050506040513d6020811015610c3c57600080fd5b5051600081815260046020526040902054909250600160a060020a03828116911614610c6757600080fd5b506001949350505050565b600c6020526000908152604090205481565b600081815260046020526040902054600160a060020a0316801515610ca857600080fd5b919050565b60606000610cb96119b6565b6003805485908110610cc757fe5b60009182526020918290206040805160029384029092018054600181161561010002600019011693909304601f81018590049094028201606090810182529082018481529193849291849190840182828015610d645780601f10610d3957610100808354040283529160200191610d64565b820191906000526020600020905b815481529060010190602001808311610d4757829003601f168201915b5050509183525050600191909101546020918201528151910151909590945092505050565b600460205260009081526040902054600160a060020a031681565b600160a060020a031660009081526007602052604090205490565b6060600060606000806000610dd387610da4565b9450841515610df2576040805160008152602081019091529550610a3a565b84604051908082528060200260200182016040528015610e1c578160200160208202803883390190505b509350610e276108e9565b925060009150600190505b828111610e8357600081815260046020526040902054600160a060020a0388811691161415610e7b57808483815181101515610e6a57fe5b602090810290910101526001909101905b600101610e32565b839550610a3a565b600a54600090600160a060020a03163314610ea557600080fd5b69021e19e0c9bab2400000821015610ebc57600080fd5b50600e55600190565b600a54600160a060020a031681565b60056020908152600092835260408084208252918352918190208054825160026001831615610100026000190190921691909104601f81018590048502820185019093528281529290919083018282801561080d5780601f106107e25761010080835404028352916020019161080d565b60408051808201909152600581527f4d2e492e54000000000000000000000000000000000000000000000000000000602082015281565b600d6020526000908152604090205481565b600160a060020a0382161515610fa357600080fd5b600160a060020a038216301415610fb957600080fd5b610fc33382611602565b1515610fce57600080fd5b610fd933838361177c565b5050565b600960205260009081526040902054600160a060020a031681565b600a54600090600160a060020a0316331461101257600080fd5b61101c8383611878565b9392505050565b6060600033600160a060020a03166352454a3c6040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801561106557600080fd5b505af1158015611079573d6000803e3d6000fd5b505050506040513d602081101561108f57600080fd5b5051600084815260046020526040902054909150600160a060020a03808316911614610a7e57600080fd5b600e5481565b600860205260009081526040902054600160a060020a031681565b60006110e73383611218565b92915050565b600b8054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156111795780601f1061114e57610100808354040283529160200191611179565b820191906000526020600020905b81548152906001019060200180831161115c57829003601f168201915b5050505050905090565b600a54600160a060020a0316331461119a57600080fd5b600160a060020a03811615156111af57600080fd5b600a54604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a3600a805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6000818152600560209081526040808320600160a060020a0386168452825280832080548251601f600260001961010060018616150201909316929092049182018590048502810185019093528083526060938301828280156112bc5780601f10611291576101008083540402835291602001916112bc565b820191906000526020600020905b81548152906001019060200180831161129f57829003601f168201915b505050505090506000815111156112d657600191506112db565b600091505b5092915050565b6000828152600560209081526040808320600160a060020a0387168452825280832080548251601f600260001961010060018616150201909316929092049182018590048502810185019093528083526060938301828280156113865780601f1061135b57610100808354040283529160200191611386565b820191906000526020600020905b81548152906001019060200180831161136957829003601f168201915b505050505090506000815111156113a05760019150610876565b6000848152600560209081526040808320600160a060020a0389168452825290912084516113d0928601906119ce565b50505060009182525060066020526040902080546001908101909155919050565b60006113fb6119b6565b60008381526006602052604090205460038054919350908490811061141c57fe5b60009182526020918290206040805160029384029092018054600181161561010002600019011693909304601f810185900490940282016060908101825290820184815291938492918491908401828280156114b95780601f1061148e576101008083540402835291602001916114b9565b820191906000526020600020905b81548152906001019060200180831161149c57829003601f168201915b5050505050815260200160018201548152505090506002548211156114e45760036020820152610983565b600154821180156114f757506002548211155b156115085760026020820152610983565b6000548211801561151b57506001548211155b156109835760016020820152505050565b60006115366119b6565b50604080518082019091528381526000602080830182905260038054600181810180845592855285518051919487936002027fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b019261159892849201906119ce565b5060209182015160019091015560408051600160a060020a03891681529390920390830181905281519093507fc07d6fc5db170f8be7da51bea7bf502fb674192c618536ee210555994694b0b79281900390910190a16115fa6000858361177c565b949350505050565b600090815260046020526040902054600160a060020a0391821691161490565b600091825260086020526040909120805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03909216919091179055565b6000818152600560209081526040808320600160a060020a0386168452825280832080548251601f600260001961010060018616150201909316929092049182018590048502810185019093528083526060938301828280156117015780601f106116d657610100808354040283529160200191611701565b820191906000526020600020905b8154815290600101906020018083116116e457829003601f168201915b505050505090506000815111156112d6576000838152600560209081526040808320600160a060020a0388168452909152812061173d91611a4c565b60008381526006602052604090208054600019019055600191506112db565b600090815260086020526040902054600160a060020a0391821691161490565b600160a060020a0380831660008181526007602090815260408083208054600101905585835260049091529020805473ffffffffffffffffffffffffffffffffffffffff1916909117905583161561182957600160a060020a0383166000908152600760209081526040808320805460001901905583835260098252808320805473ffffffffffffffffffffffffffffffffffffffff199081169091556008909252909120805490911690555b60408051600160a060020a0380861682528416602082015280820183905290517fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9181900360600190a1505050565b60006118826119b6565b61188a6119b6565b600380548590811061189857fe5b60009182526020918290206040805160029384029092018054600181161561010002600019011693909304601f810185900490940282016060908101825290820184815291938492918491908401828280156119355780601f1061190a57610100808354040283529160200191611935565b820191906000526020600020905b81548152906001019060200180831161191857829003601f168201915b5050505050815260200160018201548152505091506040805190810160405280868152602001836020015181525090508060038581548110151561197557fe5b9060005260206000209060020201600082015181600001908051906020019061199f9291906119ce565b506020919091015160019091015550919392505050565b60408051808201909152606081526000602082015290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611a0f57805160ff1916838001178555611a3c565b82800160010185558215611a3c579182015b82811115611a3c578251825591602001919060010190611a21565b50611a48929150611a93565b5090565b50805460018160011615610100020316600290046000825580601f10611a725750611a90565b601f016020900490600052602060002090810190611a909190611a93565b50565b6108ed91905b80821115611a485760008155600101611a995600a165627a7a72305820952e1bf221781f8655632f458855073f888324e0027e80d36dfb540900d965480029";

    protected X509_2_1_sol_MITX509(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected X509_2_1_sol_MITX509(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipTransferred",Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.mitLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.mitLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.mitLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<CreationEventResponse> getCreationEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Creation", 
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<CreationEventResponse> responses = new ArrayList<CreationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreationEventResponse typedResponse = new CreationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.X509Id = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CreationEventResponse> creationEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Creation", 
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.mitLogObservable(filter).map(new Func1<Log, CreationEventResponse>() {
            @Override
            public CreationEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                CreationEventResponse typedResponse = new CreationEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.X509Id = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> complain(BigInteger _tokenId, String _reason) {
        final Function function = new Function(
                "complain", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId), 
                new mit.abi.datatypes.Utf8String(_reason)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> name() {
        final Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> myCert() {
        final Function function = new Function("myCert", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createX509(String _x509pub, String _who, BigInteger _dayLong, BigInteger weiValue) {
        final Function function = new Function(
                "createX509", 
                Arrays.<Type>asList(new mit.abi.datatypes.Utf8String(_x509pub), 
                new mit.abi.datatypes.Address(_who), 
                new mit.abi.datatypes.generated.Uint256(_dayLong)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> approve(String _to, BigInteger _tokenId) {
        final Function function = new Function(
                "approve", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(_to), 
                new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function("totalSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> revokeComplain(BigInteger _tokenId) {
        final Function function = new Function(
                "revokeComplain", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _tokenId) {
        final Function function = new Function(
                "transferFrom", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(_from), 
                new mit.abi.datatypes.Address(_to), 
                new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdraw(BigInteger _tokenId) {
        final Function function = new Function(
                "withdraw", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> X509ComPlainCount(BigInteger param0) {
        final Function function = new Function("X509ComPlainCount", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getX509OnlyOwner(BigInteger _tokenId) {
        final Function function = new Function("getX509OnlyOwner", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> simpleVerifyX509(String _timeToke) {
        final Function function = new Function("simpleVerifyX509", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(_timeToke)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> X509Wallet(BigInteger param0) {
        final Function function = new Function("X509Wallet", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> ownerOf(BigInteger _tokenId) {
        final Function function = new Function("ownerOf", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple2<String, BigInteger>> getX509Message(BigInteger _tokenId) {
        final Function function = new Function("getX509Message", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> X509ToOwner(BigInteger param0) {
        final Function function = new Function("X509ToOwner", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> tokensOfOwner(String _owner) {
        final Function function = new Function("tokensOfOwner", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> changeMinVoteCash(BigInteger _minVoteCash) {
        final Function function = new Function(
                "changeMinVoteCash", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_minVoteCash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> X509ComPlain(BigInteger param0, String param1) {
        final Function function = new Function("X509ComPlain", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0), 
                new mit.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> X509WithdrawTime(BigInteger param0) {
        final Function function = new Function("X509WithdrawTime", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _tokenId) {
        final Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(_to), 
                new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> X509AllowedShow(BigInteger param0) {
        final Function function = new Function("X509AllowedShow", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> resetX509(String _x509pub, BigInteger _tokenId) {
        final Function function = new Function(
                "resetX509", 
                Arrays.<Type>asList(new mit.abi.datatypes.Utf8String(_x509pub), 
                new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getX509ByContract(BigInteger _tokenId) {
        final Function function = new Function("getX509ByContract", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> minVoteCash() {
        final Function function = new Function("minVoteCash", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> X509ToApproved(BigInteger param0) {
        final Function function = new Function("X509ToApproved", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> hasComplain(BigInteger _tokenId) {
        final Function function = new Function("hasComplain", 
                Arrays.<Type>asList(new mit.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> getOwnerCert() {
        final Function function = new Function("getOwnerCert", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new mit.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<X509_2_1_sol_MITX509> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _ownerX509) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new mit.abi.datatypes.Utf8String(_ownerX509)));
        return deployRemoteCall(X509_2_1_sol_MITX509.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<X509_2_1_sol_MITX509> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _ownerX509) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new mit.abi.datatypes.Utf8String(_ownerX509)));
        return deployRemoteCall(X509_2_1_sol_MITX509.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static X509_2_1_sol_MITX509 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new X509_2_1_sol_MITX509(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static X509_2_1_sol_MITX509 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new X509_2_1_sol_MITX509(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class CreationEventResponse {
        public Log log;

        public String owner;

        public BigInteger X509Id;
    }
}
