package Inventory;

public class Customer implements Runnable {

	@Override
	public void run() {
		System.out.println("customer");
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Manage.invt) {
				
				
					if(!Manage.invt.isEmpty())
					{
						System.out.println();
						int it=Manage.invt.remove(0);
						System.out.println(Thread.currentThread().getName()+" customernotified "+"removed "+it);
						Manage.invt.notify();
						
					}else
					{
						System.out.println(Thread.currentThread().getName()+" customerwaiting");
						try {
							Manage.invt.wait();
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						}
				
				
			}
		}
		
		
	}
	

}
