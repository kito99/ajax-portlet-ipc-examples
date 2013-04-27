package virtua.demo.portlet.ipc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Counter {

	private int value;

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}

	public void increment() {
		setValue(getValue() + 1);
		System.out.println("Counter value incremented to: " + getValue());
	}
}
