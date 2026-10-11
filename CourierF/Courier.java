package CourierF;
public class Courier
	{
		private int courierId;
		private int quantity;
		private double weight;
		
		
		
		public Courier()
		{
			
		}
		
		public Courier(int quantity,double weight,int courierId)
		{
			this.quantity=quantity;
			this.weight=weight;
			this.courierId=courierId;
			
		}
		
		public void setCourierId(int courierId)
		{
			this.courierId = courierId;
		}
		
		public int getCourierId()
		{
			return courierId;
		}
		
		public void setQuantity(int quantity)
		{
			this.quantity = quantity;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
		
		public void setWeight(double weight)
		{
			this.weight=weight;
		}
		
		public double getWeight()
		{
			return weight;
		}
		
		public void showCourier()
		{
			System.out.println("------------------");
			System.out.println("COURIER ID IS     "+courierId);
			System.out.println("COURIER QUANTITY  "+quantity);
			System.out.println("COURIER WEIGHT    "+weight);
			System.out.println("------------------");
				
		}
		
		public String toString()
		{
			return this.getCourierId()+";"+this.getQuantity()+";"+this.getWeight();
		}
	}