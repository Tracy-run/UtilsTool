package threadPoolExecutor;

public class Task implements Runnable{

	private int id;
	private String name;

	public Task(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("当前线程的名称为："+ this.id + " " + this.name );
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String toString(){
		return "名称为：" + this.id + "   " + this.name;
	}
	
}
