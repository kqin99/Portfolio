import java.util.*;

/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
public class project01 {

	public static void main(String[] args) {
		Random rand = new Random(); 
		Scanner input=new Scanner(System.in); 
		int MaxValue=100;  //set the max value and the minimum value
		int MinValue=10;
		double g=9.8;//set variable
		Double angle;//set variable
		Double speed;//set variable
		Boolean gameplay=true;
		int i=0;//set variable
		double drag;//set variable
		String str1[]={"You made it!","Wonderful shoot!","You are the best!"};
		String str2[]={"Plenty of room!","High above the wall!","Up into the sky!"};
		String str3[]={"Not quite over!","Very close!","Try a little harder!"};
		String str4[]={"Not even close!","You can do it!","shoot!!!"};
		System.out.print("Want to Play this Game? Say true to play and false to quit");
		gameplay=input.nextBoolean();
		while (gameplay!=false){//control the beginning and ending of the game
		int score=0;
		Boolean done=true;
		int wall=rand.nextInt(MaxValue)+MinValue;//randomize a wall height
		i++;
		long duretime=0;
		System.out.println("Round "+i+" Ready... Starts! ");
		while (done!=false){
		System.out.println("The Wall is coming at you!");
		long startTime=System.currentTimeMillis(); 
		double distance=50;
		System.out.print("Set your angle:");
		angle=input.nextDouble();
		long endTime=System.currentTimeMillis();
		System.out.print("Launch your speed:");
		duretime=duretime+(endTime-startTime)/1000;//count the time
		speed=input.nextDouble();
		distance=distance-(double)duretime*(3);
		drag=rand.nextInt(8)+1;//randomize a drag
		double height1=distance*(Math.tan(angle*Math.PI/180))-((g*distance*distance)/(2*Math.pow(((speed-drag)*Math.sin(angle*Math.PI/180)),2)));
		//count the height of the catapult's shoot
		double difference=height1-wall;
		score=score-1;
		if (distance<=0) {//decide whether the user runs out of time
		System.out.println("The Wall has arrived! You lost!");
		done=false;
		}
		else{if (difference>0 && difference<4){
		int a1 = rand.nextInt(3);
		System.out.println(str1[a1]);
		done=false;
		score+=5;
		}
		else if (difference>4) {
		int a1 = rand.nextInt(3);
		System.out.println(str2[a1]);
		score+=2;
		done=false;}
		else if (difference<=0 && difference>-1){
		int a1 = rand.nextInt(3);
		System.out.println(str3[a1]);
		score-=1;}
		else {
		int a1 = rand.nextInt(3);//Decide the result of the catapult'shoot
		System.out.println(str4[a1]);
		score-=3;}
		}
		System.out.println("Your current score is: "+score);
		}
		System.out.println("Your final score is: "+score);
		System.out.print("Say true if you want to continue,false if you want to quit");//decide whether to continue the game or not
		gameplay=input.nextBoolean();
		}
		input.close();
		}
	}
