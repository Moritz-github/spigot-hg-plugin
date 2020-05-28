package com.imdrops.xhg;
import com.imdrops.xhg.kits.Kit;
import com.imdrops.xhg.kits.*;

import java.util.ArrayList;

public class KitManager {
    private ArrayList<Class> kits;

    KitManager(){
        kits = new ArrayList<Class>();
        kits.add(NoKit.class);
        kits.add(Runner.class);
        kits.add(Sneaky.class);
    }

    public Class getKitClassFromString(String kitString){
        for (Class kitClass : this.kits){
            if (kitClass.getSimpleName().equalsIgnoreCase(kitString)){
                return kitClass;
            }
        }
        return null;
    }

    public ArrayList<Class> getKits(){
        return this.kits;
    }


}
