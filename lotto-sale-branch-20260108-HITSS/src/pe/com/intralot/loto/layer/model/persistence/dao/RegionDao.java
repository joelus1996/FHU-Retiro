package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;
import pe.com.intralot.loto.layer.model.domain.Region;

public interface RegionDao {

	public List<Region> findRegion() throws Exception;
}
