package fr.uge.poo.cmdline.ex0;

public class Application {

    static private class PaintOptions{
        private boolean legacy=false;
        private boolean bordered=true;

        public void setLegacy(boolean legacy) {
            this.legacy = legacy;
        }

        public void setBordered(boolean bordered){
            this.bordered=bordered;
        }

        @Override
        public String toString(){
            return "PaintOption [ bordered = "+bordered+", legacy = "+ legacy +" ]";
        }
    }

    public static void main(String[] args) {
    	String[] arguments={"-legacy","-no-borders","filename1","filename2"};
        var options = new PaintOptions();        
        var cmdParser = new CmdLineParser();
        cmdParser.registerOption("-legacy", () -> options.setLegacy(true));
        cmdParser.registerOption("-with-borders", () -> options.setBordered(true));
        cmdParser.registerOption("-no-borders", () -> options.setBordered(false));
        cmdParser.process(arguments);
    }
}
