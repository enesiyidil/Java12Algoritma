package dersler.ders025;

public class Kosucu extends Thread {

	private String nameRunner;
	private int mesafe;
	private long sure;

	public Kosucu(String nameRunner) {
		super();
		this.nameRunner = nameRunner;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			mesafe++;
			if (mesafe % 10 == 0) {
				System.out.println(nameRunner + " adlı koşucu " + mesafe + "'de");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sure = System.currentTimeMillis() - start;
		System.out.println(nameRunner + "adlı koşucu " + sure + " ms'de tamamladı");
	}

	public String getNameRunner() {
		return this.nameRunner;
	}

	public int getMesafe() {
		return mesafe;
	}

	public void setMesafe(int mesafe) {
		this.mesafe = mesafe;
	}

	public long getSure() {
		return sure;
	}

	public void setSure(long sure) {
		this.sure = sure;
	}

}
