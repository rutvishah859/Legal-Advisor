package legaladvisor;

public class willEstate extends Civil {
    
    private boolean assets;
    private boolean deceased;
    private boolean hasWill;
    
    public willEstate(String rem, String typ, String jur, String tC, boolean asset, boolean dec, boolean hW) {
        super(rem, typ, jur, tC);
        this.assets = asset;
        this.deceased = dec;
        this.hasWill = hW;
    }

    public boolean isAssets() {
        return assets;
    }

    public void setAssets(boolean assets) {
        this.assets = assets;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }

    public boolean isHasWill() {
        return hasWill;
    }

    public void setHasWill(boolean hasWill) {
        this.hasWill = hasWill;
    }
    
}
