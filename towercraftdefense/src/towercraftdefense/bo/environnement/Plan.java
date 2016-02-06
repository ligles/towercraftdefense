/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo.environnement;

import java.awt.Rectangle;
import java.util.ArrayList;
import towercraftdefense.bo.Zone;
import towercraftdefense.enumeration.Style;
import towercraftdefense.manager.ZoneManager;

/**
 *
 * @author mehdi
 */

public class Plan {
    private ArrayList<Zone> zones;
    private ArrayList<Rectangle> rectangles;
    private int width;
    private int height;
    
    public Plan(){
        this.zones = new ArrayList<>();
        this.rectangles = new ArrayList<>();
        this.width = 0;
        this.height = 0;
    }
    
    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }
    
    public void generate(){
        int minX = rectangles.get(0).x;
        int minY = rectangles.get(0).y;
        int maxX = rectangles.get(0).x + rectangles.get(0).width;
        int maxY = rectangles.get(0).y + rectangles.get(0).height;
        for(Rectangle rectangle : rectangles){
            for(int y = (int)rectangle.y ; y < (rectangle.height + (int)rectangle.y) ; y += Zone.size){
                for(int x = (int)rectangle.x ; x < (rectangle.width + (int)rectangle.x) ; x += Zone.size){
                    Zone zone = ZoneManager.getZone(x, y);
                    if(zone != null)
                        zones.add(zone);
                }
            }
            if(rectangle.x < minX)
                minX = rectangle.x;
            if(rectangle.y < minY)
                minY = rectangle.y;
            if((rectangle.x + rectangle.width) > maxX)
                maxX = rectangle.x + rectangle.width;
            if(rectangle.y + rectangle.height > maxY)
                maxY = rectangle.y + rectangle.height;
        }
        this.width  = maxX - minX;
        this.height = maxY - minY;
    }
    
    
    public boolean build() {
        boolean buildable = !zones.isEmpty() && Structure.validBuild(this);
        if(buildable){
            zones.stream().forEach((zone) -> {
                if(zone != null){
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isFree = false;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isBuildable = false;
                }
            });
        }
        return buildable;
    }
    
    public boolean way() {
        boolean wayable = !zones.isEmpty() && Chemin.validWay(this);
        if(wayable){
            zones.stream().forEach((zone) -> {
                if(zone != null){
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isFree = true;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isWalkable = true;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isBuildable = false;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).setStyle(Style.Chemin);
                }
            });
        }
        return wayable;
    }
    
    public boolean mine(){
        boolean farmable = !zones.isEmpty() && Ressource.validRessource(this);
        if(farmable){
            zones.stream().forEach((zone) -> {
                if(zone != null){
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isFree = false;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isWalkable = false;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isBuildable = false;
                    ZoneManager.getZone((int)zone.x, (int)zone.y).isFarmable = true;
                }
            });
        }
        return farmable;
    }
    
    public ArrayList<Zone> getZones() {
        return zones;
    }

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public static Plan planBase(Zone zone){
        Plan plan = new Plan();  
        plan.addRectangle(new Rectangle((int)zone.x, (int)zone.y, Zone.size(4), Zone.size(3)));
        plan.generate();
        return plan;
    }
    
    public static Plan planTour(Zone zone){
        Plan plan = new Plan();
        plan.addRectangle(new Rectangle((int)zone.x, (int)zone.y, Zone.size(2), Zone.size(3)));
        plan.generate();
        return plan;
    }
    
    public static Plan planRessource(Zone zone){
        Plan plan = new Plan();
        plan.addRectangle(new Rectangle((int)zone.x, (int)zone.y, Zone.size(2), Zone.size(2)));
        plan.generate();
        return plan;
    }
    
    public static boolean validPlan(Plan plan){
        boolean avaible = true;
        plan.generate();
        if(plan.getZones() != null && plan.getZones().size() > 0){
            for(Zone zone : plan.getZones()){
                if(zone != null){
                    Zone zoneMap = ZoneManager.getZone((int)zone.x, (int)zone.y);
                    if(zoneMap == null || !zoneMap.isFree)
                        avaible = false;
                }
                else avaible = false;
            }
        }
        else
            avaible = false;
        return avaible;
        
    }

}
