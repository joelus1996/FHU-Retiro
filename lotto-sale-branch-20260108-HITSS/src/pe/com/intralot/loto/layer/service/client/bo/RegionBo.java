package pe.com.intralot.loto.layer.service.client.bo;

import java.util.List;
import pe.com.intralot.loto.layer.model.domain.Region;

public interface RegionBo {
	public List<Region> findRegion() throws Exception;
}
