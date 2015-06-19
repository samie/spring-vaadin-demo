package demo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CustomComponent;
import demo.backend.GPSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.LPolyline;
import org.vaadin.addon.leaflet.shared.Point;

import java.util.List;
import java.util.stream.Collectors;

/** Fullscreen map display of GPSUpdate objects from the GPSRepository.
 *
 * Created by se on 29/04/15.
 */
@UIScope
@SpringView(name="map")
public class MapView extends CustomComponent implements View {

    @Autowired
    GPSRepository repo;

    private LMap map = new LMap();
    private LPolyline track = new LPolyline();

    public MapView() {
        map.addLayer(new LOpenStreetMapLayer());
        map.addLayer(track);
        setSizeFull();
        map.setSizeFull();
        setCompositionRoot(map);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        List<Point> list = repo.findAll().stream().map(u -> {
            return new Point(u.getLat(), u.getLon());
        }).collect(Collectors.toList());
        track.setPoints(list);
        map.zoomToContent();
    }
}
