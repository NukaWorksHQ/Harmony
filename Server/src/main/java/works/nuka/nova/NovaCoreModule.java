package works.nuka.nova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import works.nuka.modularkit.ModularModule;
import works.nuka.modularkit.ModuleConfigModel;
import works.nuka.modularkit.ex.ModRegisterEx;
import works.nuka.modularkit.ex.ModUuidEx;

@SpringBootApplication
public class NovaCoreModule extends ModularModule {
    private ConfigurableApplicationContext springContext;

    public NovaCoreModule() throws ModUuidEx, ModRegisterEx {
        super();
    }

    public NovaCoreModule(ModuleConfigModel configModel) throws ModUuidEx, ModRegisterEx {
        super(configModel);
    }

    @Override
    protected void start() {
        System.out.println("Hello " + this.getModuleConfig().getName() + " !");
        this.springContext = new SpringApplicationBuilder(NovaCoreModule.class)
                .web(WebApplicationType.SERVLET) // Explicitly enable web server
                .run();
    }

    @Override
    protected void stop() {
        System.out.println("Stopping spring app on " + this.getModuleConfig().getName() + "...");
        if (springContext != null && springContext.isActive()) {
            springContext.close();
        }
    }

    @Override
    protected void load() {
        System.out.println("Loaded " + this.getModuleConfig().getName() + " !");
    }

    @Override
    protected void unload() {
        System.out.println("Unloaded " + this.getModuleConfig().getName() + " !");
    }
}
