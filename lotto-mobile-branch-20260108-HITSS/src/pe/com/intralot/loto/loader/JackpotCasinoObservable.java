package pe.com.intralot.loto.loader;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Observable;

public class JackpotCasinoObservable extends Observable
{
	public JackpotCasinoObservable(int delay, int seconds)
	{
		Timer timer = new Timer();
		timer.schedule(timerTask, delay*1000, seconds*1000);
	}
	public JackpotCasinoObservable(int seconds)
	{
		Timer timer = new Timer(); 
		timer.schedule(timerTask, seconds*1000);
	}
	TimerTask timerTask = new TimerTask()
	{
		public void run() 
		{
			setChanged();
			notifyObservers(new Date());
		}
	};
}
