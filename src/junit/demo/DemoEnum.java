package junit.demo;

public class DemoEnum {
	public static void main(String[] args){
		Pet dog = Pet.DOG;//定义
		//Pet cat = new Pet("duck",18); 例子，不允许用户自己实例化
		//比如selenium，键盘的操作，就这些按键。把类都封装好了，就不允许我们来自己实例化对象了。	
		
	}
}
//枚举类型，商店只有这几个。用户使用时直接从这里取就行了。
enum Pet{
	DOG("dog",15),CAT("cat",16),MONKEY("monkey",20);
	//定义对象
	private String name;
	private float price;
	private Pet(String name ,float price){
		this.setName(name);
		this.setPrice(price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
