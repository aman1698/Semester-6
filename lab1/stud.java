import java.io.*;
import java.util.*;
class student
{
	String name,usn,addr,type;
	int age;
	student(String name,String usn,String addr,String type,int age)
	{
		this.name=name;
		this.usn=usn;	
		this.addr=addr;
		this.type=type;
		this.age=age;
	}
	void display()
	{
		System.out.println("Name :"+name+"\nUSN :"+usn+"\nAddress: "+addr+"\nType: "+type+"\nAge: "+age+" "); 
	}
}
class ugstudent extends student
{
	int sem,credits;
	ugstudent(String name,String usn,String addr,String type,int age,int sem,int credits)
	{
		super(name,usn,addr,type,age);
		this.sem=sem;
		this.credits=credits;
	}
	void check()
	{
		try {
			throw new creditexception(credits,type);
		}
		catch(creditexception e)
		{
			System.out.println(e);
		}
	}
}

class pgstudent extends student
{
	int sem,credits;
	pgstudent(String name,String usn,String addr,String type,int age,int sem,int credits)
	{
		super(name,usn,addr,type,age);
		this.sem=sem;
		this.credits=credits;
	}
	void check()
	{
		try {
			throw new creditexception(credits,type);
		}
		catch(creditexception e)
		{
			System.out.println(e);
		}
	}
}

class creditexception extends Exception
{
	int credit;
	String type;
	creditexception(int credit,String type)
	{
		this.credit=credit;
		this.type=type;
	}
	public String toString()
	{
		if(type.equals("Regular") || type.equals("Change of Branch"))
		{
			if(credit<200)
				return "Student cannot graduate";
			else
				return "Student graduated";
		}
		else if(type.equals("Diploma"))
		{
			if(credit<150)
				return "Student cannot graduate";
			else
				return "Student graduated";
		}
		else 
			return "Invalid Credentials";

	}
}

class stud
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String name,usn,add,type;
		int age,credit,sem;
		System.out.println("Enter name:");
		name=sc.next();
		System.out.println("Enter usn:");
		usn=sc.next();
		System.out.println("Enter Address:");
		add=sc.next();
		System.out.println("Enter age:");
		age=sc.nextInt();
		System.out.println("Enter Semester:");
		sem=sc.nextInt();
		System.out.println("Enter Type: Regular , Change of Branch , Diploma");
		type=sc.next();
		System.out.println("Enter Credits:");
		credit=sc.nextInt();
		System.out.println("Enter 1 - UG Student\n 2- PG Student");
		int ch=sc.nextInt();
		if(ch==1)
		{
			ugstudent ug=new ugstudent(name,usn,add,type,age,sem,credit);
			ug.check();
			ug.display();
		}
		if(ch==2)
		{
			pgstudent pg=new pgstudent(name,usn,add,type,age,sem,credit);
			pg.check();
			pg.display();
		}		
	}
}
			
	
