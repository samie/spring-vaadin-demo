package demo;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import demo.backend.GPSRepository;
import demo.backend.GPSUpdate;
import org.springframework.beans.factory.annotation.Autowired;

/** Fullscreen list display of GPSUpdate objects from the GPSRepository.
 *
 * Created by se on 29/04/15.
 */
@UIScope
@SpringView(name="")
public class ListView extends CustomComponent implements View {

    @Autowired
    GPSRepository repo;

    private Table table = new Table();

    public ListView() {
        setSizeFull();
        table.setSizeFull();
        setCompositionRoot(table);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Container container = new BeanItemContainer<GPSUpdate>(GPSUpdate.class,repo.findAll());
        table.setContainerDataSource(container);
    }



}
