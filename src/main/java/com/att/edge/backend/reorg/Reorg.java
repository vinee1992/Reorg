/**
 * 
 */
package com.att.edge.backend.reorg;

import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.att.edge.appcommon.ConfigRules;
import com.att.edge.appcommon.ConfigTypeEnum;
import com.att.edge.appcommon.EdgeDaemon;
import com.att.edge.appcommon.EdgeException;
import com.att.edge.appcommon.EdgeThread;
import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;
import com.att.edge.appcommon.RuntimeSetup;
import com.att.edge.backend.reorg.reOrgEventSubscription.ReOrgEventPublisher;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class Reorg extends EdgeDaemon {

	public static HashMap<String, Object> ctx = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	

		ConfigRules[] rules = {
				new ConfigRules("force_thread_count", "", "force_thread_count", ConfigTypeEnum.LONG, "10", null),
				new ConfigRules("datasource", "", "datasource", ConfigTypeEnum.STRING, "edgedb", null),
				new ConfigRules("edge_idwo_url_end", "", "edge_idwo_url_end", ConfigTypeEnum.STRING, "", null),
				new ConfigRules("edge_cawo_url_end", "", "edge_cawo_url_end", ConfigTypeEnum.STRING,
						"workordermgmt/rest/createAmendWorkOrder", null),
				new ConfigRules("edge_cwo_url_end", "", "edge_cwo_url_end", ConfigTypeEnum.STRING,
						"workordermgmt/rest/cancelOrder", null),
				new ConfigRules("edge_udwo_url_end", "", "edge_udwo_url_end", ConfigTypeEnum.STRING,
						"WorkOrderServices/updateWorkOrder", null),
				new ConfigRules("polling_duration", "", "polling_duration", ConfigTypeEnum.LONG, "300", null),
				};
		loggingDir = "reorg";
		try {
			initialize(args, rules);
			GlobalContext.set("cfg", cfg);
			GlobalContext.set("log", log);
		} catch (EdgeException e) {
			log.debug(FileLogger.ALWAYS, "Can not Initialize stat_tracker: %s", e.getMessage());
			return;
		}
		String[] ans = RuntimeSetup.getDatabaseConnection(cfg.getString("datasource"));
		System.setProperty("oracle.net.tns_admin", System.getenv("ORACLE_HOME") + "/network/admin");
		System.setProperty("user", ans[0]);
		System.setProperty("password", ans[1]);
		System.setProperty("URL", "jdbc:oracle:thin:@" + ans[2]);
		int  polling_duration = (int) cfg.getLong("polling_duration");
		
		/* System.setProperty("user", "edge01"); System.setProperty("password",
		 "se2s017#"); System.setProperty("URL",
		 "jdbc:oracle:thin:@135.213.95.227:1524/t1c1d743");*/
		
		mainClass = Reorg.class;
		new ClassPathXmlApplicationContext("applicationContext.xml");

		
		int threadCount = 1;
		EdgeThread[] threads = new EdgeThread[threadCount];
		int t = 0;
		threads[t++] = new EdgeThread("ReOrgEventPublisherThread", ReOrgEventPublisher.class);

		try {
			pool(threads);
		} catch (EdgeException e) {
			log.write(FileLogger.BASE, "EDGE - program aborted its run: %s", e.getMessage());
			System.err.println("Error on open thread pool: %s" + e.getMessage());
		}
		log.write(FileLogger.ALWAYS, "Shutting down");
		cleanUp();

	}

}
