package works.nuka.nova;

import works.nuka.modularkit.ModularModule;
import works.nuka.modularkit.ModularSource;
import works.nuka.modularkit.ModuleConfigModel;
import works.nuka.modularkit.ex.ModRegisterEx;
import works.nuka.modularkit.ex.ModSourceEx;
import works.nuka.modularkit.ex.ModUuidEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) throws ModUuidEx, ModRegisterEx, ModSourceEx {
        ModularSource source = new ModularSource("5278b09a");

        String jsonFile;
        InputStream file = TestMain.class.getResourceAsStream("/module.json");
        if (file == null) {
            throw new IllegalStateException("module.json not found in resources");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            jsonFile = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException("Error reading module.json", e);
        }

        ModuleConfigModel configModel = new ModuleConfigModel();
        configModel.serialize(jsonFile);

        ModularModule module = new NovaCoreModule(configModel);
        source.registerModule(module);
        source.getModuleManager().runModule(module, null);
    }
}
