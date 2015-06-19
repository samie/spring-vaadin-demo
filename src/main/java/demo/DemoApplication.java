package demo;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;
import demo.backend.GPSUpdate;
import in.virit.WidgetSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public WidgetSet getAddonCDNWidgetSet() {
        return new WidgetSet();
    }

    @Theme("valo")
    @SpringUI(path = "")
    @Push
    public static class VaadinUI extends UI {

        @Override
        protected void init(VaadinRequest request) {
        }

        @Autowired
        public void configureNavigator(SpringViewProvider viewProvider, GPSUpdateEventHandler updateHandler) {
            Navigator navigator = new Navigator(this,this);
            navigator.addProvider(viewProvider);
            navigator.addViewChangeListener(updateHandler);
        }
    }

    @Component
    @RepositoryEventHandler(GPSUpdate.class)
    public static class GPSUpdateEventHandler implements ViewChangeListener {

        private View activeView;

        @HandleAfterCreate
        public void handleGPSUpdateCreate(GPSUpdate u) {
            // Send update to the active activeView if present
            if (activeView != null){
                // We need to lock the UI during the access. This does it.
                ((CustomComponent) activeView).getUI().access(() -> {
                    activeView.enter(null);
                });
            }
        }

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            activeView = null;
            return true;
        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {
            activeView = event.getNewView();
        }
    }

}
