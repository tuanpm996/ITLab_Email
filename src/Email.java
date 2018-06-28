
public class Email implements Runnable{
	private int i;
	private String email;
	
	public Email(int i, String email) {
		this.i = i;
	}
	public void sendEmail(String email) throws InterruptedException {
         Thread.sleep(3000);
//         System.out.println("Thread is exiting " + i);
	}
	@Override
	public void run() {
		try {
			sendEmail(this.email);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
