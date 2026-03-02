package pe.com.intralot.loto.loader;

import java.util.Observable;
import java.util.Observer;

import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.JackpotCasinoUtils;

public class JackpotCasinoObserver {

	public static JackpotCasinoObservable jackpotCasinoObservable  = null;
	
	public static Observer jackpotCasinoObserver  = null; 
	
	public static boolean jackpotCasinoIsRunning = false;
	
	public static int contador = 0;	
	
	public static void createJackpotCasinoObservable(int delay, int every)
	{		 
		jackpotCasinoObservable = new JackpotCasinoObservable(delay, every);  // Load every 1 minutes = 60*1 seconds. Start at 30 second
		jackpotCasinoObserver = new Observer() {
			public void update(Observable unObservable, Object data) {
				if (jackpotCasinoIsRunning) {
					System.out.println("!!!jackpotCasinoIsRunning!!!");
					return;
				}
				jackpotCasinoIsRunning = true;
				//System.out.println("ejecuta JackpotCasinoUtils.updateJackpotCasino()");
				try {
					JackpotCasinoUtils.updateJackpotCasino();										
				}catch(Exception e) {
					LoggerApi.severe(e);
					jackpotCasinoIsRunning = false;
				}
				jackpotCasinoIsRunning = false;
			}
		};
		jackpotCasinoObservable.addObserver(jackpotCasinoObserver);
	}
	
	public static void finalized()  { 
		System.out.println("Finalizing JackpotCasinoObserver!");
		jackpotCasinoObservable.deleteObserver(jackpotCasinoObserver);
		System.out.println("Finalized JackpotCasinoObserver!");
	}
 
}
