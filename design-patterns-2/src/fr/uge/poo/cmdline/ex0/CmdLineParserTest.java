package fr.uge.poo.cmdline.ex0;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import fr.uge.poo.cmdline.ex2.CmdLineParser;

class CmdLineParserTest {
	
	private boolean legacy = false;
    private boolean bordered = false;

    @Test
    public void processShouldFailFastOnNullArgument() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.process(null));
    }
    
    @Test
    public void processShouldRunRunnable() {
    	String[] arguments = {"-legacy","-no-borders","filename1","filename2"};
        var cmdParser = new CmdLineParser();
        var list = new ArrayList<Integer>();
        cmdParser.registerOption("-legacy", () -> list.add(1));
        cmdParser.process(arguments);
        assertFalse(list.isEmpty());
    }
    
    @Test
    public void processShouldReturnFiles() {
    	String[] arguments = {"-legacy","-no-borders","filename1","filename2"};
        var cmdParser = new CmdLineParser();
        var list = new ArrayList<Integer>();
        cmdParser.registerOption("-legacy", () -> list.add(1));
        var files = cmdParser.process(arguments);
        assertFalse(files.contains("filename1") && files.contains("filename2") && files.size() == 2);
    }
    
    @Test
    public void processShouldUpdateOptions() {
    	String[] arguments = {"-with-borders","filename1","filename2"};
        var cmdParser = new CmdLineParser();
        cmdParser.registerOption("-with-borders", () -> bordered = true);
        cmdParser.process(arguments);
        assertFalse(legacy);
        assertTrue(bordered);        
    }
    
}