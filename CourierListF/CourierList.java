package CourierListF;
import CourierF.*;
	public class CourierList
		{
			
			private Courier couriers[];
			
			public CourierList()
			{
				couriers = new Courier[100];
			}
			
			public CourierList(int size)
			{
				couriers = new Courier[size];
			}
			
			public void showAllCouriers()
			{
				for(int i=0;i<couriers.length;i++)
					{
						if(couriers[i] != null)
						{
							couriers[i].showCourier();
						}
					}
			}
			
			public void insertCourier(Courier C)
			{
				boolean flag = false; 
					
				for(int i=0;i<couriers.length;i++)
				{
					if(couriers[i] == null)
					{
						couriers[i] = C;
						flag = true;
						break;
					}
				}
				
				if(flag)
				{
					System.out.println("COURIER ADDED SUCCESSFULLY");
				}
					
				else
				{
					System.out.println("NOT ENOUGH SPACE IN INVENTORY TO STORE COURIER");			
				}
			}
			
			public void removeCouriersById(int id)
			{
				boolean flag = false;
				
				for(int i=0;i<couriers.length;i++)
				{
					if(couriers[i] != null)
					{
						if(couriers[i].getCourierId() == id)
						{
							couriers[i] = null;
							flag = true;
							break;
						}
					}
				}
				if(flag)
				{
					System.out.println("COURIER REMOVED FROM INVENTORY");
				}
				else
				{
					System.out.println("COURIER IS NOT FOUND");			
				}
			}			
			
			public Courier[] getAllCourier()
				{
					return couriers;
				}	
		}
