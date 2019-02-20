/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author huangh
 */
package cn.chapter2;

/**
import net.sf.cglib.proxy.Enhancer;  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy; 

public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		while(true){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, Method method, Object[]
						args, MethodProxy proxy) throws Throwable{
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}
	static class OOMObject{
		
	}
}
//有问题，暂时没想到解决
*/
