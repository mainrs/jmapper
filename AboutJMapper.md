# About JMapper #
  * [What is JMapper?](AboutJMapper#What_is_JMapper?.md)
  * [Does JMapper supports osgi?](AboutJMapper#Does_JMapper_supports_osgi?.md)
  * [Is JMapper modular?](AboutJMapper#Is_JMapper_modular?.md)
  * [How does JMapper work?](AboutJMapper#How_does_JMapper_work?.md)


---


## What is JMapper? ##
JMapper is a framework providing tools for linking an interface to an map. If you like to create fast and easily e.g. a read-only access to your map, then you should use JMapper.


---


## Does JMapper supports osgi? ##
Actually JMapper is being developed as an OSGi bundle. So you are able to install JMapper in your OSGi-container. You don't need any third-party libs for getting JMapper within OSGi.


---


## Is JMapper modular? ##
Yes, JMapper is modular and it differs between plugins and modules. You can find out more about modules and plugins [here](ExtInfo.md).


---


## How does JMapper work? ##
JMapper defines your interface via reflection. Each access on the map happens inside the method. JMapper itself does **not** create any fields in the object returned by its factory. This is important, because you can not get the map out of the created object by reflection.

So JMapper can provide strict access on your map.