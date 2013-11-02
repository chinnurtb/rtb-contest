package com.ipinyou.contest.algorithm;
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
 
/**
 * Bid class that need to be completed by the contest participants This is the
 * only place to implement your bidding algorithm Note that the class name (Bid)
 * and package name (com.ipinyou.contest.algorithm) are fixed to make a correct
 * submission.
 * 
 */
public class Bid implements Algorithm {
 
    /*** Algorithm parameters definition***/
        
    // ratio of bidding in percent
    private int bidRatio = 50;
 
	// Fixed bid price
	private int fixedBidPrice = 300;
 
 	// Config parameters def file
	private String configFile = "algo.conf";
	
	// Other model related variables may be defined here
	// private Map<String, String> model = new HashMap<String, String>();
 
	/**
	 * init() method initializes alogrithm paramters and model 
	 * Memory limit: 512M
	 * @throws Exception 
	 */
	@Override
	public void init() throws Exception {
		readConfigPara(this.configFile);
	}
 
	/**
	 * getBidPrice() method makes the real calculation Note: one bid reqeust
	 * decision has to be make less than 20ms.
	 * 
	 */
	@Override
	public int getBidPrice(BidRequest bidRequest) {
 
		int bidPrice = -1;
		Random r = new Random();
 
		if (r.nextInt(100) < this.bidRatio)
			bidPrice = this.fixedBidPrice;
 
		return bidPrice;
	}
	
    /**  Reading config parameters from config file
	 *   The config file is defined in key=value format
	 *   Lines starting with '#' are regarded as remarks
	 */
	public void readConfigPara(String filename) throws Exception {
		InputStream inputStream = read(filename);
		String line = null;
		Map<String, String> kvMap = new HashMap<String, String>();
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		while ((line = br.readLine()) != null) {
			if (line.matches("^#.*"))    // Skip remark lines starting with #
				continue;
 
			String[] arr = line.trim().split("=");
			if (arr.length == 2) {
				kvMap.put(arr[0], arr[1]);
			}
		}
 
		if (kvMap.containsKey("bidRatio"))
			this.bidRatio = Integer.parseInt(kvMap.get("bidRatio"));
 
		if (kvMap.containsKey("fixedBidPrice"))
			this.fixedBidPrice = Integer.parseInt(kvMap.get("fixedBidPrice"));
 
	}
 	
 	/**
 	 * read file(from jar files or not) to inputstream
 	 */
	private InputStream read(String filename) {
		InputStream resourceAsStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream(filename);
		if (resourceAsStream == null) {
			throw new RuntimeException("read file error ");
		}
		return resourceAsStream;
	}
 
}