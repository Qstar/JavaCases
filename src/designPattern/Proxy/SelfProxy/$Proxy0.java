package designPattern.Proxy.SelfProxy;
import java.lang.reflect.Method;
import designPattern.Proxy.SelfProxy.InvocationHandler;
public class $Proxy0 implements designPattern.Structural.Proxy.SelfProxy.Moveable {
	public $Proxy0(InvocationHandler h) {
		this.h = h;
	}
  private InvocationHandler h;
	@Override
	public void move() {
  try{
  Method md = designPattern.Structural.Proxy.SelfProxy.Moveable.class.getMethod("move");
  h.invoke(this,md);
  }catch(Exception e){ e.printStackTrace();}
	}
}