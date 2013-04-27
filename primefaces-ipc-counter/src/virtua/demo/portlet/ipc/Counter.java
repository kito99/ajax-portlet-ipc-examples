package virtua.demo.portlet.ipc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletSession;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@SessionScoped
@ManagedBean
public class Counter {

	private Integer value = 0;

	public Integer getValue() {
		return value;
	}

	private void setValue(Integer value) {
		this.value = value;
	}

	public void increment() {
		Integer newValue = getValue() + 1;
		setValue(newValue);
		System.out.println("Counter value incremented to: " + newValue);
		PushContext pushContext = PushContextFactory.getDefault()
				.getPushContext();
		pushContext.push(getChannel(), newValue.toString());
		System.out.println("Value pushed to channel: " + getChannel());
	}

	public String getChannel() {
		return "/counter" + getPortletSession().getId();
	}

	protected PortletSession getPortletSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (PortletSession) facesContext.getExternalContext().getSession(
				false);
	}
}
