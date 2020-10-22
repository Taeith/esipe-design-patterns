package fr.uge.poo.cmdline.ex3;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CmdLineParserTest {
	
	private boolean legacy = false;
    private boolean bordered = false;
    private int borderWidth = 0;
    private String borderName = "";
    private int x = 0;
    private int y = 0;

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
    
    @Test
    public void processShouldUpdateOptionsWithOneParameter() {
    	String[] arguments = {"-legacy","-border-width","500","-window-name","minecraft","filename1","filename2"};
        var cmdParser = new CmdLineParser();
        cmdParser.registerOption("-legacy", () -> legacy = true);
        cmdParser.registerWithParameter("-border-width",  borderWidth -> this.borderWidth = Integer.parseInt(borderWidth));
        cmdParser.registerWithParameter("-window-name", borderName -> this.borderName = String.valueOf(borderName));
        cmdParser.process(arguments);
        assertEquals(500, borderWidth);
        assertEquals("minecraft", borderName);
    }
    
    @Test
    public void processShouldUpdateOptionsWithParameters() {
    	String[] arguments = {"-legacy", "-position", "69", "420"};
        var cmdParser = new CmdLineParser();
        cmdParser.registerWithParameters("-position", iterator -> {
        	x = Integer.parseInt(iterator.next());
        	y = Integer.parseInt(iterator.next());
        });
        cmdParser.process(arguments);
        assertEquals(69, x);
        assertEquals(420, y);
    }

}