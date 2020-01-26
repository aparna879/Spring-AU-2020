package Inventory;

import java.util.Random;

public class Producer implements Runnable {
	Random r=new Random();
	@Override
	public void run() {
		
		synchronized (Manage.invt) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				for(int  i=0;i<19;i++)
				{
					if(Manage.invt.size()>=5)
					{
						try {
							System.out.println("Producer Waiting");
							Manage.invt.wait();
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					else {
					int ri=r.nextInt(8);
					Manage.invt.add(i);
					System.out.println("producer added "+i);
					Manage.invt.notifyAll();
				}
				
			}
			
			
		}		
		
	}

}
