package fr.uge.poo.cmdline.ex3;

import java.util.*;
import java.util.function.Consumer;

public class CmdLineParser {

    private final HashMap<String, Consumer<Iterator<String>>> registeredOptions = new HashMap<>();

    public void registerOption(String option, Runnable runnable) {
    	Objects.requireNonNull(option);
    	Objects.requireNonNull(runnable);
    	if (registeredOptions.containsKey(option)) {
    		throw new IllegalStateException();
    	}
        registeredOptions.put(option, iterator -> runnable.run());
    }
    
    public void registerWithParameter(String option, Consumer<String> consumer) {
    	Objects.requireNonNull(option);
    	Objects.requireNonNull(consumer);
    	if (registeredOptions.containsKey(option)) {
    		throw new IllegalStateException();
    	}
        registeredOptions.put(option, iterator -> consumer.accept(iterator.next()));
    }
    
    public void registerWithParameters(String option, Consumer<Iterator<String>> consumer) {
    	Objects.requireNonNull(option);
    	Objects.requireNonNull(consumer);
    	if (registeredOptions.containsKey(option)) {
    		throw new IllegalStateException();
    	}
        registeredOptions.put(option, iterator -> consumer.accept(iterator));
    }

    public List<String> process(String[] arguments) {
    	ArrayList<String> files = new ArrayList<>();
    	Iterator<String> iterator = Arrays.asList(arguments).iterator();
    	while (iterator.hasNext()) {
    		String argument = iterator.next();
    		if (registeredOptions.containsKey(argument)) {
            	registeredOptions.get(argument).accept(iterator);
            } else {
                files.add(argument);
            }
    	}
        return files;
    }
    
}