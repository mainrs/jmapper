# Introduction #

With JMapper you're able to create custom read/write rules on each propertie of your map. All you need to do, is to annotate the methods of your interface.

```
public interface MyInterface
{
	@Link(key="apptitle")
	String getAppTitle();
	
	@Link(key="apptitle")
	void setAppTitle(String title);
}
```

JMapper is able to recognize java beans. If your interface is valid to the given bean convention, JMapper will work fine on them.

It is quite easy, to use the interface right now:

```
public class UseMyInterface 
{
	public static void main(String[] args) 
	{
		Properties props=new Properties();
		props.setProperty("apptitle", "Application");
		
		MyInterface myInterface=JMapper.createFromMap(props, MyInterface.class);
		
		System.out.println(myInterface.getAppTitle()); // Application
		myInterface.setAppTitle("Hello World");
		
		System.out.println(props.getProperty("apptitle")); // Hello World
	}
}
```

I guess you've noticed, that myInterface is still linked to the map. Changes made on the interface will be evaluated on the map at once.
You can do quite more to provide your custom access, just keep on reading the wiki to get all posibilities.