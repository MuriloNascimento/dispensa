package elish.dispensa.convertion;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import elish.dispensa.entidades.Setor;
import elish.dispensa.service.SetoreService;

@Component
public class SetorConvertion implements Converter {
	
	@Inject
	SetoreService ss;

	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		return ss.buscarPorId(Integer.parseInt(id));
	}

	public String getAsString(FacesContext context, UIComponent component, Object setor) {
		Setor s = (Setor) setor;
		return Integer.toString(s.getId());
	}

}
