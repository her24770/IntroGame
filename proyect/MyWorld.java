import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //private int zombieVel = 1; //velocidad inicial de zombies
    private int numeroZombies = 3; //numero inicial de zombies
    private int hordaTimer = 0; //el timer para la aparicion de hordas
    private boolean hordaCompletada = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Hero hero = new Hero();
    Projectile projectile = new Projectile();
    Counter counter = new Counter();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(800, 650, 1); 

        prepare();
        addObject(counter,100, 50);
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

        spawnHorda();
        hero.setLocation(297,182);
        hero.setLocation(409,274);
        addObject(hero,324,258);
        
    }
    
    public void act()
    {
        if (getObjects(Zombie.class).isEmpty() && !hordaCompletada)
        {
            hordaCompletada = true;
            hordaTimer = 120; // estos son 2 segundos. 60 por cada segundo
        }
        
        if (hordaCompletada && hordaTimer > 0)
        {
            hordaTimer--;
        }
        
        if (hordaCompletada && hordaTimer == 0) 
        {
            numeroZombies++; // Esto que incremente el numero de zombies
            spawnHorda();
            hordaCompletada = false;
        }
    }
    
    private void spawnHorda()
    {
        for (int i = 0; i < numeroZombies; i++)
        {
            Zombie zombie = new Zombie(hero,projectile, counter);    
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
