package test;

import java.lang.annotation.Annotation;
import java.net.Socket;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Scanner implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		Class<? extends Object> clazz = bean.getClass();
		Class<?> [] interfaces = clazz.getInterfaces();
		
		if(interfaces != null && interfaces.length > 0 ){
			for(Class<?> interFace : interfaces){
				Annotation[] annotations = interFace.getAnnotations();
				interFace.getAnnotations();
			}
		}
		
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

}
