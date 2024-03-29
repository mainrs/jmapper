package de.jfruit.jmapper.adapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import de.jfruit.jmapper.MethodType;
import de.jfruit.jmapper.ext.MapperModule;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AdapterModule implements MapperModule<Adapter>
{
	@Override
	public Object executeModule(final MethodType type, final Adapter anno, final Map<Object, Object> prop, final Object[] parameter, final Class<?> returnType, final Object worstCaseResult) 
	{
		if(prop==null || type==MethodType.SETTER)
			return worstCaseResult;
		
		try {			
			Constructor<?> constr=anno.value().getDeclaredConstructor();
			constr.setAccessible(true);
			ILinkAdapter adapter=(ILinkAdapter) constr.newInstance();			
			
			Object key=adapter.key();					
			
			if(prop.containsKey(key))
				return adapter.parse(prop.get(key));
			
			return adapter.defValue();			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return worstCaseResult;
	}
	
	@Override
	public void updateCall(final MethodType type, final Adapter anno, final Map<Object, Object> prop, final Object[] parameter, final Object newValue, final int plgCount) 
	{
		
	}
}
