import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Hero hero = new Hero();
        addObject(hero,112,136);
        hero.setLocation(292,322);

        spawnZombie();
        hero.setLocation(297,182);
        hero.setLocation(409,274);
    }
    
    private void spawnZombie()
    {
        for (int i = 0; i < 4; i++) //Este es para el numero de enemigos que aparecen
        {
            Zombie zombie = new Zombie();
            int side = Greenfoot.getRandomNumber(4);
            int x, y;
            if (side == 0) {
                x = Greenfoot.getRandomNumber(getWidth());
                y = 0;
            }
            else if (side == 1)
            {
                x = Greenfoot.getRandomNumber(getWidth());
                y = getHeight() - 1;
            }
            else if (side == 2)
            {
                x = 0;
                y = Greenfoot.getRandomNumber(getHeight());
            }
            else
            {
                x = getWidth() -1;
                y = Greenfoot.getRandomNumber(getHeight());
            }
            addObject(zombie, x, y);
        }
    }
}
