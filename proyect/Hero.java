import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor

{int speed = 3;
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        turnAround();
        moveAround();
        shoot();
    }
    public void turnAround()
    {
       if (Greenfoot.getMouseInfo()!= null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX() - speed,getY());
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX() + speed,getY());
    }
    public void shoot()
    {
        if(Greenfoot.mousePressed(null))
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile,getX(),getY());
            projectile.setRotation(getRotation());
        }
        
    }
    
}
