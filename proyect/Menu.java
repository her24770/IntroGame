import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    Flecha flecha = new Flecha();
    private int opcion=0;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepararMundo();
        prepare();
    }

    private void prepararMundo(){
        addObject(new jugar(), 370, 250);
        addObject(new personaje(), 400, 350); //por ahora solamente termina el juego
        addObject(flecha, 275, 250);
    }

    public void act(){
        if (Greenfoot.isKeyDown("UP") && opcion!=0) { 
            opcion++;
        }
        if (Greenfoot.isKeyDown("DOWN") && opcion!=1) {
            opcion--;
        }

        if (opcion>=2) opcion=0;
        if (opcion<0) opcion=1;

        flecha.setLocation(275, 250 +(opcion*100));

        if (Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
            switch(opcion){
                case 0:
                    Greenfoot.setWorld(new MyWorld());
                    break;
                case 1:
                    Greenfoot.stop();
                    break;
            }
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
