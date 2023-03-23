package week13;

public class Transaction {

	int CustomerId;
	int branchId;
	String data;
	int goodId;
	double price;
	int	quantity;
	double amount;

	public Transaction(int CustomerId,int branchId,String data,int goodId,double price,int	quantity,double amount) {
		this.CustomerId=CustomerId;
		this.branchId=branchId;
		this.data=data;
		this.goodId=goodId;
		this.price=price;
		this.quantity=quantity;
		this.amount=amount;
	}
	
	
	public String toString() {
		String data;
		data = "custemerId :" + CustomerId +" , branchId :" +branchId +" , data :" + data+" , goodId :" + goodId+" , price :" +price +" , quantity :" +quantity +" , amount :"+amount;
		return data;
	}
	
}
