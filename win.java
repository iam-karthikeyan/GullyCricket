import java.io.*;
import java.util.Scanner;
class gully
{
	int target=0;
	void help()                // rules are here.
	{
		System.out.println("==========================================================");
		System.out.println("...................THE RULES ARE..........................");
		System.out.println("1) This is like a SCOREBARD for gully cricket");
		System.out.println("2) If the ball goes wide or No ball Enter ' -1 '");
		System.out.println("3) Each wide and No ball add one run extra ");
		System.out.println("4) Kindly request enter the run correctly");
		System.out.println("5) you can't change the run on previous ball");
		System.out.println("==========================================================");
	}
    void first(int overs)
	{
		int score=0;
		Scanner io=new Scanner(System.in);
		System.out.println("**************************");
		System.out.println("Start The First Innings");    //starting FirstInnings
		System.out.println("**************************");
		for(int i=0;i<overs;i++)
		{
			int thisover=0;
			for(int j=1;j<=6;j++)
			{
				System.out.print("Ball NO :"+i+" . "+j+" :");
				int run=io.nextInt();
				if(run!=-1)          //calculating runs 
				{
					 score+=run;
					 thisover+=run;
				}
   				else if(run==-1)     // wide calculation
				{
					score++;
					thisover++;
					while(run==-1)
					{
						System.out.print("Ball NO :"+i+" . "+j+" :");
						run=io.nextInt();
						score++;
						thisover++;
					}
				}
			}
			System.out.println(+(i+1)+" over run : "+thisover);
			System.out.println("CURRENT SCORE IS :"+score);
		}
		target=score+1;
		System.out.println("**********************");
		System.out.println("THE TARGET IS :"+target);     //after completetion of firstInnings
    	System.out.println("**********************");
	}
}
class cricket extends gully
{
	void second(int overs)
	{
		int scores=0;
		Scanner go=new Scanner(System.in);
		System.out.println("***************************");
		System.out.println("Start The Second Innings");   //starting secondInnings
		System.out.println("***************************");
		for(int i=0;i<overs;i++)
		{ int thisover=0;
			for(int j=1;j<=6;j++)
			{
				System.out.print("Ball NO :"+i+" . "+j+" :");
				int runs=go.nextInt();
				if(runs!=-1)                                //calculating score
				{
					 scores+=runs;
					 thisover+=runs;
					 if(scores>target)
					 {
						 break;
					 }
				}
				else if(runs==-1)        //wide calculation
				{
					scores++;
					thisover++;
					if(scores>target)
					{
						break;
					}
					while(runs==-1)
					{
						System.out.print("Ball NO :"+i+" . "+j+" :");
						runs=go.nextInt();
						scores++;
						thisover++;
						if(scores>target)
						{
							break;
						}
					}
				}
			}
			System.out.println(+(i+1)+" over run : "+thisover);
			System.out.println("CURRENT SCORE IS :"+scores);
			if(scores>=target)                                     //after completetion of match result will show here
			{
				System.out.println("*******************************");
				System.out.println("THE CHASING TEAM IS THE WINNER ");
				System.out.println("*******************************");
			}
			else if(scores<target)
				{
				    System.out.println("*********************************");	
					System.out.println("THE DEFENDING TEAM IS THE WINNER ");
					System.out.println("*********************************");
				}
				else
				{
					System.out.println("********************");
					System.out.println(".....DRAW MATCH.....");
		     		System.out.println("********************");
		        }			
		}
		
	}
}
class win
{
	public static void main(String args[])
	{
		
		cricket di=new cricket();
		Scanner da=new Scanner(System.in);
		System.out.println("...............WELLCOME TO GULLY CRICKET................");
		di.help();
		System.out.println("ENTER HOW MANY OVERS :");
		int overs=da.nextInt();
		di.first(overs);
		di.second(overs);
	}
}