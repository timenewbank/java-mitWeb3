web3j: Web3 Java TNB Ðapp API

Quickstart

.. code-block:: java

  public static void testWeb3(){
    Web3j web3 = Web3j.build(new HttpService(ip));  // defaults to http://localhost:8545/
    Web3ClientVersion web3ClientVersion = null;
    try {
      web3ClientVersion = web3.web3ClientVersion().send();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String clientVersion = web3ClientVersion.getWeb3ClientVersion();
    System.out.println(clientVersion);
  }

.. code-block:: java

  public static void testWeb3Account(){
    List<String> accounts;
    try {
      accounts = web3.mitAccounts().send().getAccounts();
      if(null!=accounts&&accounts.size()>0){
        for (String account : accounts) {
          System.out.println(account);
        }
      }else{
        System.out.println("no account");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

.. code-block:: java

  public static void testNewAccount(){
    Gmit geth = Gmit.build(new HttpService(ip));
    try {
      NetPeerCount count = geth.netPeerCount().send();
      System.out.println(count.getQuantity());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

.. code-block:: java

  public static void testNewGeth(){
    Gmit geth = Gmit.build(new HttpService(ip));
    try {
      MitBlockNumber block = geth.mitBlockNumber().send();
      System.out.println(block.getBlockNumber());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
.. code-block:: java

  public static void testGethAccount(){
    Gmit geth = Gmit.build(new HttpService(ip));
    try {
      String method = geth.personalNewAccount("1234").send().getResult();
      System.out.println(method);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
.. code-block:: java

  public static void testAdmin(){
    Admin admin=Admin.build(new HttpService(ip));
    try {
      Error error = admin.personalNewAccount("1234").send().getError();
      System.out.println(error.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
.. code-block:: java

  public static void testWallets(){
    try {
      String filePath="E:\\mit_wallet"; 
      String walletFile = WalletUtils.generateNewWalletFile("1234", new File(filePath), false);
      Credentials credentials = WalletUtils.loadCredentials("1234", filePath+"/"+walletFile);
      System.out.println(walletFile);
      System.out.println(credentials.getAddress());
      System.out.println(credentials.getEcKeyPair().getPublicKey());
      System.out.println(credentials.getEcKeyPair().getPrivateKey());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
.. code-block:: java

  public static void loadWallets(){
    String path="E:\\mit_wallet\\UTC--2018-08-22T03-32-21.160000000Z--cbeb7b079ec50a479b59aa2ab18da2c9a6b85907.json";
    try {
      Credentials credentials = WalletUtils.loadCredentials("1234", path);
      MitGetBalance balance = web3.mitGetBalance(credentials.getAddress(),  DefaultBlockParameter.valueOf("latest")).send();
      System.out.println(Convert.fromWei(balance.getBalance().toString(),Convert.Unit.TNB));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
.. code-block:: java

  public static void sendTransaction(String value,String password){
    String inp="Hello mit";
    String hexString=Numeric.toHexString(inp.getBytes());
    String fromAddress;
    try {
      BigDecimal valueFromTnb = Convert.toWei(value,Convert.Unit.TNB);
      fromAddress = web3.mitAccounts().send().getAccounts().get(0);
      BigInteger balance = web3.mitGetBalance(fromAddress, DefaultBlockParameter.valueOf("latest")).send().getBalance();
      if(balance.compareTo(valueFromTnb.toBigInteger())>=0){
        System.out.println(balance+"大于"+valueFromTnb.toBigInteger());
        //unlock the from account
        PersonalUnlockAccount unlock_result = admin.personalUnlockAccount(fromAddress,password).send();
        if(unlock_result.getResult()){
          BigInteger transactionCount = web3.mitGetTransactionCount(fromAddress, DefaultBlockParameter.valueOf("latest")).send().getTransactionCount();
          System.out.println("nonce===>"+transactionCount.toString());
          BigInteger gasLimit = new BigInteger("2000000");
          BigInteger gasPrice=Convert.toWei("0.000018", Convert.Unit.TNB).toBigInteger();
          Transaction transaction=Transaction.createFunctionCallTransaction(fromAddress, transactionCount, gasPrice, gasLimit, "0xcbeb7b079ec50a479b59aa2ab18da2c9a6b85907", valueFromTnb.toBigInteger(), hexString);
          MitSendTransaction result = admin.mitSendTransaction(transaction).send();
          if(null!=result.getError()){
            System.out.println(result.getError().getMessage());
          }else{
            System.out.println(result.getTransactionHash());
          }
        }else{
          System.out.println(unlock_result.getError().getMessage());
        }
      }else{
        System.out.println("please check your balance！");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
.. code-block:: java

  public static void getPrice(){
    try {
      BigInteger gasPrice = web3.mitGasPrice().send().getGasPrice();
      System.out.println("gasPrice"+gasPrice);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

.. code-block:: java

  public static void testWindowIpc(){
    Web3j web3Win = Web3j.build(new WindowsIpcService("/path/to/namedpipefile"));
    Web3j web3Uinx = Web3j.build(new UnixIpcService("/path/to/socketfile"));
  }
  
.. code-block:: java

  //get the contract
  public static void testContract(){
    
    try {
      String path="E:\\mit_wallet\\UTC--2018-08-22T03-32-21.160000000Z--cbeb7b079ec50a479b59aa2ab18da2c9a6b85907.json";
      Credentials credentials = WalletUtils.loadCredentials("1234", path);
      BigInteger gasPrice = web3.mitGasPrice().send().getGasPrice();
      X509_2_1_sol_MITX509 mitX509 = X509_2_1_sol_MITX509.load("0x0d4e2b472610fdf41b3b79c9792a0d4f5907a9f6", web3, credentials, gasPrice, new BigInteger("2000000"));
      Tuple2<String, BigInteger> result = mitX509.getX509Message(new BigInteger("0")).send();
      String x509Str = Utils.hexStringToString(result.getValue1());
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      InputStream inStream = new ByteArrayInputStream(x509Str.getBytes("UTF-8"));
      X509Certificate oCert = (X509Certificate)cf.generateCertificate(inStream);
      System.out.println(oCert.getIssuerDN().getName());
      System.out.println(oCert.getSubjectDN().getName());
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
.. code-block:: java

  public static void testFilter(){
    Subscription subscribe = web3.blockObservable(false).subscribe(block->{
      System.out.println(block.getBlock().getNumber());
      Block handleBlock = block.getBlock();
      List<TransactionResult> transactions = handleBlock.getTransactions();
      for (TransactionResult transactionResult : transactions) {
        Object object = transactionResult.get().toString();
      }
    });
  }
  

.. code-block:: java

  /**
   * get the transaction
   */
  public static void testTransaction(){
    web3.transactionObservable().subscribe(transaction->{
      System.out.println(transaction.getBlockHash());
      String transactionhash = transaction.getHash();
      String transactionStr = transaction.toString();
      System.out.println("transactionhash->"+transactionhash);   
    });
  }


.. code-block:: java

  /**
   * get block
   */
  public static void getBlock(){
    try {
      MitBlock block = web3.mitGetBlockByNumber(DefaultBlockParameter.valueOf(new BigInteger("56530")), true).send();
      String miner = block.getBlock().getMiner();
      System.out.println("miner:"+miner);
      List<TransactionResult> transactions = block.getBlock().getTransactions();
      //get the transactions
      if(null!=transactions&&transactions.size()>0){
        System.out.println("transaction:"+transactions.size());
        for (TransactionResult transactionResult : transactions) {
          String trans = transactionResult.toString();
          System.out.println(trans);
          TransactionObject ds = (TransactionObject) transactionResult.get();
          String from = ds.getFrom();
          String to = ds.getTo();
          String value = Convert.fromWei(ds.getValue().toString(),Convert.Unit.TNB).toPlainString();
          System.out.println("from:"+from+" to:"+to+" value:"+value);
        }
      }else{
        System.out.println();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }  
}
