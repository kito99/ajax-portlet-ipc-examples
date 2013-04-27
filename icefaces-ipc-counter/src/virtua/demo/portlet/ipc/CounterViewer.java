package virtua.demo.portlet.ipc;

import java.util.Map;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.icefaces.application.PushRenderer;

@RequestScoped
@ManagedBean
public class CounterViewer {

	public static final String COUNTER_KEY = "count";
	public static final String COUNTER_RENDER_GROUP = "counter-render-group";
	
	@ManagedProperty("#{httpSessionScope}")
	private Map<String, Object> appSession;

	public CounterViewer() {
		PushRenderer.addCurrentSession(COUNTER_RENDER_GROUP);
	}

	@PreDestroy
	public void preDestroy() {
		PushRenderer.removeCurrentSession(COUNTER_RENDER_GROUP);
	}

	public Integer getValue() {
		Integer value = (Integer) getAppSession().get(COUNTER_KEY);
		return value == null ? 0 : value;
	}
	
	public Map<String, Object>  getAppSession() {
		return appSession;
	}

	public void setAppSession(Map<String, Object>  portletSession) {
		this.appSession = portletSession;
	}
}
