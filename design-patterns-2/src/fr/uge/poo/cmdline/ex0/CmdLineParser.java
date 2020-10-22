package fr.uge.poo.cmdline.ex0;

import java.util.*;

public class CmdLineParser {

    private final HashMap<String, Runnable> registeredOptions = new HashMap<>();

    public void registerOption(String option, Runnable runnable) {
    	if (registeredOptions.containsKey(option)) {
    		throw new IllegalStateException();
    	}
        registeredOptions.put(Objects.requireNonNull(option), Objects.requireNonNull(runnable));
    }

    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        for (String argument : arguments) {
            if (registeredOptions.containsKey(argument)) {
            	registeredOptions.get(argument).run();
            } else {
                files.add(argument);
            }
        }
        return files;
    }
    
}