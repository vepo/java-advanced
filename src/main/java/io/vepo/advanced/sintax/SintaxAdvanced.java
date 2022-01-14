package io.vepo.advanced.sintax;

public class SintaxAdvanced {

    public static class Par {
        private Object primeira;
        private Object segunda;
    
        private Par(Object primeira, Object segunda) {
            this.primeira = primeira;
            this.segunda = segunda;
        }
    
        public Object getPrimeira() {
            return primeira;
        }
    
        public Object getSegunda() {
            return segunda;
        }
    }
}
