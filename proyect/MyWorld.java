import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Atributos para el juego
    private int numeroZombies = 3; // número inicial de zombies
    private int hordaTimer = 0; // el timer para la aparición de hordas
    private boolean hordaCompletada = false;

    // Atributos para el héroe y otros objetos del juego
    Hero hero = new Hero();
    Projectile projectile = new Projectile();
    Counter counter = new Counter();

    // Atributo para la música de fondo
    private GreenfootSound backgroundMusic = new GreenfootSound("flame.wav"); // Cambia "nombre_del_archivo.mp3" por el nombre de tu archivo

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Crea un nuevo mundo con 800x650 celdas con un tamaño de celda de 1x1 píxeles.
        super(800, 650, 1); 

        prepare();
        addObject(counter, 100, 50);
        
        // Reproduce la música de fondo en bucle
        backgroundMusic.playLoop();
    }

    /**
     * Prepara el mundo para el inicio del programa.
     * Es decir: crea los objetos iniciales y los añade al mundo.
     */
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero, 112, 136);
        hero.setLocation(292, 322);

        spawnHorda();
        hero.setLocation(297, 182);
        hero.setLocation(409, 274);
        addObject(hero, 324, 258);
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
            numeroZombies++; // Esto incrementa el número de zombies
            spawnHorda();
            hordaCompletada = false;
        }
    }

    private void spawnHorda()
    {
        for (int i = 0; i < numeroZombies; i++)
        {
            Zombie zombie = new Zombie(hero, projectile, counter);    
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
                x = getWidth() - 1;
                y = Greenfoot.getRandomNumber(getHeight());
            }
            addObject(zombie, x, y);
        }
    }

    // Método llamado cuando el juego se detiene
    public void stopped()
    {
        backgroundMusic.stop();
    }
    
    // Método llamado cuando el juego se reanuda
    public void started()
    {
        backgroundMusic.playLoop();
    }
}
