package virtua.demo.portlet.ipc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class CounterViewer {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		System.out.println("Counter viewer value set to: " + value);
	}
}
 