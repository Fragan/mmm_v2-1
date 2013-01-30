package utils;

import java.util.Timer;
import java.util.TimerTask;

import locusta.project.mapacti.LocustaMapActivityMain;

public class Clock {

	private Timer timer = new Timer();
	private TimerTask task;

	public void periodicallyActivate(final LocustaMapActivityMain activity, double perdiodInMiliSeconds) {
		task = new TimerTask() {
			public void run() {
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						activity.refreshEvents();
					}
				});
			}
		};
		timer.schedule(task, 0, (long) perdiodInMiliSeconds);
	}
	
	public void cancel() {
		task.cancel();
//		timer.cancel();
	}
}