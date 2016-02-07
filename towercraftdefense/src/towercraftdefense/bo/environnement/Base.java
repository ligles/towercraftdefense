package towercraftdefense.bo.environnement;

import towercraftdefense.bo.biosphere.Ouvrier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.manager.ZoneManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Base extends Structure {
    
    int ressources;
    ArrayList<Ouvrier> ouvriers;

    public Base(int ressources, Plan plan)
    {
        super(plan);
        this.ressources = ressources;
        this.ouvriers = new ArrayList<>();
        this.img = towercraftdefense.ressources.Ressource.loadImage("base.png");
    }    
    
    public static Zone getBaseZone() {
        Zone baseZone;
        ArrayList<Zone> baseZones = ZoneManager.zonesBase();
        List<Zone> baseValidZones;
        
        // Vérification si la zone trouvée peut bien acceuillir la base
        baseValidZones = baseZones.stream()
                .filter(zone -> Plan.validPlan(Plan.planBase(zone), new Base(0, null)))
                .collect(Collectors.toList());
        
        baseZone = baseValidZones.get(75);
        
        return baseZone;
    }
    
}
