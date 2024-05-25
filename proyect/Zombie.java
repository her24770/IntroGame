import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Projectile projectile;
    Counter counter;
   public Zombie(Hero hero, Projectile projectile, Counter counter)
   {
       this.counter = counter;
   }
   public void act()
    {
        // Add your action code here.
        moverHaciaHeroe();
        colisionHeroe();
        colisionBala();
    }
    private void moverHaciaHeroe()
    {
        Hero hero = (Hero)getWorld().getObjects(Hero.class).get(0);
        if (hero != null)
        {
            int heroX = hero.getX();
            int heroY = hero.getY();
            turnTowards(heroX, heroY);
            move(1); //Esto es para su velocidad
        }
    }

    private void colisionHeroe()
    {
        if (isTouching(Hero.class))
        {
            Hero hero = (Hero)getOneIntersectingObject(Hero.class);
            if (hero != null)
            {
                getWorld().removeObject(hero);
                Greenfoot.setWorld(new Menu()); // este seria para que todo se pare cuando el personaje muera
            }
        }
    }
    
    private void colisionBala() //Esto elimina a la bala cuando colisionan
    {
        if (isTouching(Projectile.class))
        {
            Projectile projectile = (Projectile)getOneIntersectingObject(Projectile.class);
            if (projectile != null)
            {
                getWorld().removeObject(projectile);
                getWorld().removeObject(this);//Esto elimina la bala luego de impactar
                counter.score ++;
            }
        }
    }
}