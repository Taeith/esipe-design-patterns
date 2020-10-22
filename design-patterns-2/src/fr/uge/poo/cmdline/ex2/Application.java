package fr.uge.poo.cmdline.ex2;

public class Application {
	
    static private class PaintOptions {
        private boolean legacy=false;
        private boolean bordered=true;
        private int borderWidth = 0;
        private String borderName = "";

        public void setLegacy(boolean legacy) {
            this.legacy = legacy;
        }

        public boolean isLegacy(){
            return legacy;
        }

        public void setBordered(boolean bordered){
            this.bordered=bordered;
        }

        public boolean isBordered(){
            return bordered;
        }

        public int getBorderWidth() {
			return borderWidth;
		}

		public void setBorderWidth(int borderWidth) {
			this.borderWidth = borderWidth;
		}

		public String getBorderName() {
			return borderName;
		}

		public void setBorderName(String borderName) {
			this.borderName = borderName;
		}

		@Override
        public String toString(){
            return "PaintOption [ bordered = "+bordered+", legacy = "+ legacy +" ]";
        }
    }
    
}
