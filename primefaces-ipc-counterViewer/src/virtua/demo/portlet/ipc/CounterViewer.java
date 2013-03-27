package virtua.demo.portlet.ipc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletSession;

@SessionScoped
@ManagedBean
public class CounterViewer {

	private Integer value = 0;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
		System.out.println("Counter viewer value set to: " + value);
	}
	
	public String getChannel() {
		String channel = "/counter" + getPortletSession().getId();
		System.out.println("Counter viewer returning channel name: " +  channel);
		return channel;
	}

	protected PortletSession getPortletSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (PortletSession) facesContext.getExternalContext().getSession(
				false);
	}
}
 